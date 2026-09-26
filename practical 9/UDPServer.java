import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Practical 9 - Program 2: UDP Server for String Message Exchange
 *
 * Description:
 * Listens on UDP port 9876 using DatagramSocket and DatagramPacket.
 * Receives string messages from UDP clients and sends an acknowledgment reply.
 */
public class UDPServer {

    private static final int PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 9.2: UDP String Message Server         ");
        System.out.println("==================================================");

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server is running on port " + PORT + "...");
            System.out.println("Waiting for UDP datagram packets...\n");

            byte[] receiveBuffer = new byte[BUFFER_SIZE];

            while (true) {
                // Prepare packet for receiving
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                // Extract message
                String clientMessage = new String(
                        receivePacket.getData(), 0, receivePacket.getLength()
                ).trim();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Received from [" + clientAddress.getHostAddress() + ":" + clientPort + "]: \"" + clientMessage + "\"");

                // Prepare acknowledgment reply
                String replyMessage = "Server Acknowledgment: Received your message ('" + clientMessage + "')";
                byte[] sendBuffer = replyMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer, sendBuffer.length, clientAddress, clientPort
                );

                serverSocket.send(sendPacket);
                System.out.println("Sent acknowledgment back to client.\n");
            }

        } catch (Exception e) {
            System.err.println("UDP Server Error: " + e.getMessage());
        }
    }
}
