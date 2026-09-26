import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Practical 8 - Page (b): Calculator GUI with Event Handling.
 *
 * Implements basic calculator arithmetic operations:
 *   - Addition (+)
 *   - Subtraction (-)
 *   - Multiplication (x)
 *   - Division (÷)
 *   - Decimal point (.) and equals (=) evaluation
 *   - Division-by-zero validation
 */
public class CalculatorPage extends JFrame implements ActionListener {

    private JLabel displayLabel;
    private double firstOperand = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;
    private boolean isNewCalculation = true;

    public CalculatorPage() {
        setTitle("Calculator - Practical 8");
        setSize(320, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Outer Dark Container Panel
        JPanel bodyPanel = new JPanel(new BorderLayout(15, 15));
        bodyPanel.setBackground(new Color(60, 64, 72));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Top Digital Display Screen
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(210, 215, 222));
        displayPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(170, 175, 185), 2),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        displayPanel.setPreferredSize(new Dimension(280, 60));

        displayLabel = new JLabel("0", SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Consolas", Font.BOLD, 36));
        displayLabel.setForeground(new Color(30, 30, 30));
        displayPanel.add(displayLabel, BorderLayout.CENTER);

        bodyPanel.add(displayPanel, BorderLayout.NORTH);

        // 4x4 Grid of Buttons
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        gridPanel.setOpaque(false);

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
                btn.addActionListener(this); // Register action listener for each button

                if (text.equals("=")) {
                    btn.setBackground(new Color(235, 130, 45)); // Orange accent
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            // Digit clicked
            if (isNewCalculation || isOperatorClicked || displayLabel.getText().equals("0") || displayLabel.getText().equals("Error")) {
                displayLabel.setText(cmd);
                isOperatorClicked = false;
                isNewCalculation = false;
            } else {
                displayLabel.setText(displayLabel.getText() + cmd);
            }
        } else if (cmd.equals(".")) {
            // Decimal point clicked
            if (isOperatorClicked || isNewCalculation || displayLabel.getText().equals("Error")) {
                displayLabel.setText("0.");
                isOperatorClicked = false;
                isNewCalculation = false;
            } else if (!displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + ".");
            }
        } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("x") || cmd.equals("÷")) {
            // Operator clicked
            try {
                firstOperand = Double.parseDouble(displayLabel.getText());
                operator = cmd;
                isOperatorClicked = true;
            } catch (NumberFormatException ex) {
                displayLabel.setText("Error");
            }
        } else if (cmd.equals("=")) {
            // Equals button clicked
            if (operator.isEmpty() || isOperatorClicked) {
                return;
            }

            try {
                double secondOperand = Double.parseDouble(displayLabel.getText());
                double result = 0;
                boolean valid = true;

                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "x":
                        result = firstOperand * secondOperand;
                        break;
                    case "÷":
                        if (secondOperand == 0) {
                            valid = false;
                        } else {
                            result = firstOperand / secondOperand;
                        }
                        break;
                }

                if (!valid) {
                    displayLabel.setText("Error");
                } else {
                    // Display integer values without trailing .0
                    if (result == (long) result) {
                        displayLabel.setText(String.valueOf((long) result));
                    } else {
                        displayLabel.setText(String.valueOf(result));
                    }
                }

                operator = "";
                isNewCalculation = true;

            } catch (Exception ex) {
                displayLabel.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorPage().setVisible(true);
        });
    }
}
