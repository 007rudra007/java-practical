import javax.swing.*;
import java.awt.*;

/**
 * Practical 7 - Page (b): Calculator GUI Design (Without Event Handling)
 *
 * Components:
 *   - Device Frame with modern styling
 *   - LCD Display showing "0"
 *   - 4x4 Grid of Buttons:
 *       7   8   9   ÷
 *       4   5   6   x
 *       1   2   3   -
 *       0   .   +   =
 */
public class CalculatorPage extends JFrame {

    public CalculatorPage() {
        setTitle("Calculator");
        setSize(320, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Outer Dark Container Frame Panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(60, 64, 72));
        bodyPanel.setLayout(new BorderLayout(15, 15));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top Display Screen Panel
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(210, 215, 222));
        displayPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(170, 175, 185), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        displayPanel.setPreferredSize(new Dimension(280, 60));

        JLabel displayLabel = new JLabel("0", SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Consolas", Font.BOLD, 36));
        displayLabel.setForeground(new Color(30, 30, 30));
        displayPanel.add(displayLabel, BorderLayout.CENTER);

        bodyPanel.add(displayPanel, BorderLayout.NORTH);

        // 4x4 Button Grid Panel
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        gridPanel.setOpaque(false);

        // Button labels in 4x4 arrangement
        String[][] buttonLabels = {
            {"7", "8", "9", "÷"},
            {"4", "5", "6", "x"},
            {"1", "2", "3", "-"},
            {"0", ".", "+", "="}
        };

        Font btnFont = new Font("Segoe UI", Font.BOLD, 22);

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                String text = buttonLabels[r][c];
                JButton btn = new JButton(text);
                btn.setFont(btnFont);
                btn.setFocusPainted(false);

                if (text.equals("=")) {
                    // Orange accent for '=' button as shown in diagram
                    btn.setBackground(new Color(235, 130, 45));
                    btn.setForeground(Color.WHITE);
                } else {
                    btn.setBackground(Color.WHITE);
                    btn.setForeground(new Color(30, 30, 30));
                }

                gridPanel.add(btn);
            }
        }

        bodyPanel.add(gridPanel, BorderLayout.CENTER);
        add(bodyPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorPage().setVisible(true);
        });
    }
}
