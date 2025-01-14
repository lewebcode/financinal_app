package miphi.project.models;

import miphi.project.interfaces.IWallet;

import java.util.*;

public class Wallet implements IWallet {
    private double balance;
    private final List<Expense> expenses = new ArrayList<>();
    private final List<Income> incomes = new ArrayList<>();
    private final Map<String, Double> budgets = new HashMap<>();

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public boolean decreaseBalance(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void addIncome(String category, double amount) {
        incomes.add(new Income(category, amount));
        increaseBalance(amount);
    }

    public boolean addExpense(String category, double amount) {
        if (!decreaseBalance(amount)) {
            return false;
        }
        expenses.add(new Expense(category, amount));
        return true;
    }

    public void setBudget(String category, double budget) {
        budgets.put(category, budget);
    }

    public Map<String, Double> calculateRemainingBudgets() {
        Map<String, Double> remainingBudgets = new HashMap<>(budgets);

        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double spent = expense.getAmount();

            remainingBudgets.merge(category, -spent, Double::sum);
        }
        return remainingBudgets;
    }

    public double getTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}
