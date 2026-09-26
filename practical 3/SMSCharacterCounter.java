import java.util.Scanner;

/**
 * Practical 3 - Question 3(c):
 * SMS Character Counter using StringBuilder.
 *
 * Example:
 *   Characters Used : 35   Characters Left : 125
 *
 * Description:
 * A standard single SMS segment contains a maximum of 160 characters.
 * This program tracks message length using StringBuilder and computes
 * characters used and remaining characters.
 */
public class SMSCharacterCounter {

    private static final int SMS_MAX_LIMIT = 160;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.3(c): SMS Character Counter          ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter your SMS message: ");
            String input = sc.nextLine();

            StringBuilder smsBody = new StringBuilder(input);

            int charactersUsed = smsBody.length();
            int charactersLeft = SMS_MAX_LIMIT - charactersUsed;

            System.out.println("\n----------------- SMS Status -----------------");
            System.out.println("Message: \"" + smsBody.toString() + "\"");
            System.out.println("Characters Used : " + charactersUsed + "   Characters Left : " + (charactersLeft >= 0 ? charactersLeft : 0));

            if (charactersLeft < 0) {
                int parts = (int) Math.ceil((double) charactersUsed / SMS_MAX_LIMIT);
                System.out.println("Notice: Message exceeds 160 characters! Will be sent as " + parts + " SMS parts.");
            }
            System.out.println("----------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
