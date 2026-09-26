import java.util.Scanner;

/**
 * Practical 3 - Question 3(d):
 * Shopping Bill Generator using StringBuilder.
 *
 * Example Output:
 * ******** SHOP BILL ********
 * Milk     : ₹50
 * Bread     : ₹40
 * Butter     : ₹80
 * ---------------------------
 * Total      : ₹170
 */
public class ShoppingBillGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.3(d): Shopping Bill Generator        ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of items in shopping cart: ");
            int count = sc.nextInt();
            sc.nextLine(); // consume newline

            String[] items;
            double[] prices;

            if (count <= 0) {
                System.out.println("No items entered. Using default sample items (Milk, Bread, Butter)...");
                items = new String[]{"Milk", "Bread", "Butter"};
                prices = new double[]{50.0, 40.0, 80.0};
                count = items.length;
            } else {
                items = new String[count];
                prices = new double[count];

                for (int i = 0; i < count; i++) {
                    System.out.print("Enter item " + (i + 1) + " name: ");
                    items[i] = sc.nextLine().trim();
                    System.out.print("Enter price for " + items[i] + " (₹): ");
                    prices[i] = sc.nextDouble();
                    sc.nextLine(); // consume newline
                }
            }

            // Build bill string using StringBuilder
            StringBuilder bill = new StringBuilder();
            bill.append("\n******** SHOP BILL ********\n");

            double total = 0.0;
            for (int i = 0; i < count; i++) {
                total += prices[i];
                // Format price as integer if whole number
                String priceStr = (prices[i] == (long) prices[i]) ? String.valueOf((long) prices[i]) : String.format("%.2f", prices[i]);
                bill.append(String.format("%-10s: ₹%s\n", items[i], priceStr));
            }

            bill.append("---------------------------\n");
            String totalStr = (total == (long) total) ? String.valueOf((long) total) : String.format("%.2f", total);
            bill.append(String.format("%-10s: ₹%s\n", "Total", totalStr));

            // Display the generated bill
            System.out.println(bill.toString());

        } catch (Exception e) {
            System.out.println("Error generating bill: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
