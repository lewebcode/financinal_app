package miphi.project.models;

/**
 * Абстрактный класс, представляющий общую информацию о транзакции.
 */
public abstract class Transaction {
    private final String category;
    private final double amount;

    public Transaction(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    /**
     * Получить категорию транзакции.
     *
     * @return категория транзакции
     */
    public String getCategory() {
        return category;
    }

    /**
     * Получить сумму транзакции.
     *
     * @return сумма транзакции
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Абстрактный метод для отображения типа транзакции.
     *
     * @return тип транзакции
     */
    public abstract String getTransactionType();
}