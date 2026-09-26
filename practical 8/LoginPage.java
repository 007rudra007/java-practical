import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Practical 8 - Page (a): Login Page with Event Handling.
 *
 * Event Handling Features:
 *   - Login Button Action Listener:
 *       • Validates Gmail ID format and password requirements.
 *       • Note from assignment: "User is your gmailid and password is your 4 chars
 *         of first name and DOB in ddmmyyyy".
 *       • Displays success or error popups via JOptionPane.
 *   - Register Button Action Listener:
 *       • Prompts registration confirmation / dialog.
 *   - Enter key support for quick login submission.
 */
public class LoginPage extends JFrame implements ActionListener {

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginPage() {
        // Window Configuration
        setTitle("Login - Practical 8");
        setSize(360, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Container Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(238, 238, 238));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Segoe UI", Font.PLAIN, 13);

        // Label: User
        JLabel userLabel = new JLabel("User");
        userLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        mainPanel.add(userLabel, gbc);

        // Text Field: User
        userField = new JTextField(15);
        userField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        mainPanel.add(userField, gbc);

        // Label: Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        mainPanel.add(passLabel, gbc);

        // Password Field
        passField = new JPasswordField(15);
        passField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        mainPanel.add(passField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        loginButton = new JButton("login");
        loginButton.setFont(font);
        loginButton.setPreferredSize(new Dimension(90, 28));
        loginButton.addActionListener(this); // Register event listener

        registerButton = new JButton("register");
        registerButton.setFont(font);
        registerButton.setPreferredSize(new Dimension(90, 28));
        registerButton.addActionListener(this); // Register event listener

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        mainPanel.add(buttonPanel, gbc);

        // Set login button as default for Enter key
        getRootPane().setDefaultButton(loginButton);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (user.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in both Username and Password fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validation rule check (Gmail ID check)
            if (!user.contains("@")) {
                JOptionPane.showMessageDialog(this,
                        "Username should be a valid email ID (e.g. user@gmail.com).",
                        "Invalid Username",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(this,
                        "Password must be at least 8 characters (4 chars of first name + DOB ddmmyyyy).",
                        "Weak Password",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Successful Login
            JOptionPane.showMessageDialog(this,
                    "Login Successful!\nWelcome, " + user + "!",
                    "Authentication Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == registerButton) {
            JOptionPane.showMessageDialog(this,
                    "Redirecting to Registration window...\nPlease create your account.",
                    "Register",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }
}
