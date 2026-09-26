import company.Employee;
import department.Manager;

/**
 * Practical 5 - Program 2:
 * Demonstration of cross-package interface implementation:
 * 'department.Manager' implementing 'company.Employee'.
 */
public class CompanyDepartmentDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 5.2: Cross-Package Interface Demo      ");
        System.out.println(" (company.Employee -> department.Manager)         ");
        System.out.println("==================================================");

        // Create Manager instance
        Manager manager = new Manager(301, "Rajesh Singhania", 75000.0, 15000.0);

        // Polymorphic reference using interface company.Employee
        Employee emp = manager;

        System.out.println("\nCalculating salary using Employee interface reference...");
        emp.calculateSalary();

        System.out.println("\nDisplaying Manager Salary Breakdown:");
        manager.displayManagerDetails();
    }
}
