package miphi.project.models;

public class Income extends Transaction {

    public Income(String category, double amount) {
        super(category, amount);
    }

    @Override
    public String getTransactionType() {
        return "Доход";
    }
}
