package miphi.project.interfaces;

import java.util.Map;

public interface IWallet {
    double getBalance();
    void addIncome(String category, double amount);
    boolean addExpense(String category, double amount);
    void setBudget(String category, double budget);
    Map<String, Double> calculateRemainingBudgets();
    double getTotalIncome();
    double getTotalExpenses();
}
