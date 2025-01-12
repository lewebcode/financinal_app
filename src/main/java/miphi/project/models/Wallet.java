package miphi.project.models;

import miphi.project.interfaces.IWallet;

public class Wallet implements IWallet {
    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addIncome(double amount) {
        balance += amount;
    }

    @Override
    public boolean addExpense(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
