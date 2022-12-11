package vn.funix.fx17970.java.asm03;

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

    public void setName(String name) {
        this.name = name;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
