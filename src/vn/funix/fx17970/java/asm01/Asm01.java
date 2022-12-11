package vn.funix.fx17970.java.asm01;

import java.security.SecureRandom;
import java.util.*;

public class Asm01 {
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
        System.out.println("| NGAN HANG SO | FX17970@v1.0.0                 |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Nhap CCCD                                  |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chuc nang: ");

        // Tạo các chức năng cho người dùng lựa chọn. Sử dụng lệnh while và switch
        boolean quit = false;
        int choice = 2;

        while (!quit) {
                try {
                     choice = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.print("");
                }
                sc.nextLine();
                switch (choice) {
                    // // Trường hợp người dùng nhập 0: Kết thuc chương trình.
                    case 0:
                        System.out.println("Ket thuc chuong trinh.");
                        quit = true;
                        break;
                    // Trường hợp người dùng nhập 1:
                    case 1:
                  /*  Random randomCode = new Random();
                  int verifyCode = randomCode.nextInt((999-100)+1) + 100; */

                        // Khởi chạy hàm checkVerifyCode(). Tạo 1 chuỗi ngẫu nhiên gồm chữ và số và yêu cầu người dùng nhập lại để xác nhận.
                        checkVerifyCode();
                        break;
                    // Trường hợp người dùng nhập khác 0 và 1. Thông báo Mã lựa chọn không đúng và yêu cầu nhập lại
                    default:
                        System.out.println("Ma lua chon khong dung. Vui long thu lai.");
                        break;
                }
        }
    }

    // Khởi tạo hàm checkVerifyCode ()
    public static void checkVerifyCode () {
        // Tạo mã xác nhận ngẫu nhiên bằng hàm randomCode ()
        Random randomCode = new Random();
        int verifyCode = randomCode.nextInt((999-100)+1) + 100;

        System.out.println("Nhap ma xac thuc: " + verifyCode);
        int inputCode = sc.nextInt();
        // Kiểm tra mã xác nhận khi người dùng nhập vào
        if (inputCode == verifyCode) {
            System.out.println("Vui long nhap so CCCD: ");
            inputID(sc.nextLine());
        } else {
            System.out.println("Ma xac thuc khong dung. Vui long thu lai.");
            checkVerifyCode ();
        }
    }


    // Khởi tạo hàm inputID (). Nhập chuỗi CCCD và kiểm tra
    public static void inputID (String inputIDNumber) {
        boolean quitCheckID = false;
        while (!quitCheckID) {
                inputIDNumber = sc.nextLine();
                // Kiểm tra chuỗi CCCD có hợp lệ hay không
                if (inputIDNumber.length() == 12 && Long.parseLong(inputIDNumber) >= 0) {
                    checkIDInformation(inputIDNumber);
                } else if (inputIDNumber.equals("No")){
                    System.out.println("Ket thuc nhap CCCD.");
                    quitCheckID = true;
                    runProgram();
                } else {
                    System.out.print("So CCCD khong hop le.\nVui long nhap lai hoac 'No' de thoat: ");
                }
        }
    }

    // Khởi tạo hàm checkIDInformation (). Hiển thị các menu lựa chọn để kiểm tra CCCD
    public static void checkIDInformation (String inputIDNumber) {
        System.out.print("    | 1. Kiem tra noi sinh\n    | 2. Kiem tra tuoi, gioi tinh\n    | 3. Kiem tra so ngau nhien\n    | 0. Thoat\nChuc nang: ");
        boolean quitCheckingInfor = false;
        int choice = 4;
        // Tạo các chức năng cho người dùng lựa chọn. Sử dụng lệnh while và switch
        while (!quitCheckingInfor) {
            try {
                choice = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("Ma lua chon khong dung. Vui long nhap lai.");
            }
            sc.nextLine();
            switch (choice) {
                // Trường hợp người dùng nhập 0: Thoát chương trình và trở về Menu chính
                case 0:
                    System.out.println("Ket thuc chuong trinh kiem tra CCCD.");
                    quitCheckingInfor = true;
                    runProgram();
                    break;
                // Trường hợp người dùng nhập 1: Chạy hàm birthPlace () để Kiểm tra nơi sinh
                case 1:
                    birthPlace (inputIDNumber);
                    System.out.print("    | 1. Kiem tra noi sinh\n    | 2. Kiem tra tuoi, gioi tinh\n    | 3. Kiem tra so ngau nhien\n    | 0. Thoat\nChuc nang: ");
                    break;
                // Trường hợp người dùng nhập 2: Chạy hàm ageAndSex () để Kiểm tra tuổi, giới tính
                case 2:
                    ageAndSex(inputIDNumber);
                    System.out.print("    | 1. Kiem tra noi sinh\n    | 2. Kiem tra tuoi, gioi tinh\n    | 3. Kiem tra so ngau nhien\n    | 0. Thoat\nChuc nang: ");
                    break;
                // Trường hợp người dùng nhập 3: Chạy hàm checkRandomNumber () để Kiểm tra chuỗi số ngẫu nhiên
                case 3:
                    checkRandomNumber (inputIDNumber);
                    System.out.print("    | 1. Kiem tra noi sinh\n    | 2. Kiem tra tuoi, gioi tinh\n    | 3. Kiem tra so ngau nhien\n    | 0. Thoat\nChuc nang: ");
                    break;
                // Trường hợp người dùng nhập sai lựa chọn: Thông báo Mã lựa chọn không đúng và yêu cầu nhập lại.
                default:
                    System.out.println("Ma lua chon khong dung. Vui long thu lai.");
                    System.out.print("    | 1. Kiem tra noi sinh\n    | 2. Kiem tra tuoi, gioi tinh\n    | 3. Kiem tra so ngau nhien\n    | 0. Thoat\nChuc nang: ");
                    break;
            }
        }
    }

    // Khởi tạo hàm birthPlace () thông báo Nơi sinh theo mã CCCD
    public static void birthPlace (String inputIDNumber) {

        // Tạo hashMap gồm mã Tỉnh thành và tên Tỉnh thành
        String keySet = inputIDNumber.substring(0,3);
        HashMap<String, String> hashMap = new HashMap<String, String >();
        hashMap.put("001", "Ha Noi");
        hashMap.put("002", "Ha Giang");
        hashMap.put("004", "Cao Bang");
        hashMap.put("006", "Bac Kan");
        hashMap.put("008", "Tuyen Quang");
        hashMap.put("010", "Lao Cai");
        hashMap.put("011", "Dien Bien");
        hashMap.put("012", "Lai Chau");
        hashMap.put("014", "Son La");
        hashMap.put("015", "Yen Bai");
        hashMap.put("017", "Hoa Binh");
        hashMap.put("019", "Thai Nguyen");
        hashMap.put("020", "Lang Son");
        hashMap.put("022", "Quang Ninh");
        hashMap.put("024", "Bac Giang");
        hashMap.put("025", "Phu Tho");
        hashMap.put("026", "Vinh Phuc");
        hashMap.put("027", "Bac Ninh");
        hashMap.put("030", "Hai Duong");
        hashMap.put("031", "Hai Phong");
        hashMap.put("033", "Hung Yen");
        hashMap.put("034", "Thai Binh");
        hashMap.put("035", "Ha Nam");
        hashMap.put("036", "Nam Dinh");
        hashMap.put("037", "Ninh Binh");
        hashMap.put("038", "Thanh Hoa");
        hashMap.put("040", "Nghe An");
        hashMap.put("042", "Ha Tinh");
        hashMap.put("044", "Quang Binh");
        hashMap.put("045", "Quang Tri");
        hashMap.put("046", "Thua Thien Hue");
        hashMap.put("048", "Da Nang");
        hashMap.put("049", "Quang Nam");
        hashMap.put("051", "Quang Ngai");
        hashMap.put("052", "Binh Dinh");
        hashMap.put("054", "Phu Yen");
        hashMap.put("056", "Khanh Hoa");
        hashMap.put("058", "Ninh Thuan");
        hashMap.put("060", "Binh Thuan");
        hashMap.put("064", "Gia Lai");
        hashMap.put("066", "Dak Lak");
        hashMap.put("067", "Dak Nong");
        hashMap.put("068", "Lam Dong");
        hashMap.put("070", "Binh Phuoc");
        hashMap.put("072", "Tay Ninh");
        hashMap.put("074", "Binh Duong");
        hashMap.put("075", "Dong Nai");
        hashMap.put("077", "Ba Ria - Vung Tau");
        hashMap.put("079", "Ho Chi Minh");
        hashMap.put("080", "Long An");
        hashMap.put("082", "Tien Giang");
        hashMap.put("083", "Ben Tre");
        hashMap.put("084", "Tra Vinh");
        hashMap.put("086", "Vinh Long");
        hashMap.put("087", "Dong Thap");
        hashMap.put("089", "An Giang");
        hashMap.put("091", "Kien Giang");
        hashMap.put("092", "Can Tho");
        hashMap.put("093", "Hau Giang");
        hashMap.put("094", "Soc Trang");
        hashMap.put("095", "Bac Lieu");
        hashMap.put("096", "Ca Mau");

        // Kiểm tra và thông báo Tỉnh thành theo CCCD
        if(hashMap.get(keySet) == null){
            System.out.println("Khong tim thay ma tinh, thanh pho trong du lieu duoc quy dinh.");
        } else {
            System.out.println("Noi Sinh: " + hashMap.get(keySet));
        }
    }

    // Khởi tạo hàm ageAndSex () , kiểm tra và thông báo Giới tính, năm sinh
    public static void ageAndSex (String inputIDNumber) {
        char [] strToChar = inputIDNumber.toCharArray();
        switch (strToChar[3]) {
            // Kiểm tra và thông báo Giới tính + Năm sinh
            case '0':
                System.out.println("Gioi tinh: Nam | 19" + strToChar[4] + strToChar[5]);
                break;
            case '1':
                System.out.println("Gioi tinh: Nu | 19" + strToChar[4] + strToChar[5]);
                break;
            case '2':
                System.out.println("Gioi tinh: Nam | 20" + strToChar[4] + strToChar[5]);
                break;
            case '3':
                System.out.println("Gioi tinh: Nu | 20" + strToChar[4] + strToChar[5]);
                break;
            case '4':
                System.out.println("Gioi tinh: Nam | 21" + strToChar[4] + strToChar[5]);
                break;
            case '5':
                System.out.println("Gioi tinh: Nu | 21" + strToChar[4] + strToChar[5]);
                break;
            case '6':
                System.out.println("Gioi tinh: Nam | 22" + strToChar[4] + strToChar[5]);
                break;
            case '7':
                System.out.println("Gioi tinh: Nu | 23" + strToChar[4] + strToChar[5]);
                break;
            case '8':
                System.out.println("Gioi tinh: Nam | 24" + strToChar[4] + strToChar[5]);
                break;
            case '9':
                System.out.println("Gioi tinh: Nu | 24" + strToChar[4] + strToChar[5]);
                break;
        }
    }

    // Khởi tạo hàm checkRandomNumber () kiểm tra mã số ngẫu nhiên
    public static void checkRandomNumber (String inputIDNumber) {
        char[] strToChar = inputIDNumber.toCharArray();
        System.out.print("So ngau nhien: ");
        for (int i = 6; i < 12; i++) {
            System.out.print(strToChar[i]);
        }
        System.out.println("");
    }

}




