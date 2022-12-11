package vn.funix.fx17970.java.asm03;

public class DigitalCustomer extends Customer{
    public boolean withdraw(String accountNumber, double amount) {
        for(Account accountReserve: this.getAccounts()) {
            if(accountReserve.getAccountNumber().equals(accountNumber)) {
                // Check if account is Saving Account or Loan Account
                return ((Withdraw) accountReserve).withdraw(amount);
            }
        }

        return false;
    }
}
