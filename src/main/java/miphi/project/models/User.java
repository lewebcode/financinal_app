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
}