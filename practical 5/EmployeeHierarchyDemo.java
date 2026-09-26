import java.util.Scanner;

/**
 * Practical 5 - Program 3:
 * Interface Employee with calculateSalary() and displayDetails().
 * Implemented by two classes: Manager and Developer.
 */

// Interface Employee
interface Employee {
    void calculateSalary();
    void displayDetails();
}

// Manager Class implementing Employee
class Manager implements Employee {
    private int empId;
    private String name;
    private double basicSalary;
    private double bonus;
    private double totalSalary;

    public Manager(int empId, String name, double basicSalary, double bonus) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        // Manager total salary includes basic + management bonus
        this.totalSalary = basicSalary + bonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Designation    : Manager");
        System.out.println("Employee ID    : " + empId);
        System.out.println("Name           : " + name);
        System.out.printf("Basic Salary   : ₹%.2f%n", basicSalary);
        System.out.printf("Annual Bonus   : ₹%.2f%n", bonus);
        System.out.printf("Total Salary   : ₹%.2f%n", totalSalary);
        System.out.println("----------------------------------------------");
    }
}

// Developer Class implementing Employee
class Developer implements Employee {
    private int empId;
    private String name;
    private double basicSalary;
    private double overtimePay;
    private double totalSalary;

    public Developer(int empId, String name, double basicSalary, double overtimePay) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.overtimePay = overtimePay;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        // Developer total salary includes basic + overtime/incentives
        this.totalSalary = basicSalary + overtimePay;
    }

    @Override
    public void displayDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Designation    : Developer");
        System.out.println("Employee ID    : " + empId);
        System.out.println("Name           : " + name);
        System.out.printf("Basic Salary   : ₹%.2f%n", basicSalary);
        System.out.printf("Overtime/Incent: ₹%.2f%n", overtimePay);
        System.out.printf("Total Salary   : ₹%.2f%n", totalSalary);
        System.out.println("----------------------------------------------");
    }
}

public class EmployeeHierarchyDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 5.3: Employee Interface (Manager & Dev)");
        System.out.println("==================================================");

        Scanner sc = new Scanner(System.in);

        try {
            // Accept Manager details
            System.out.println("\n--- Enter Manager Details ---");
            System.out.print("Enter Manager ID: ");
            int mId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Manager Name: ");
            String mName = sc.nextLine();
            System.out.print("Enter Basic Salary: ");
            double mSalary = sc.nextDouble();
            System.out.print("Enter Management Bonus: ");
            double mBonus = sc.nextDouble();

            Employee mgr = new Manager(mId, mName, mSalary, mBonus);

            // Accept Developer details
            System.out.println("\n--- Enter Developer Details ---");
            System.out.print("Enter Developer ID: ");
            int dId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Enter Developer Name: ");
            String dName = sc.nextLine();
            System.out.print("Enter Basic Salary: ");
            double dSalary = sc.nextDouble();
            System.out.print("Enter Overtime Pay / Incentive: ");
            double dOvertime = sc.nextDouble();

            Employee dev = new Developer(dId, dName, dSalary, dOvertime);

            // Display details using polymorphic interface reference
            System.out.println("\n================ EMPLOYEE SALARY SLIPS ================");
            mgr.displayDetails();
            dev.displayDetails();

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
