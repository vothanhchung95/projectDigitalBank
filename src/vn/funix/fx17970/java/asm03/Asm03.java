package vn.funix.fx17970.java.asm03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asm03 {
    public static Scanner sc = new Scanner(System.in);
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";
    private static final DigitalBank activeBank = new DigitalBank(CUSTOMER_ID, CUSTOMER_NAME);

    // Hàm main:
    public static void main(String[] args) {
        // Thêm khách hàng mặc định bằng addCustomer()
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        // Khởi chạy chương trình bằng hàm runProgram ()
        runProgram();
    }

    // Khởi tạo hàm runProgram ()
    public static void runProgram() {
        // Hiển thị giao diện menu chính:
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX17970@v3.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thong tin khach hang                       |");
        System.out.println("| 2. Them tai khoan ATM                         |");
        System.out.println("| 3. Them tai khoan tin dung                    |");
        System.out.println("| 4. Rut tien                                   |");
        System.out.println("| 5. Lich su giao dich                          |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("Chuc nang: ");

        // Tạo các chức năng cho người dùng lựa chọn. Sử dụng lệnh while và switch
        boolean quit = false;
        int choice = 6;

        while (!quit) {
            // Catch lỗi khi nhập lựa chọn
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("");
            }
            sc.nextLine();
            switch (choice) {
                // Chức năng 0: Kết thúc chương trình
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    quit = true;
                    break;
                // Chức năng 1: Hiển thị thông tin khách hàng
                case 1:
                    activeBank.showCustomer();
                    runProgram();
                    break;
                // Chức năng 2: Thêm tài khoản Savings
                case 2:
                    activeBank.addSavingsAccount();
                    runProgram();
                    break;
                // Chức năng 3: Thêm tài khoản Loans
                case 3:
                    activeBank.addLoansAccount();
                    runProgram();
                    break;
                // Chức năng 4: Rút tiền
                case 4:
                    activeBank.withdraw();
                    runProgram();
                    break;
                // Chức năng 5: Lịch sử giao dịch
                case 5:
                    activeBank.showCustomer();
                    activeBank.displayTran();
                    runProgram();
                    break;
                // Hiển thị thông báo khi không lựa chọn đúng chức năng
                default:
                    System.out.println("Ma lua chon khong dung. Vui long thu lai.");
                    break;
            }
        }
    }
}





















