package miphi.project.models;

import miphi.project.interfaces.IUser;

public class User implements IUser {
    private final String userName;
    private final String passwordHash;
    private final Wallet wallet;

    public User(String userName, String passwordHash) {
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }
}