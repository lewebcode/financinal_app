package miphi.project.interfaces;

import miphi.project.models.Wallet;

public interface IUser {
    String getUsername();
    boolean verifyPassword(String passwordHash);
    Wallet getWallet();
}
