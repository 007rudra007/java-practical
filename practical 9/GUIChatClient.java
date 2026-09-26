import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Practical 9 - Program 4: GUI-Based Message Exchange - Client
 *
 * Requirements:
 *   - GUI with one text input component and Send button.
 *   - Connects to GUIChatServer and exchanges real-time messages.
 */
public class GUIChatClient extends JFrame implements ActionListener {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public GUIChatClient() {
        setTitle("GUI Chat Client - Practical 9.4");
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
        new Thread(this::connectToServer).start();
    }

    private void connectToServer() {
        try {
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Connecting to server at " + SERVER_HOST + ":" + SERVER_PORT + "...\n"));
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Connected to Chat Server successfully!\n\n"));

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                String serverMsg = message;
                SwingUtilities.invokeLater(() -> chatArea.append("Server: " + serverMsg + "\n"));
            }

        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> chatArea.append("[System]: Connection failed or lost. Make sure GUIChatServer is running.\n"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            if (out != null) {
                out.println(message);
                chatArea.append("Client (You): " + message + "\n");
                messageField.setText("");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Not connected to server yet!",
                        "Status",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIChatClient().setVisible(true);
        });
    }
}
