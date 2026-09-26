import javax.swing.*;
import java.awt.*;

/**
 * Practical 7 - Page (c): Registration Form GUI Design (Without Event Handling)
 *
 * Visual Features:
 *   - Dark Theme Background (#2B3543)
 *   - Yellow Title Header: "Registration Form"
 *   - Fields:
 *       • Name: "Ram"
 *       • Father Name: "Kumar"
 *       • Age: "23"
 *       • Gender: (•) Male  ( ) Female
 *       • Course: JComboBox ("Java", "Python", "C++", "PHP")
 *       • Hobbies: [✓] Drawing  [ ] Singing  [ ] Music  [ ] Others
 *       • Address: JTextArea inside JScrollPane with prefilled sample address
 *   - Bottom Action Buttons:
 *       • [Save Details] (Blue)
 *       • [Clear All]    (Red)
 */
public class RegistrationForm extends JFrame {

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(520, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Theme Colors
        Color darkBg = new Color(43, 53, 67);       // Dark Slate Blue Background
        Color textWhite = Color.WHITE;
        Color titleYellow = new Color(245, 220, 60); // Yellow Header
        Color blueBtn = new Color(20, 60, 210);      // Blue Button
        Color redBtn = new Color(215, 30, 30);       // Red Button

        // Main Container Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(darkBg);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 14);

        // 0. Title Header
        JLabel titleLabel = new JLabel("Registration Form", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(titleYellow);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 8, 15, 8);
        mainPanel.add(titleLabel, gbc);

        // Helper Lambda / Settings for Row Addition
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

        JTextField nameField = new JTextField("Ram", 20);
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

        JTextField fatherField = new JTextField("Kumar", 20);
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

        JTextField ageField = new JTextField("23", 20);
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

        JRadioButton maleRadio = new JRadioButton("Male", true);
        maleRadio.setFont(labelFont);
        maleRadio.setForeground(textWhite);
        maleRadio.setOpaque(false);

        JRadioButton femaleRadio = new JRadioButton("Female", false);
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
        JComboBox<String> courseCombo = new JComboBox<>(courses);
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

        JCheckBox chkDrawing = new JCheckBox("Drawing", true);
        chkDrawing.setFont(labelFont);
        chkDrawing.setForeground(textWhite);
        chkDrawing.setOpaque(false);

        JCheckBox chkSinging = new JCheckBox("Singing", false);
        chkSinging.setFont(labelFont);
        chkSinging.setForeground(textWhite);
        chkSinging.setOpaque(false);

        JCheckBox chkMusic = new JCheckBox("Music", false);
        chkMusic.setFont(labelFont);
        chkMusic.setForeground(textWhite);
        chkMusic.setOpaque(false);

        JCheckBox chkOthers = new JCheckBox("Others", false);
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

        JTextArea addressArea = new JTextArea("234 - 1d First Street,\nAnna Main Road\nNamakkal", 4, 20);
        addressArea.setFont(inputFont);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addressScroll = new JScrollPane(addressArea);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addressScroll, gbc);

        // 8. Buttons Panel (Save Details / Clear All)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);

        JButton saveBtn = new JButton("Save Details");
        saveBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        saveBtn.setBackground(blueBtn);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFocusPainted(false);
        saveBtn.setPreferredSize(new Dimension(130, 32));

        JButton clearBtn = new JButton("Clear All");
        clearBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        clearBtn.setBackground(redBtn);
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);
        clearBtn.setPreferredSize(new Dimension(130, 32));

        buttonPanel.add(saveBtn);
        buttonPanel.add(clearBtn);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 8, 5, 8);
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegistrationForm().setVisible(true);
        });
    }
}
