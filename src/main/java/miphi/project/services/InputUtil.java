package miphi.project.services;

import java.util.Scanner;

public class InputUtil {
    public static int readIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите корректное число.");
            }
        }
    }

    public static double readDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите корректное число.");
            }
        }
    }
}