package miphi.project.service;

import java.util.*;

import miphi.project.Main;
import miphi.project.interfaces.*;
import miphi.project.models.Transfer;
import miphi.project.models.Wallet;

public class UserMenu {
    public static void userMenu(Scanner scanner, IUser user) {
        while (true) {
            printUserMenu();
            int choice = InputUtil.readIntegerInput(scanner, "Выберите опцию: ");

            switch (choice) {
                case 1 -> handleAddIncome(scanner, user.getWallet());
                case 2 -> handleAddExpense(scanner, user.getWallet());
                case 3 -> System.out.printf("Текущий баланс кошелька: %.2f%n", user.getWallet().getBalance());
                case 4 -> handleTransferFunds(scanner, user);
                case 5 -> {
                    System.out.println("Выход из аккаунта...");
                    return;
                }
                default -> System.out.println("Неверная опция. Попробуйте снова.");
            }
        }
    }

    private static void printUserMenu() {
        System.out.println("\nМеню пользователя:");
        System.out.println("1. Добавить доход");
        System.out.println("2. Добавить расход");
        System.out.println("3. Просмотреть баланс кошелька");
        System.out.println("4. Перевести средства");
        System.out.println("5. Выйти");
    }

    private static void handleAddIncome(Scanner scanner, Wallet wallet) {
        double amount = InputUtil.readDoubleInput(scanner, "Введите сумму дохода: ");
        if (amount <= 0) {
            System.out.println("Неверная сумма. Доход должен быть положительным.");
            return;
        }
        wallet.addIncome(amount);
        System.out.println("Доход успешно добавлен.");
    }

    private static void handleAddExpense(Scanner scanner, Wallet wallet) {
        double amount = InputUtil.readDoubleInput(scanner, "Введите сумму расхода: ");
        if (amount <= 0) {
            System.out.println("Неверная сумма. Расход должен быть положительным.");
            return;
        }
        if (!wallet.addExpense(amount)) {
            System.out.println("Недостаточно средств.");
            return;
        }
        System.out.println("Расход успешно добавлен.");
    }

    private static void handleTransferFunds(Scanner scanner, IUser sender) {
        System.out.print("Введите имя пользователя получателя: ");
        String recipientUsername = scanner.nextLine().trim();
        IUser recipient = Main.users.get(recipientUsername);
        if (recipient == null) {
            System.out.println("Получатель не найден.");
            return;
        }

        double amount = InputUtil.readDoubleInput(scanner, "Введите сумму перевода: ");
        Transfer transfer = new Transfer(sender.getWallet(), recipient.getWallet(), amount);
        if (transfer.execute()) {
            System.out.println("Перевод успешно выполнен.");
        } else {
            System.out.println("Ошибка перевода: недостаточно средств.");
        }
    }
}