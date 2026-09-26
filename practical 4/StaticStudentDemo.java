/**
 * Practical 4 - Program 6: Use of static Keyword in Java
 *
 * Requirements:
 * 1. Class: CollegeStudent (Student) with:
 *    - Data members: Roll Number, Student Name
 *    - Static data member: College Name
 * 2. Static variable: count to store the total number of student objects created.
 * 3. Parameterized constructor:
 *    - Initialize roll number and student name.
 *    - Increment the student count whenever a new object is created.
 * 4. Methods:
 *    - display() to display student details along with college name.
 *    - totalStudents() as a static method to display total students.
 * 5. In main():
 *    - Create multiple student objects.
 *    - Display their details.
 *    - Display the total number of students using the static method.
 */
class CollegeStudent {
    // Instance data members (unique per object)
    private int rollNumber;
    private String studentName;

    // Static data members (shared across all instances)
    private static String collegeName = "Government Engineering College, Gujarat";
    private static int count = 0; // Tracks total students created

    // Static method to modify college name if needed
    public static void setCollegeName(String newCollegeName) {
        collegeName = newCollegeName;
    }

    // Parameterized constructor
    public CollegeStudent(int rollNumber, String studentName) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        count++; // Increment count on each object creation
    }

    // Instance method to display student details
    public void display() {
        System.out.printf("%-12d %-22s %s%n", rollNumber, studentName, collegeName);
    }

    // Static method to display the total number of students
    public static void totalStudents() {
        System.out.println("Total Student Objects Created : " + count);
    }

    // Static getter for count
    public static int getCount() {
        return count;
    }
}

public class StaticStudentDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.6: Demonstration of 'static' Keyword ");
        System.out.println("==================================================");

        // Check initial student count before any object creation
        System.out.print("Initial State: ");
        CollegeStudent.totalStudents();

        // 5. Create multiple student objects
        System.out.println("\nCreating student objects...");
        CollegeStudent s1 = new CollegeStudent(101, "Harshil Dave");
        CollegeStudent s2 = new CollegeStudent(102, "Nikhil Sharma");
        CollegeStudent s3 = new CollegeStudent(103, "Rudra Trivedi");
        CollegeStudent s4 = new CollegeStudent(104, "Diya Joshi");

        // Display all students
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-12s %-22s %s%n", "Roll No", "Student Name", "College Name (Static)");
        System.out.println("--------------------------------------------------------------------------------");
        s1.display();
        s2.display();
        s3.display();
        s4.display();
        System.out.println("--------------------------------------------------------------------------------");

        // Display total students using the static method directly via class name
        System.out.println("\nCalling static method CollegeStudent.totalStudents():");
        CollegeStudent.totalStudents();
    }
}
