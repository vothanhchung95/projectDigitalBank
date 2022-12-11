package vn.funix.fx17970.java.asm03;

public class LoansAccount extends Account implements ReportService, Withdraw{

    // Khai báo hằng số LOAN_ACCOUNT_WITHDRAW_FEE và LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE, Phí rút tiền tài khoản Normal và Premium
    private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;

    // Khai báo hằng số LOAN_ACCOUNT_MAX_BALANCE, hạn mức tài khoản Loans
    private final int LOAN_ACCOUNT_MAX_BALANCE = 100000000;
    // Loại tài khoản
    private String accountType = "   LOANS";

    // Override accountType() để trả về String
    @Override
    public String accountType() {
        return this.accountType;
    }

    public int getLOAN_ACCOUNT_MAX_BALANCE() {
        return LOAN_ACCOUNT_MAX_BALANCE;
    }

    // Override hàm log (Interface ReportService)để in ra biên lai giao dịch
    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH LOAN");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", Utils.formatBalance((getBalance() - amount * (1 + getTransactionFee()))));
        System.out.printf("PHI + VAT: %27s%n", Utils.formatBalance(getTransactionFee() * amount));
        System.out.println(Utils.getDivider());
    }

    // Hàm kiểm tra loại tài khoản và trả về mức phí rút tiền
    private double getTransactionFee() {
        return (isPremium() ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE  : LOAN_ACCOUNT_WITHDRAW_FEE);
    }

    // Hàm thực hiện rút tiền withdraw(), Override từ interface Withdraw
    @Override
    public boolean withdraw(double amount) {
        double newBalance;
        // Kiểm tra điều kiện rút tiền isAccepted()
        if(isAccepted(amount)) {
            // Tính số dư còn lại sau khi rút tiền
            newBalance = getBalance() - amount * (1 + getTransactionFee());
            // Gọi hàm in biên lai
            log(amount);
            // Ghi số dư mới vào tài khoản
            setBalance(newBalance);
            return true;
        } else {
            // Thông báo khi rút tiền không thành công
            System.out.println("Rut tien khong thanh cong.\nSo du tai khoan phai lon hon 50.000đ.");
        }
        return false;
    }

    // Hàm kiểm tra điều kiện rút tiền
    @Override
    public boolean isAccepted(double amount) {
        // Kiểm tra điều kiện rút tiền. Số dư phải >= 50.000đ và Số tiền rút > 0
        if (((getBalance() - amount * (1 + getTransactionFee())) >= 50000) && amount > 0) {
            return true;
        }
        return false;
    }

}
