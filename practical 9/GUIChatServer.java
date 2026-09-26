import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Practical 9 - Program 4: GUI-Based Message Exchange - Server
 *
 * Requirements:
 *   - GUI with one text input component and Send button.
 *   - Exchanges real-time messages with the client.
 */
public class GUIChatServer extends JFrame implements ActionListener {

    private static final int PORT = 8888;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public GUIChatServer() {
        setTitle("GUI Chat Server - Practical 9.4");
        setSize(420, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat History Display
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        chatArea.setBackground(new Color(245, 247, 250));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input Panel with one Text Field & Send Button
        JPanel inputPanel = new JPanel(new BorderLayout(8, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        messageField = new JTextField();
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        messageField.addActionListener(this); // Allows pressing Enter to send

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        sendButton.setBackground(new Color(30, 100, 220));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.addActionListener(this);

        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Start background socket listener thread
        new Thread(this::startServer).start();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Server started on port " + PORT + ". Waiting for client...\n"));

            clientSocket = serverSocket.accept();
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Client connected from " + clientSocket.getRemoteSocketAddress() + "\n\n"));

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                String clientMsg = message;
                SwingUtilities.invokeLater(() -> chatArea.append("Client: " + clientMsg + "\n"));
            }

        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Connection closed or error: " + e.getMessage() + "\n"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            if (out != null) {
                out.println(message);
                chatArea.append("Server (You): " + message + "\n");
                messageField.setText("");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Client is not connected yet!",
                        "Status",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIChatServer().setVisible(true);
        });
    }
}
