package miphi.project.interfaces;

public interface IWallet {
    double getBalance();
    void addIncome(double amount);
    boolean addExpense(double amount);
}
