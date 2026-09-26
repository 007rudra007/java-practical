import javax.swing.*;
import java.awt.*;

/**
 * Practical 7 - Page (a): Login Page GUI Design (Without Event Handling)
 *
 * Components:
 *   - Frame Title: Login
 *   - User Label & Text Field
 *   - Password Label & Password Field
 *   - "login" and "register" Buttons
 */
public class LoginPage extends JFrame {

    public LoginPage() {
        // Window Configuration
        setTitle("Login");
        setSize(320, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Container Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(238, 238, 238));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label: User
        JLabel userLabel = new JLabel("User");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        mainPanel.add(userLabel, gbc);

        // Text Field: User
        JTextField userField = new JTextField(15);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        mainPanel.add(userField, gbc);

        // Label: Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        mainPanel.add(passLabel, gbc);

        // Password Field
        JPasswordField passField = new JPasswordField(15);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        mainPanel.add(passField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        JButton loginButton = new JButton("login");
        loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        loginButton.setPreferredSize(new Dimension(85, 28));

        JButton registerButton = new JButton("register");
        registerButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        registerButton.setPreferredSize(new Dimension(85, 28));

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
}
