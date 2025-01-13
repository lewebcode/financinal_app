package miphi.project.models;

import miphi.project.interfaces.IUser;

public class User implements IUser {
    private final String username;
    private final String passwordHash;
    private final Wallet wallet;

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.wallet = new Wallet();
    }

    @Override
    public boolean verifyPassword(String passwordHash) {
        return this.passwordHash.equals(passwordHash);
    }

    @Override
    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Перевод средств от текущего пользователя другому пользователю.
     *
     * @param recipient получатель средств.
     * @param amount    сумма перевода.
     * @return true, если перевод успешно выполнен.
     */
    public boolean transferFunds(User recipient, double amount) {
        if (wallet.getBalance() < amount) {
            return false;
        }
        wallet.addExpense("Перевод: " + recipient.getUsername(), amount);
        recipient.getWallet().addIncome("Перевод от: " + username, amount);
        return true;
    }
}