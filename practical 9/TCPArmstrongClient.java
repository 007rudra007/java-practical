import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Practical 9 - Program 1: TCP Client for Armstrong Number Checking
 *
 * Description:
 * Connects to the TCP server at localhost:6789, prompts user for a number,
 * transmits it to the server, and prints the result returned by the server.
 */
public class TCPArmstrongClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 6789;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 9.1: TCP Armstrong Client              ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer number to check (e.g. 153, 370, 1634): ");
            String numberInput = scanner.nextLine().trim();

            System.out.println("\nConnecting to TCP server at " + SERVER_HOST + ":" + SERVER_PORT + "...");
            try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
                System.out.println("Connected to server successfully!");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Send number to server
                System.out.println("Sending number: " + numberInput);
                out.println(numberInput);

                // Receive response from server
                String serverResponse = in.readLine();
                System.out.println("\n----------------- Server Response -----------------");
                System.out.println(serverResponse);
                System.out.println("---------------------------------------------------");
            }

        } catch (Exception e) {
            System.err.println("Client Error: Could not connect to server. Ensure TCPArmstrongServer is running.");
            System.err.println("Details: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
