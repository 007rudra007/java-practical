/**
 * Practical 4 - Program 5: Multilevel Inheritance – Online Shopping System
 *
 * Inheritance Structure:
 *   User (Base)
 *     |
 *   Customer (Intermediate)
 *     |
 *   PremiumCustomer (Derived)
 *
 * Requirements:
 * 1. Base Class: User
 *    - Data members: User ID, User Name, Mobile Number
 * 2. Intermediate Class: Customer (extends User)
 *    - Data members: Customer Address, Order ID
 * 3. Derived Class: PremiumCustomer (extends Customer)
 *    - Data members: Membership Type, Discount Percentage
 * 4. Constructors to initialize all data members using super.
 * 5. Methods:
 *    - displayUserDetails()
 *    - calculateDiscount(orderAmount)
 *    - displayFinalBill(orderAmount)
 *    - displayPremiumCustomerDetails()
 * 6. Main method demonstrates multilevel inheritance.
 */

// Level 1: Base Class
class User {
    protected int userId;
    protected String userName;
    protected String mobileNumber;

    public User(int userId, String userName, String mobileNumber) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    public void displayUserDetails() {
        System.out.println("User ID          : " + userId);
        System.out.println("User Name        : " + userName);
        System.out.println("Mobile Number    : " + mobileNumber);
    }
}

// Level 2: Intermediate Class
class Customer extends User {
    protected String customerAddress;
    protected int orderId;

    public Customer(int userId, String userName, String mobileNumber,
                    String customerAddress, int orderId) {
        super(userId, userName, mobileNumber); // Pass to User constructor
        this.customerAddress = customerAddress;
        this.orderId = orderId;
    }

    public void displayCustomerDetails() {
        displayUserDetails();
        System.out.println("Customer Address : " + customerAddress);
        System.out.println("Order ID         : #" + orderId);
    }
}

// Level 3: Derived Class
class PremiumCustomer extends Customer {
    private String membershipType;     // e.g. "Platinum", "Gold"
    private double discountPercentage; // e.g. 15.0 for 15%

    public PremiumCustomer(int userId, String userName, String mobileNumber,
                           String customerAddress, int orderId,
                           String membershipType, double discountPercentage) {
        super(userId, userName, mobileNumber, customerAddress, orderId); // Pass to Customer constructor
        this.membershipType = membershipType;
        this.discountPercentage = discountPercentage;
    }

    // Calculate discount amount
    public double calculateDiscount(double orderAmount) {
        return (orderAmount * discountPercentage) / 100.0;
    }

    // Display final bill after applying discount
    public void displayFinalBill(double orderAmount) {
        double discount = calculateDiscount(orderAmount);
        double finalAmount = orderAmount - discount;

        System.out.println("\n========== ORDER BILL SUMMARY ==========");
        System.out.println("Order ID         : #" + orderId);
        System.out.println("Customer Name    : " + userName);
        System.out.println("Membership Tier  : " + membershipType);
        System.out.printf("Gross Amount     : ₹%.2f%n", orderAmount);
        System.out.printf("Discount (%.1f%%) : -₹%.2f%n", discountPercentage, discount);
        System.out.println("----------------------------------------");
        System.out.printf("Final Payable    : ₹%.2f%n", finalAmount);
        System.out.println("========================================");
    }

    // Display all premium customer details
    public void displayPremiumCustomerDetails() {
        System.out.println("----------------------------------------------");
        displayCustomerDetails(); // Calls Customer -> User methods
        System.out.println("Membership Type  : " + membershipType);
        System.out.println("Discount Rate    : " + discountPercentage + "%");
        System.out.println("----------------------------------------------");
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.5: Online Shopping System (Multilevel)");
        System.out.println("==================================================");

        // 6. Create PremiumCustomer object and demonstrate multilevel inheritance
        PremiumCustomer premiumUser = new PremiumCustomer(
                501,
                "Aditya Sen",
                "+91-9876543210",
                "Flat 402, Skyline Towers, Mumbai",
                98234,
                "Platinum VIP",
                20.0 // 20% discount
        );

        System.out.println("\n--- Complete Premium Customer Profile ---");
        premiumUser.displayPremiumCustomerDetails();

        // Calculate and display bill with discount
        double cartAmount = 8500.00;
        premiumUser.displayFinalBill(cartAmount);
    }
}
