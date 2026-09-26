import java.util.Scanner;

/**
 * Practical 4 - Program 1: Student Record Management System
 *
 * Requirements:
 * Class: Student
 * Data Members:
 *   - Student ID (int)
 *   - Student Name (String)
 *   - Course (String)
 *   - Marks in AAS (double), JAVA (double), Python (double)
 * Constructors:
 *   - Default Constructor: ID = 0, Name = "Unknown", Course = "Not Assigned", Marks = 0.0
 *   - Parameterized Constructor: Initializes all members from parameters
 * Methods:
 *   - acceptDetails()
 *   - calculateTotal()
 *   - calculatePercentage()
 *   - displayDetails()
 */
class Student {
    private int studentId;
    private String studentName;
    private String course;
    private double marksAAS;
    private double marksJava;
    private double marksPython;

    // 1. Default Constructor
    public Student() {
        this.studentId = 0;
        this.studentName = "Unknown";
        this.course = "Not Assigned";
        this.marksAAS = 0.0;
        this.marksJava = 0.0;
        this.marksPython = 0.0;
    }

    // 2. Parameterized Constructor
    public Student(int studentId, String studentName, String course,
                   double marksAAS, double marksJava, double marksPython) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.marksAAS = marksAAS;
        this.marksJava = marksJava;
        this.marksPython = marksPython;
    }

    // Accept student details from user
    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Enter Student Details ---");
        System.out.print("Enter Student ID: ");
        this.studentId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        this.studentName = sc.nextLine();

        System.out.print("Enter Course: ");
        this.course = sc.nextLine();

        System.out.print("Enter Marks in AAS: ");
        this.marksAAS = sc.nextDouble();

        System.out.print("Enter Marks in JAVA: ");
        this.marksJava = sc.nextDouble();

        System.out.print("Enter Marks in Python: ");
        this.marksPython = sc.nextDouble();
    }

    // Calculate total marks
    public double calculateTotal() {
        return marksAAS + marksJava + marksPython;
    }

    // Calculate percentage (assuming each subject is out of 100)
    public double calculatePercentage() {
        return (calculateTotal() / 300.0) * 100.0;
    }

    // Display all student details
    public void displayDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Student ID         : " + studentId);
        System.out.println("Student Name       : " + studentName);
        System.out.println("Course             : " + course);
        System.out.println("Marks (AAS)        : " + marksAAS);
        System.out.println("Marks (JAVA)       : " + marksJava);
        System.out.println("Marks (Python)     : " + marksPython);
        System.out.printf("Total Marks        : %.2f / 300.00%n", calculateTotal());
        System.out.printf("Percentage         : %.2f%%%n", calculatePercentage());
        System.out.println("----------------------------------------------");
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.1: Student Record Management System  ");
        System.out.println("==================================================");

        // 1. Create one Student object using the default constructor
        System.out.println("\n--- Student 1: Created using Default Constructor ---");
        Student student1 = new Student();
        student1.displayDetails();

        // Optionally accept new details for student1
        System.out.println("\nUpdating Student 1 using acceptDetails()...");
        student1.acceptDetails();
        System.out.println("\n--- Student 1: After acceptDetails() ---");
        student1.displayDetails();

        // 2. Create another Student object using the parameterized constructor
        System.out.println("\n--- Student 2: Created using Parameterized Constructor ---");
        Student student2 = new Student(101, "Aarav Patel", "Computer Science", 88.5, 92.0, 95.5);
        student2.displayDetails();
    }
}
