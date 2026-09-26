package department;

import company.Employee;

/**
 * Practical 5 - Program 2:
 * Class Manager in package 'department' implementing 'company.Employee' interface.
 */
public class Manager implements Employee {
    private int empId;
    private String name;
    private double basicSalary;
    private double hra;
    private double bonus;
    private double totalSalary;

    public Manager(int empId, String name, double basicSalary, double bonus) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.hra = 0.20 * basicSalary; // HRA is 20% of basic
        calculateSalary();
    }

    // Implementing the calculateSalary method from company.Employee
    @Override
    public void calculateSalary() {
        this.totalSalary = basicSalary + hra + bonus;
    }

    public void displayManagerDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Role             : Department Manager");
        System.out.println("Employee ID      : " + empId);
        System.out.println("Employee Name    : " + name);
        System.out.printf("Basic Salary     : ₹%.2f%n", basicSalary);
        System.out.printf("HRA (20%%)        : ₹%.2f%n", hra);
        System.out.printf("Performance Bonus: ₹%.2f%n", bonus);
        System.out.printf("Total Net Salary : ₹%.2f%n", totalSalary);
        System.out.println("----------------------------------------------");
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
