package vn.funix.fx17970.java.asm02;
import java.util.*;

public class Bank {
    Scanner sc = new Scanner(System.in);

    // Khai báo biến id và List Customer
    private final String id;
    private List<Customer> customers;

    // Tạo constructor cho class Bank
    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    // Chức năng 1: Thêm khách hàng
    public void addCustomer() {
        // Khởi tạo newCustomer từ class Customer
        Customer newCustomer = new Customer();
        // Dùng scanner để input dữ liệu khách hàng
        System.out.println("Nhap ten khach hang: ");
        newCustomer.setName();
        System.out.println("Nhap so CCCD: ");
        try {
            newCustomer.setCustomerId();
            // Kiểm tra mã CCCD đã tồn tại trong List Customer hay chưa
            if (isCustomerExisted(newCustomer.getCustomerId())) {
                System.out.println("Ma CCCD da ton tai. Vui long thu lai.\n+----------+-------------------------+----------+");
                addCustomer();
            }  else {customers.add(newCustomer);}
        } catch (NumberFormatException e) {
            System.out.println("Ma CCCD khong hop le.");
        }
    }

    // Chức năng 2: Thêm tài khoản cho khách hàng
    public void addAccount() {
        System.out.println("Nhap CCCD khach hang: ");
        int index = -1;
        String checkCi = sc.nextLine();
        // Kiểm tra số CCCD được nhập với số CCCD lưu trong List Customer. Lấy index của số CCCD được tìm thấy
        for (int i = 0; i < customers.size(); i++) {
            if (Objects.equals(checkCi, customers.get(i).getCustomerId())) {
                index = i;
                break;
            }
        }
        // Thêm tài khoản bằng hàm addAccount() nếu tìm thấy index. Nếu không, in ra thông báo không tìm thấy khách hàng.
        if (index >= 0) {
            customers.get(index).addAccount();
        } else {
            System.out.println("Khong tim thay khach hang theo ma CCCD.");
        }
    }

    // Chức năng 3: Hiển thị danh sách khách hàng
    public void showCustomer() {
        // Chạy vòng lặp for để in ra thông tin khách hàng trong List Customer
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getCustomerId() + "   |" + customers.get(i).getName() + "   |" + customers.get(i).isPremium() + "   | " + customers.get(i).sumBalance()+"đ");
            // Gọi hàm in thông tin tài khoản của khách hàng
            customers.get(i).displayInformation();
            System.out.println("");
        }
        System.out.println("Chuc nang: ");
    }

    // Chức năng 4: Tìm kiếm khách hàng theo CCCD
    public void findCustomer() {
        System.out.println("Nhap CCCD khach hang: ");
        int index = -1;
        String checkCi = sc.nextLine();
        // Kiểm tra số CCCD được nhập và tìm vị trí của khách hàng bên trong List Customer
        for (int i = 0; i < customers.size(); i++) {
            if (Objects.equals(checkCi, customers.get(i).getCustomerId())) {
               index = i;
               break;
            }
        }
        // In ra thông tin khách hàng nếu tìm thấy trong List Customer. In ra thông báo nếu không tìm thấy.
        if (index >= 0) {
            System.out.println(customers.get(index).getCustomerId() + "   |" + customers.get(index).getName() + "   |" + customers.get(index).isPremium() + "   | " + customers.get(index).sumBalance()+"đ");
            customers.get(index).displayInformation();
            System.out.println("");
            System.out.println("Chuc nang: ");
        } else {
            System.out.println("Khong tim thay khach hang theo ma CCCD. Vui long thu lai.");
            findCustomer();
        }
    }

    // Chức năng 5: Tìm kiếm khách hàng theo tên
    public void findCustomerByName() {
        System.out.println("Nhap ten khach hang: ");
        int count = 0;
        String checkName = sc.nextLine();
        // Chạy vòng lặp for để kiểm tra
        for (int i = 0; i < customers.size(); i++) {
            // Kiểm tra tên của customer có chứa ký tự được nhập và in ra thông tin khách hàng
            if (customers.get(i).getName().contains(checkName)) {
                System.out.println(customers.get(i).getCustomerId() + "   |" + customers.get(i).getName() + "   |" + customers.get(i).isPremium() + "   | " + customers.get(i).sumBalance() + "đ");
                customers.get(i).displayInformation();
                count++;
            }
        }
        // Nếu không tìm thấy khách hàng theo tên, in ra thông báo.
        if (count == 0) {
            System.out.println("Khong tim thay ten khach hang.");
        }
        System.out.println("");
        System.out.println("Chuc nang: ");
    }

    public List<Customer> getCustomers() {return customers;}

    // Hàm kiểm tra CCCD khách hàng đã tồn tại hay chưa
    public boolean isCustomerExisted(String customerId) {
        boolean result = false;
        for (Customer customer : customers) {
            if (Objects.equals(customerId, customer.getCustomerId())) {
                result = true;
                break;
            }
        }
        return result;
    }

}
