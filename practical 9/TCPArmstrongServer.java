import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Practical 9 - Program 1: TCP Server for Armstrong Number Checking
 *
 * Description:
 * A TCP server that accepts a connection from a client, receives an integer number,
 * checks whether it is an Armstrong number, and returns an informative result message.
 */
public class TCPArmstrongServer {

    private static final int PORT = 6789;

    /**
     * Checks if a given number is an Armstrong (Narcissistic) number.
     */
    public static boolean isArmstrong(long num) {
        if (num < 0) return false;
        if (num == 0) return true;

        int digits = String.valueOf(num).length();
        long temp = num;
        long sum = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 9.1: TCP Armstrong Server              ");
        System.out.println("==================================================");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT + "...");
            System.out.println("Waiting for client connection...\n");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String inputLine = in.readLine();
                    if (inputLine != null) {
                        try {
                            long number = Long.parseLong(inputLine.trim());
                            System.out.println("Received number from client: " + number);

                            boolean result = isArmstrong(number);
                            String response;

                            if (result) {
                                response = number + " IS an Armstrong Number!";
                            } else {
                                response = number + " is NOT an Armstrong Number.";
                            }

                            System.out.println("Sending response: " + response);
                            out.println(response);

                        } catch (NumberFormatException e) {
                            String errResponse = "Error: '" + inputLine + "' is not a valid integer number.";
                            out.println(errResponse);
                        }
                    }

                    System.out.println("Client request handled. Socket closed.\n");
                }
            }

        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
