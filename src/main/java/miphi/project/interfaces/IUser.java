package miphi.project.interfaces;

import miphi.project.models.Wallet;

public interface IUser {
    boolean verifyPassword(String passwordHash);
    Wallet getWallet();
}
