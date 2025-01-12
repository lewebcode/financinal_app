package miphi.project;

import miphi.project.controller.InputUtilController;
import miphi.project.controller.SecurityUtilController;
import miphi.project.models.User;
import miphi.project.service.UserMenu;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static final Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = InputUtilController.readIntegerInput(scanner, "Выберите опцию: ");

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> {
                    System.out.println("Выход из приложения...");
                    return;
                }
                default -> System.out.println("Неверная опция. Попробуйте снова.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход");
        System.out.println("3. Выход");
    }

    private static void registerUser() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine().trim();
        if (users.containsKey(username)) {
            System.out.println("Имя пользователя уже существует. Попробуйте снова.");
            return;
        }

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Пароль не может быть пустым.");
            return;
        }

        String hashedPassword = SecurityUtilController.hashPassword(password);
        users.put(username, new User(username, hashedPassword));
        System.out.println("Регистрация успешна.");
    }

    private static void loginUser() {
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine().trim();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();
        String hashedPassword = SecurityUtilController.hashPassword(password);

        User user = users.get(username);
        if (user == null || !user.verifyPassword(hashedPassword)) {
            System.out.println("Неверные учетные данные. Попробуйте снова.");
            return;
        }

        System.out.println("Вход выполнен успешно. Добро пожаловать, " + username + "!");
        UserMenu.userMenu(scanner, user);
    }
}
