package studentinfo;

import java.util.Scanner;

/**
 * Practical 5 - Program 1:
 * Class Student inside the 'studentinfo' package.
 *
 * Data members:
 *   - studentId (int)
 *   - studentName (String)
 *   - course (String)
 *   - marks (double)
 *
 * Methods:
 *   - acceptDetails()
 *   - displayDetails()
 *   - calculateGrade()
 */
public class Student {
    private int studentId;
    private String studentName;
    private String course;
    private double marks;

    // Default Constructor
    public Student() {
        this.studentId = 0;
        this.studentName = "Unknown";
        this.course = "Not Assigned";
        this.marks = 0.0;
    }

    // Parameterized Constructor
    public Student(int studentId, String studentName, String course, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.marks = marks;
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

        System.out.print("Enter Course Name: ");
        this.course = sc.nextLine();

        System.out.print("Enter Marks (0 - 100): ");
        this.marks = sc.nextDouble();
    }

    // Calculate and return grade based on marks
    public String calculateGrade() {
        if (marks >= 90 && marks <= 100) {
            return "A+";
        } else if (marks >= 80 && marks < 90) {
            return "A";
        } else if (marks >= 70 && marks < 80) {
            return "B";
        } else if (marks >= 60 && marks < 70) {
            return "C";
        } else {
            return "D";
        }
    }

    // Display student information along with grade
    public void displayDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Student ID     : " + studentId);
        System.out.println("Student Name   : " + studentName);
        System.out.println("Course         : " + course);
        System.out.printf("Marks          : %.2f / 100.00%n", marks);
        System.out.println("Grade Assigned : " + calculateGrade());
        System.out.println("----------------------------------------------");
    }

    // Getters
    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
}
