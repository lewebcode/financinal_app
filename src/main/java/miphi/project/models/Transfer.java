package miphi.project.models;

import miphi.project.interfaces.IExecute;

public class Transfer implements IExecute {
    private final Wallet sender;
    private final Wallet recipient;
    private final double amount;

    public Transfer(Wallet sender, Wallet recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        if (amount <= 0 || !sender.addExpense(amount)) {
            return false;
        }
        recipient.addIncome(amount);
        return true;
    }
}
