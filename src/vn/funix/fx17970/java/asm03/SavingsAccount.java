package vn.funix.fx17970.java.asm03;

public class SavingsAccount extends Account implements ReportService, Withdraw{
    // Khai báo hằng số SAVINGS_ACCOUNT_MAX_WITHDRAW, số tiền tối đa có thể rút trong 1 lần của tài khoản thường
    private final int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

    // Loại tài khoản
    private String accountType = " SAVINGS";

    // Override accountType() để trả về String
    @Override
    public String accountType() {
        return this.accountType;
    }

    // Override hàm log (Interface ReportService)để in ra biên lai giao dịch
    @Override
    public void log(double amount) {
        System.out.println(Utils.getDivider());
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", Utils.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", Utils.formatBalance(amount));
        System.out.printf("SO DU: %31s%n", Utils.formatBalance((getBalance() - amount)));
        System.out.printf("PHI + VAT: %27s%n", "0 đ");
        System.out.println(Utils.getDivider());
    }

    // Hàm thực hiện rút tiền withdraw(), Override từ interface Withdraw
    @Override
    public boolean withdraw(double amount) {
        double newBalance;
        // Kiểm tra điều kiện rút tiền isAccepted()
        if(isAccepted(amount)) {
            // Tính số dư còn lại sau khi rút tiền
            newBalance = getBalance() - amount;
            // Gọi hàm in biên lai
            log(amount);
            // Ghi số dư mới vào tài khoản
            setBalance(newBalance);
            return true;
        } else {
            // Thông báo khi rút tiền không thành công
            System.out.println("Rut tien khong thanh cong.\nSo du tai khoan phai lon hon 50.000đ. So tien rut phai la boi so cua 10.000đ, lon hon 50.000đ va khong qua 5.000.000đ voi tai khoan Normal");
        }
        return false;
    }

    // Hàm kiểm tra điều kiện rút tiền
    @Override
    public boolean isAccepted(double amount) {
        long withdrawLimited;
        boolean isAccepted = false;
        // Kiểm tra loại tài khoản và trả về giới hạn rút tiền cho từng loại tài khoản
        if (isPremium()){
            withdrawLimited = Long.MAX_VALUE;
        } else {
            withdrawLimited = SAVINGS_ACCOUNT_MAX_WITHDRAW;
        }

        // Kiểm tra điều kiện rút tiền. Số dư phải >= 50.000đ và Số tiền rút > 50.000đ và < giới hạn rút tiền, là bội số của 10.000đ
        if (amount % 10000 == 0 && amount >= 50000 && amount <= withdrawLimited && ((getBalance() - amount) >= 50000)) {
            isAccepted = true;
        }
        return isAccepted;
    }
}
