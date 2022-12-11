package vn.funix.fx17970.java.asm02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    // Khai báo biến accountNumber, balance và isPremium
    private boolean isPremium;
    Scanner sc = new Scanner(System.in);
    private String accountNumber;
    private long balance;

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

    public long getBalance() {
        return balance;
    }

    public void setBalance() {
        this.balance = sc.nextLong();
    }

    // Hàm kiểm tra tài khoản có phải là Premium hay không, return true or false
    public boolean isPremium() {
        if (this.balance < 10000000 ) {
            return this.isPremium = false;
        }
        return this.isPremium = true;
    }

}
