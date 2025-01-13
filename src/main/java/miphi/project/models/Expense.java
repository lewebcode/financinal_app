package miphi.project.models;

/**
 * Класс для представления расхода.
 */
public class Expense extends Transaction {

    public Expense(String category, double amount) {
        super(category, amount);
    }

    @Override
    public String getTransactionType() {
        return "Расход";
    }
}
