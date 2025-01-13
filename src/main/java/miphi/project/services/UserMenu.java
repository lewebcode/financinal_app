package miphi.project.services;

import java.util.*;

import miphi.project.Main;
import miphi.project.models.User;
import miphi.project.models.Wallet;

public class UserMenu {
    public static void userMenu(Scanner scanner, User currentUser) {
        while (true) {
            printUserMenu();
            int choice = InputUtil.readIntegerInput(scanner, "Выберите опцию: ");

            switch (choice) {
                case 1 -> handleAddIncome(scanner, currentUser.getWallet());
                case 2 -> handleAddExpense(scanner, currentUser.getWallet());
                case 3 -> System.out.printf("Текущий баланс кошелька: %.2f%n", currentUser.getWallet().getBalance());
                case 4 -> displayStatistics(currentUser.getWallet());
                case 5 -> handleSetBudget(scanner, currentUser.getWallet());
                case 6 -> handleTransferFunds(scanner, currentUser);
                case 7 -> {
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
        System.out.println("4. Посмотреть статистику бюджета");
        System.out.println("5. Установить бюджет");
        System.out.println("6. Перевести средства");
        System.out.println("7. Выйти");
    }

    private static void handleTransferFunds(Scanner scanner, User sender) {
        System.out.print("Введите имя получателя: ");
        String recipientName = scanner.nextLine().trim();

        System.out.print("Введите сумму для перевода: ");
        double amount = InputUtil.readDoubleInput(scanner, "Сумма: ");

        // Здесь предполагается, что существует метод для поиска пользователя
        User recipient = findUserByName(recipientName);
        if (recipient == null) {
            System.out.println("Пользователь не найден.");
            return;
        }

        if (sender.transferFunds(recipient, amount)) {
            System.out.printf("Успешный перевод %.2f от %s к %s.%n", amount, sender.getUsername(), recipient.getUsername());
        } else {
            System.out.println("Не удалось выполнить перевод. Проверьте баланс.");
        }
    }

    private static User findUserByName(String name) {
        // Примерная логика; предполагается, что список пользователей доступен глобально
        return Main.getUsers().get(name); // Используйте свою структуру хранения пользователей
    }

    private static void handleAddIncome(Scanner scanner, Wallet wallet) {
        System.out.print("Введите категорию дохода: ");
        String category = scanner.nextLine().trim();
        double amount = InputUtil.readDoubleInput(scanner, "Введите сумму дохода: ");
        wallet.addIncome(category, amount);
        System.out.println("Доход успешно добавлен.");
    }

    private static void handleAddExpense(Scanner scanner, Wallet wallet) {
        System.out.print("Введите категорию расхода: ");
        String category = scanner.nextLine().trim();
        double amount = InputUtil.readDoubleInput(scanner, "Введите сумму расхода: ");
        if (!wallet.addExpense(category, amount)) {
            System.out.println("Недостаточно средств.");
            return;
        }
        System.out.println("Расход успешно добавлен.");
    }

    private static void handleSetBudget(Scanner scanner, Wallet wallet) {
        System.out.print("Введите категорию для бюджета: ");
        String category = scanner.nextLine().trim();
        double budget = InputUtil.readDoubleInput(scanner, "Введите сумму бюджета: ");
        wallet.setBudget(category, budget);
        System.out.println("Бюджет успешно установлен.");
    }

    private static void displayStatistics(Wallet wallet) {
        System.out.printf("Общий доход: %.2f%n", wallet.getTotalIncome());
        System.out.printf("Общие расходы: %.2f%n", wallet.getTotalExpenses());
        wallet.displayBudgets();
    }
}