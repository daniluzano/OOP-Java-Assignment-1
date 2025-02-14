import java.util.ArrayList;
import java.util.List;

public class Customer{
    String firstName;
    String email;
    double fidelityPoint;
    static double totalOrderAmountInDollars;
    
        private static List<Customer> allCustomers = new ArrayList<>();
    
        private Customer(String firstName, String email) {
            this.firstName = firstName;
            this.email = email;
            this.fidelityPoint = 0.0;
            this.totalOrderAmountInDollars = 0.0;
            allCustomers.add(this);
        }
    
    
        @Override
        public String toString() {
            return "first name: " + this.firstName + "\n" + "email: " + this.email + "\n" + "fidelity point: " + this.fidelityPoint + 
                    "\n" + "total amount: " + this.totalOrderAmountInDollars;
        }
    
        void registerNewSale(double saleAmount) {
            this.fidelityPoint = saleAmount * 0.1;
            this.totalOrderAmountInDollars += saleAmount;
        }
    
        static double getTotalNumCustomers() {
            return allCustomers.size();
        }
    
        static double getTotalSaleAmount() {
            return totalOrderAmountInDollars;
    }
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "alice@ex.com");
        Customer customer2 = new Customer("Bob", "bob@ex.com");

        System.out.println(customer1);
        System.out.println(customer2);

        customer1.registerNewSale(100.0);
        customer1.registerNewSale(50.0);
        customer2.registerNewSale(200.0);

        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("Total customers: " + Customer.getTotalNumCustomers());
        System.out.println("Total sales: $" + Customer.getTotalSaleAmount());
    }

}
