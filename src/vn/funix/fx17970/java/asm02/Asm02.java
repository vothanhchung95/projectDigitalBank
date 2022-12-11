package vn.funix.fx17970.java.asm02;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Asm02 {
    // Khai báo đối tượng bank
    private static final Bank bank = new Bank();
    public static Scanner sc = new Scanner(System.in);

    // Hàm main:
    public static void main(String[] args) {

        // Khởi chạy chương trình bằng hàm runProgram ()
        runProgram();
    }

    // Khởi tạo hàm runProgram ()
    public static void runProgram() {
        // Hiển thị giao diện menu chính:
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| NGAN HANG SO | FX17970@v2.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Them khach hang                            |");
        System.out.println("| 2. Them tai khoan cho khach hang              |");
        System.out.println("| 3. Hien thi danh sach khach hang              |");
        System.out.println("| 4. Tim theo CCCD                              |");
        System.out.println("| 5. Tim theo ten khach hang                    |");
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
                // Chức năng 1: Thêm khách hàng. Chạy hàm addCustomer()
                case 1:
                    bank.addCustomer();
                    runProgram();
                    break;
                // Chức năng 2: Thêm tài khoản. Chạy hàm addAccount()
                case 2:
                    bank.addAccount();
                    runProgram();
                    break;
                // Chức năng 3: Hiển thị danh sách khách hàng. Chạy hàm showCustomer()
                case 3:
                    bank.showCustomer();
                    break;
                // Chức năng 4: Tìm kiếm khách hàng theo CCCD. Chạy hàm findCustomer()
                case 4:
                    bank.findCustomer();
                    break;
                // Chức năng 5: Tìm kiếm khách hàng theo tên. Chạy hàm findCustomerByName()
                case 5:
                    bank.findCustomerByName();
                    break;
                // Hiển thị thông báo khi không lựa chọn đúng chức năng
                default:
                    System.out.println("Ma lua chon khong dung. Vui long thu lai.");
                    break;
            }
        }
    }
}





















