package vn.funix.fx17970.java.asm03;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Account {

    private SavingsAccount savingsAccount;
    private LoansAccount loansAccount;
    private List<LoansAccount> loansAccounts = new ArrayList<LoansAccount>();

    // Khai báo biến accountNumber, balance và isPremium
    private boolean isPremium;
    Scanner sc = new Scanner(System.in);
    private String accountNumber;
    private double balance;

    // Getter và Setter biến accountNumber và balance
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber() {
        String accountNumber = sc.next();
        // Kiểm tra accountNumber có hợp lệ hay không (có 6 ký tự và phải là số)
        if (accountNumber.length() == 6 && Integer.parseInt(accountNumber) >= 0) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("So tai khoan phai co 6 chu so. Vui long nhap lai: ");
            setAccountNumber();
        }
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Hàm kiểm tra tài khoản có phải là Premium hay không, return true or false
    public boolean isPremium() {
        return balance >= 10000000;
    }

    // Hàm trả về String loại tài khoản
    public String accountType() {
        return accountType();
    }

    // Hàm rút tiền withdraw()
    public boolean withdraw(double amount) {
        return withdraw(amount);
    }

    // Hàm kiểm tra điều kiện rút tiền
    public boolean isAccepted(double amount) {
        return isAccepted(amount);
    }
}
