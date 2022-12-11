package vn.funix.fx17970.java.asm03;

import java.sql.SQLOutput;
import java.util.*;

public class Customer extends User {
    Scanner sc = new Scanner(System.in);
    public Customer() {
    }
    private List<Account> accounts = new ArrayList<Account>();

    public List<Transaction> transactions = new ArrayList<>();

    // Hàm in thông tin tài khoản của người dùng
    public void displayInformation() {
        // Chạy vòng lặp for trong List Account để in toàn bộ thông tin tài khoản khách hàng
        for (int i = 0; i < accounts.size(); i++) {
            String accountBalance = String.format("%,d", (int) accounts.get(i).getBalance());
            System.out.println((i+1) + "     " + accounts.get(i).getAccountNumber() + "   |" + accounts.get(i).accountType() + "            " + accountBalance + "đ");
        }
    }
    // Hàm getAccounts
    public List<Account> getAccounts() {
        return accounts;
    }

    // Hàm kiểm tra tài khoản khách hàng là Premium hay Normal
    public String isPremium() {
        String checkPremium = "Normal";
        // Chạy vòng lặp và kiểm tra loại tài khoản
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

    // Hàm addLoansAccount() thêm tài khoản Loan vào Account
    public void addLoansAccount() {
        // Tạo newLoansAccount
        LoansAccount newLoansAccount = new LoansAccount();
        System.out.println("Nhap ma STK gom 6 chu so: ");
        int index = -1;
        try {
            // Nhập mã STK
            newLoansAccount.setAccountNumber();
            // Chạy hàm for để kiểm tra và lấy index nếu trùng
            for (int i = 0; i < accounts.size(); i++){
                if (Objects.equals(newLoansAccount.getAccountNumber(), accounts.get(i).getAccountNumber())) {
                    index = i;
                    break;
                }
            }
            // Thông báo STK đã tồn tại
            if (index >= 0) {
                System.out.println("So tai khoan da ton tai");
                addLoansAccount();
            }
            else {
                // Nhập số dư
                System.out.println("Nhap so du: ");
                long balance = sc.nextLong();
                newLoansAccount.setBalance(balance);
                    // Kiểm tra điều kiện số tiền nhập vào
                if (newLoansAccount.getBalance() <= newLoansAccount.getLOAN_ACCOUNT_MAX_BALANCE()) {
                    newLoansAccount.accountType();
                    accounts.add(newLoansAccount);
                }
                else {
                    // In ra thông báo nếu số tiền vượt quá hạn mức
                    System.out.println("So tien nhap vuot qua han muc.");
                }
            }
        }
        catch (NumberFormatException e) {
            // catch lỗi khi nhập STK không đúng định dạng
            System.out.println("Ma STK khong hop le.");
        }
    }

    // Hàm addSavingsAccount() thêm tài khoản Saving vào Account
    public void addSavingsAccount() {
        // Tạo newSavingsAccount
        SavingsAccount newSavingsAccount = new SavingsAccount();
        System.out.println("Nhap ma STK gom 6 chu so: ");
        int index = -1;
        try {
            // Nhập mã STK
            newSavingsAccount.setAccountNumber();
            // Chạy hàm for để kiểm tra và lấy index nếu trùng
            for (int i = 0; i < accounts.size(); i++){
                if (Objects.equals(newSavingsAccount.getAccountNumber(), accounts.get(i).getAccountNumber())) {
                    index = i;
                    break;
                }
            }
            // Thông báo STK đã tồn tại
            if (index >= 0) {
                System.out.println("So tai khoan da ton tai");
                addSavingsAccount();
            }
            else {
                // Nhập số dư
                System.out.println("Nhap so du: ");
                long balance = sc.nextLong();
                newSavingsAccount.setBalance(balance);
                newSavingsAccount.accountType();
                accounts.add(newSavingsAccount);

            }
        }
        catch (NumberFormatException e) {
            // catch lỗi nếu nhập STK không đúng định dạng
            System.out.println("Ma STK khong hop le.");
        }
    }

    /**
     *
     */
    public void withdrawMoney() {
        System.out.println("Nhap ma STK gom 6 chu so: ");
        // Tạo newTransaction để lưu lịch sử giao dịch
        Transaction newTransaction = new Transaction();
        // Scan accountNumber được nhập
        String checkAccountNumber = sc.next();
        int index = -1;
        // Chạy hàm kiểm tra và lấy index của tài khoản
        for (int i = 0; i < accounts.size(); i++){
            if (Objects.equals(checkAccountNumber, accounts.get(i).getAccountNumber())) {
                    index = i;
                    break;
            }
        }
        // index >= 0, tìm thấy tài khoản
        if (index >= 0) {
            System.out.println("Nhap so tien can rut");
                try {
                    // Nhập số tiền cần rút, thực hiện thao tác kiểm tra điều kiện và rút tiền
                    double amount = sc.nextDouble();
                    accounts.get(index).withdraw(amount);

                    // Thêm vào lịch sử giao dịch
                    newTransaction.setAccountNumber(checkAccountNumber);
                    newTransaction.setAmount(amount);
                    newTransaction.setCheckTransaction(accounts.get(index).isAccepted(amount));
                    String dateTime = Utils.getDateTime();
                    newTransaction.dateTime(dateTime);
                    transactions.add(newTransaction);
                } catch (InputMismatchException e) {
                    // catch lỗi nếu nhập số dư không đúng định dạng
                    System.out.println("Ban nhap so du khong dung dinh dang.");
                }
        } else {
            // Thông báo khi không tìm thấy tài khoản theo STK
            System.out.println("So tai khoan khong chinh xac. Vui long kiem tra lai.");
        }

    }

    /**
     *
     * @param accountNumber
     * @param amount
     * @return
     */
    public boolean withdraw(String accountNumber, double amount) {return withdraw(accountNumber, amount);}
    // Hàm hiển thị lịch sử giao dịch
    public void displayTransaction() {
        // Sử dụng vòng lặp for để in các lịch sử giao dịch trong List transactions
        for (int i = 0; i < transactions.size(); i++) {
            // Kiểm tra điều kiện transaction và in ra
            if (transactions.get(i).isCheckTransaction()) {
                System.out.println(transactions.get(i).getAccountNumber() + " | " + "-" + Utils.formatBalance(transactions.get(i).getAmount()) + " | " + transactions.get(i).getDateTime());
            }

        }
    }
}
