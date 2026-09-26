import java.util.Scanner;

/**
 * Practical 3 - Question 3(a):
 * Implement the StringBuilder class for Username Generator.
 *
 * Example:
 *   Enter First Name: Rahul
 *   Enter Last Name: Sharma
 *   Generated Username: rahul.sharma
 */
public class UsernameGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.3(a): StringBuilder Username Generator ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine().trim();

            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine().trim();

            // Construct username using StringBuilder
            StringBuilder username = new StringBuilder();
            username.append(firstName.toLowerCase());
            username.append(".");
            username.append(lastName.toLowerCase());

            System.out.println("\n----------------- Generated Details -----------------");
            System.out.println("First Name         : " + firstName);
            System.out.println("Last Name          : " + lastName);
            System.out.println("Generated Username : " + username.toString());
            System.out.println("-----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
