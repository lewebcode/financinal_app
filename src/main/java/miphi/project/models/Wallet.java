package miphi.project.models;

import miphi.project.interfaces.IWallet;

import java.util.*;

public class Wallet implements IWallet {
    private double balance;
    private final List<Expense> expenses = new ArrayList<>();
    private final List<Income> incomes = new ArrayList<>();
    private final Map<String, Double> budgets = new HashMap<>();

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addIncome(String category, double amount) {
        incomes.add(new Income(category, amount));
        balance += amount;
    }

    @Override
    public boolean addExpense(String category, double amount) {
        if (amount > balance) {
            return false;
        }
        expenses.add(new Expense(category, amount));
        balance -= amount;
        return true;
    }

    @Override
    public void setBudget(String category, double budget) {
        budgets.put(category, budget);
    }

    @Override
    public Map<String, Double> calculateRemainingBudgets() {
        Map<String, Double> remainingBudgets = new HashMap<>(budgets);

        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double spent = expense.getAmount();

            remainingBudgets.merge(category, -spent, Double::sum);
        }
        return remainingBudgets;
    }

    @Override
    public double getTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    @Override
    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public void displayBudgets() {
        System.out.println("Бюджеты по категориям:");
        budgets.forEach((category, budget) -> {
            double remaining = calculateRemainingBudgets().getOrDefault(category, budget);
            System.out.printf("%s: Установлено %.2f, Остаток %.2f%n", category, budget, remaining);
        });
    }
}
