package vn.funix.fx17970.java.asm02;

import java.util.Scanner;

public abstract class User {

    Scanner sc = new Scanner(System.in);

    // Khai báo biến name và customerId
    private String name;
    private String customerId;

    // Getter và Setter cho biến name và customerId
    public String getName() {
        return name;
    }

    public void setName() {
        this.name = sc.nextLine();
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId() {
        String customerId = sc.nextLine();
        // Kiểm tra customerId có hợp lệ hay không (có 12 ký tự và phải là số)
        if (customerId.length() == 12 && Long.parseLong(customerId) >= 0) {
            this.customerId = customerId;
        } else {
            System.out.println("Ma CCCD khong hop le. Vui long nhap lai: ");
            setCustomerId();
        }
    }
}
