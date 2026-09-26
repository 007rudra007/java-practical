import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Practical 8 - Page (c): Registration Form with Event Handling.
 *
 * Event Handling Features:
 *   - "Save Details" Button:
 *       • Validates all form inputs (Name, Father Name, Age, Gender, Course, Address).
 *       • Gathers selected hobbies dynamically.
 *       • Displays a formatted popup summary of the submitted student registration.
 *   - "Clear All" Button:
 *       • Resets all input text fields, radio buttons, checkboxes, and text area.
 */
public class RegistrationForm extends JFrame implements ActionListener {

    private JTextField nameField;
    private JTextField fatherField;
    private JTextField ageField;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private JComboBox<String> courseCombo;
    private JCheckBox chkDrawing;
    private JCheckBox chkSinging;
    private JCheckBox chkMusic;
    private JCheckBox chkOthers;
    private JTextArea addressArea;
    private JButton saveBtn;
    private JButton clearBtn;

    public RegistrationForm() {
        setTitle("Registration Form - Practical 8");
        setSize(520, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Theme Colors
        Color darkBg = new Color(43, 53, 67);
        Color textWhite = Color.WHITE;
        Color titleYellow = new Color(245, 220, 60);
        Color blueBtn = new Color(20, 60, 210);
        Color redBtn = new Color(215, 30, 30);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(darkBg);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);

        // Header Title
        JLabel titleLabel = new JLabel("Registration Form", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(titleYellow);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 8, 15, 8);
        mainPanel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(6, 8, 6, 8);

        // 1. Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        mainPanel.add(nameLabel, gbc);

        nameField = new JTextField("Ram", 20);
        nameField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        mainPanel.add(nameField, gbc);

        // 2. Father Name
        JLabel fatherLabel = new JLabel("Father Name");
        fatherLabel.setFont(labelFont);
        fatherLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        mainPanel.add(fatherLabel, gbc);

        fatherField = new JTextField("Kumar", 20);
        fatherField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.7;
        mainPanel.add(fatherField, gbc);

        // 3. Age
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(labelFont);
        ageLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        mainPanel.add(ageLabel, gbc);

        ageField = new JTextField("23", 20);
        ageField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.7;
        mainPanel.add(ageField, gbc);

        // 4. Gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.3;
        mainPanel.add(genderLabel, gbc);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        genderPanel.setOpaque(false);

        maleRadio = new JRadioButton("Male", true);
        maleRadio.setFont(labelFont);
        maleRadio.setForeground(textWhite);
        maleRadio.setOpaque(false);

        femaleRadio = new JRadioButton("Female", false);
        femaleRadio.setFont(labelFont);
        femaleRadio.setForeground(textWhite);
        femaleRadio.setOpaque(false);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.7;
        mainPanel.add(genderPanel, gbc);

        // 5. Course
        JLabel courseLabel = new JLabel("Course");
        courseLabel.setFont(labelFont);
        courseLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.3;
        mainPanel.add(courseLabel, gbc);

        String[] courses = {"Java", "Python", "C++", "Web Development", "Data Science"};
        courseCombo = new JComboBox<>(courses);
        courseCombo.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.7;
        mainPanel.add(courseCombo, gbc);

        // 6. Hobbies
        JLabel hobbiesLabel = new JLabel("Hobbies");
        hobbiesLabel.setFont(labelFont);
        hobbiesLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.3;
        mainPanel.add(hobbiesLabel, gbc);

        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        hobbiesPanel.setOpaque(false);

        chkDrawing = new JCheckBox("Drawing", true);
        chkDrawing.setFont(labelFont);
        chkDrawing.setForeground(textWhite);
        chkDrawing.setOpaque(false);

        chkSinging = new JCheckBox("Singing", false);
        chkSinging.setFont(labelFont);
        chkSinging.setForeground(textWhite);
        chkSinging.setOpaque(false);

        chkMusic = new JCheckBox("Music", false);
        chkMusic.setFont(labelFont);
        chkMusic.setForeground(textWhite);
        chkMusic.setOpaque(false);

        chkOthers = new JCheckBox("Others", false);
        chkOthers.setFont(labelFont);
        chkOthers.setForeground(textWhite);
        chkOthers.setOpaque(false);

        hobbiesPanel.add(chkDrawing);
        hobbiesPanel.add(chkSinging);
        hobbiesPanel.add(chkMusic);
        hobbiesPanel.add(chkOthers);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 0.7;
        mainPanel.add(hobbiesPanel, gbc);

        // 7. Address
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(labelFont);
        addressLabel.setForeground(textWhite);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(addressLabel, gbc);

        addressArea = new JTextArea("234 - 1d First Street,\nAnna Main Road\nNamakkal", 4, 20);
        addressArea.setFont(inputFont);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addressScroll = new JScrollPane(addressArea);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addressScroll, gbc);

        // 8. Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);

        saveBtn = new JButton("Save Details");
        saveBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        saveBtn.setBackground(blueBtn);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFocusPainted(false);
        saveBtn.setPreferredSize(new Dimension(130, 32));
        saveBtn.addActionListener(this); // Event listener

        clearBtn = new JButton("Clear All");
        clearBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        clearBtn.setBackground(redBtn);
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);
        clearBtn.setPreferredSize(new Dimension(130, 32));
        clearBtn.addActionListener(this); // Event listener

        buttonPanel.add(saveBtn);
        buttonPanel.add(clearBtn);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 8, 5, 8);
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            String name = nameField.getText().trim();
            String father = fatherField.getText().trim();
            String ageStr = ageField.getText().trim();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            String course = (String) courseCombo.getSelectedItem();
            String address = addressArea.getText().trim();

            // Validate required fields
            if (name.isEmpty() || father.isEmpty() || ageStr.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all required fields (Name, Father Name, Age, Address).",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validate age
            try {
                int age = Integer.parseInt(ageStr);
                if (age <= 0 || age > 120) {
                    JOptionPane.showMessageDialog(this,
                            "Please enter a valid age between 1 and 120.",
                            "Invalid Age",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Age must be a numeric integer value.",
                        "Invalid Age",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Collect selected hobbies
            List<String> hobbies = new ArrayList<>();
            if (chkDrawing.isSelected()) hobbies.add("Drawing");
            if (chkSinging.isSelected()) hobbies.add("Singing");
            if (chkMusic.isSelected()) hobbies.add("Music");
            if (chkOthers.isSelected()) hobbies.add("Others");

            String hobbiesText = hobbies.isEmpty() ? "None Selected" : String.join(", ", hobbies);

            // Display confirmation summary
            String summary = String.format(
                    "Registration Details Saved Successfully!\n\n" +
                    "Name        : %s\n" +
                    "Father Name : %s\n" +
                    "Age         : %s\n" +
                    "Gender      : %s\n" +
                    "Course      : %s\n" +
                    "Hobbies     : %s\n" +
                    "Address     : %s\n",
                    name, father, ageStr, gender, course, hobbiesText, address
            );

            JOptionPane.showMessageDialog(this, summary, "Registration Summary", JOptionPane.INFORMATION_MESSAGE);

        } else if (e.getSource() == clearBtn) {
            // Clear all fields
            nameField.setText("");
            fatherField.setText("");
            ageField.setText("");
            maleRadio.setSelected(true);
            courseCombo.setSelectedIndex(0);
            chkDrawing.setSelected(false);
            chkSinging.setSelected(false);
            chkMusic.setSelected(false);
            chkOthers.setSelected(false);
            addressArea.setText("");

            JOptionPane.showMessageDialog(this, "Form cleared successfully!", "Form Reset", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistrationForm().setVisible(true);
        });
    }
}
