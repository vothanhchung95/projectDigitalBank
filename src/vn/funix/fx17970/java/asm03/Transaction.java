package vn.funix.fx17970.java.asm03;

import java.util.List;
import java.util.UUID;

public class Transaction extends Account {
    // Khai báo biến cho class Transaction
    private String id;
    private String accountNumber;
    private double amount;
    private boolean checkTransaction;
    private String dateTime;
    private List<Account> transactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter và Setter cho accountNumber và amount
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    // Getter và Setter cho trạng thái của Transaction
    public boolean isCheckTransaction() {
        return checkTransaction;
    }
    public void setCheckTransaction(boolean checkTransaction) {
        this.checkTransaction = checkTransaction;
    }


    // Getter và Setter dateTime
    public void dateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }
}
