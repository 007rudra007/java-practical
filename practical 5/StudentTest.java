import studentinfo.Student;

/**
 * Practical 5 - Program 1:
 * Class StudentTest outside the 'studentinfo' package.
 * Imports studentinfo.Student, creates an object, accepts details,
 * and displays student information along with grade.
 */
public class StudentTest {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 5.1: Package 'studentinfo' Demo        ");
        System.out.println("==================================================");

        // 1. Create a Student object using parameterized constructor
        System.out.println("\n--- Demonstration with Predefined Student ---");
        Student sampleStudent = new Student(201, "Aarav Sharma", "Information Technology", 86.5);
        sampleStudent.displayDetails();

        // 2. Create another Student object and accept user details
        System.out.println("\n--- Interactive Student Input ---");
        Student userStudent = new Student();
        userStudent.acceptDetails();

        System.out.println("\n--- Displaying Student Report ---");
        userStudent.displayDetails();
    }
}
