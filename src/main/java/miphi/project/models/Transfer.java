package miphi.project.models;

import java.util.ArrayList;
import java.util.List;

public class Transfer {
    private final List<String> transferHistory = new ArrayList<>();

    /**
     * Выполняет перевод средств от одного пользователя другому.
     *
     * @param sender   Отправитель.
     * @param recipient Получатель.
     * @param amount    Сумма перевода.
     * @return true, если перевод успешен, иначе false.
     */
    public boolean execute(User sender, User recipient, double amount) {
        if (amount <= 0) {
            transferHistory.add("Не удалось перевести: некорректная сумма " + amount);
            return false;
        }

        Wallet senderWallet = sender.getWallet();
        Wallet recipientWallet = recipient.getWallet();

        if (senderWallet.getBalance() < amount) {
            transferHistory.add("Не удалось перевести: недостаточно средств у " + sender.getUsername());
            return false;
        }

        senderWallet.decreaseBalance(amount);
        recipientWallet.increaseBalance(amount);

        transferHistory.add(String.format("Перевод %.2f от %s к %s успешно выполнен.", amount, sender.getUsername(), recipient.getUsername()));
        return true;
    }

    /**
     * Возвращает историю переводов.
     *
     * @return Список строк с записями о переводах.
     */
    public List<String> getHistory() {
        return new ArrayList<>(transferHistory);
    }
}