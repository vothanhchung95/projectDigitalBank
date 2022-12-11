package vn.funix.fx17970.java.asm02;

import java.util.*;

public class Customer extends User {
    Scanner sc = new Scanner(System.in);
    public Customer() {
    }
    private List<Account> accounts = new ArrayList<Account>();

    // Hàm addAccount: thêm tài khoản cho khách hàng
    public void addAccount() {
        Account newAccount = new Account();
        System.out.println("Nhap ma STK gom 6 chu so: ");
        int index = -1;
        try {
            newAccount.setAccountNumber();
            for (int i = 0; i < accounts.size(); i++){
                if (Objects.equals(newAccount.getAccountNumber(), accounts.get(i).getAccountNumber())) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                System.out.println("So tai khoan da ton tai");
                addAccount();
            }
            else {
                System.out.println("Nhap so du: ");
                try {
                    newAccount.setBalance();
                    accounts.add(newAccount);
                } catch (InputMismatchException e) {
                    System.out.println("Ban nhap so du khong dung dinh dang.");
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Ma STK khong hop le.");
        }
    }

    // Hàm in thông tin tài khoản của người dùng
    public void displayInformation() {
        // Chạy vòng lặp for trong List Account để in toàn bộ thông tin tài khoản khách hàng
        for (int i = 0; i < accounts.size(); i++) {
            String accountBalance = String.format("%,d", accounts.get(i).getBalance());
            System.out.println((i+1) + "    " + accounts.get(i).getAccountNumber() + "    |                     " + accountBalance + "đ");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // Hàm kiểm tra tài khoản khách hàng là Premium hay Normal
    public String isPremium() {
        String checkPremium = "Normal";
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).isPremium()) {
                checkPremium = "Premium";
            }
        }
        return checkPremium;
    }

    // Hàm tính tổng số dư trong tài khoản về return kết quả về String
    public String sumBalance() {
        long sumBalance = 0L;
        for (int i = 0; i < accounts.size(); i++) {
            sumBalance += accounts.get(i).getBalance();
        }
        String sumBalanceStr = String.format("%,d", sumBalance);
        return sumBalanceStr;
    }
}
