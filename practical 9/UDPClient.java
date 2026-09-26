import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Practical 9 - Program 2: UDP Client for String Message Exchange
 *
 * Description:
 * Sends a user-input string message to the UDP server at localhost:9876
 * using DatagramSocket and receives an acknowledgment packet.
 */
public class UDPClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 9.2: UDP String Message Client         ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            // Set timeout of 5 seconds for receiving response
            clientSocket.setSoTimeout(5000);

            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);

            System.out.print("Enter string message to send to UDP server: ");
            String message = scanner.nextLine();

            // Prepare sending packet
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    sendData, sendData.length, serverAddress, SERVER_PORT
            );

            System.out.println("\nSending UDP datagram packet to " + SERVER_HOST + ":" + SERVER_PORT + "...");
            clientSocket.send(sendPacket);

            // Prepare receiving packet
            byte[] receiveData = new byte[BUFFER_SIZE];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);
            String serverReply = new String(
                    receivePacket.getData(), 0, receivePacket.getLength()
            ).trim();

            System.out.println("\n----------------- Response from UDP Server -----------------");
            System.out.println(serverReply);
            System.out.println("------------------------------------------------------------");

        } catch (Exception e) {
            System.err.println("UDP Client Error: " + e.getMessage());
            System.err.println("Ensure UDPServer is running before launching the client.");
        } finally {
            scanner.close();
        }
    }
}
