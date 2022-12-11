package vn.funix.fx17970.java.asm03;
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

    // Chức năng: Thêm khách hàng
    public void addCustomer(String customerId, String name) {
        // Khởi tạo newCustomer từ class Customer
        Customer newCustomer = new Customer();
        // Dùng scanner để input dữ liệu khách hàng
        newCustomer.setName(name);
        newCustomer.setCustomerId(customerId);
        customers.add(newCustomer);
    }

    // Chức năng 3: Hiển thị thông tin khách hàng
    public void showCustomer() {
        // Chạy vòng lặp for để in ra thông tin khách hàng trong List Customer
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getCustomerId() + "   |   " + customers.get(i).getName() + "   |" + customers.get(i).isPremium() + "   | " + customers.get(i).sumBalance()+"đ");
            // Gọi hàm in thông tin tài khoản của khách hàng
            customers.get(i).displayInformation();
        }
    }

    // Chức năng 2: Thêm tài khoản Savings
    public void addSavingsAccount() {
        // Gọi hàm addSavingsAccount cho customer từ class Customer
        customers.get(0).addSavingsAccount();
    }

    // Chức năng 3: Thêm tài khoản Loans
    public void addLoansAccount() {
        // Gọi hàm addLoansAccount cho customer từ class Customer
        customers.get(0).addLoansAccount();
    }

    // Chức năng 4: Rút tiền
    public void withdraw() {
        // Gọi hàm withdrawMoney() từ class Customer
        customers.get(0).withdrawMoney();
    }

    // Chức năng 5: Lịch sử giao dịch
    public void displayTran(){
        // Gọi hàm displayTransaction() từ class Customer để in ra Lịch sử giao dịch
        customers.get(0).displayTransaction();
    }

    // Hàm getCustomer
    public List<Customer> getCustomers() {return customers;}




}
