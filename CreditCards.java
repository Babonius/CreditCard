public class CreditCards {

    public static void main(String[]args){
        CreditCard Abyan = new CreditCard("Abyan", "BCA", "23435103", 4000, 1000);
        System.out.println("Customer: " + Abyan.getCustomer());
        System.out.println("Bank: " + Abyan.getBank());
        System.out.println("Account: " + Abyan.getAccount());
        System.out.println("Credit Limit: " + Abyan.getLimit());
        System.out.println("Balance: $" + Abyan.getBalance());

        Abyan.charge(100);

        Abyan.makePayment(300);

        System.out.println("Updated balance: $" + Abyan.getBalance());
    }

}

class CreditCard {
    String customer;
    String bank;
    String account;
    double limit; // Changed from int to double
    double balance;

    public CreditCard(String customer, String bank, String account, double limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }
    
    public String getCustomer() {
        return this.customer;
    }
    public String getBank() {
        return this.bank;
    }

    public String getAccount() {
        return this.account;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getLimit() { // Changed return type from int to double
        return this.limit;
    }

    public boolean charge(double price) {
        if (price <= 0) {
            System.out.println("Invalid price. Price must be greater than zero.");
            return false;
        }
        
        if (price + balance > limit) {
            System.out.println("Transaction declined. Exceeds credit limit.");
            return false;
        }
        
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount. Amount must be greater than zero.");
            return;
        }
        
        balance -= amount;
        System.out.println("Payment of $" + amount + " made successfully.");
    }
}
