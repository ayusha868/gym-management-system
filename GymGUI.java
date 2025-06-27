import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GymGUI extends JFrame implements ActionListener
{
    
        //Create an ArrayList to store objects of GymMember
        //This list will hold both Regular and premium member objects
     private ArrayList<GymMember> memberList = new ArrayList<GymMember>();
        private ArrayList<GymMember> members;
    private JTextField idField, nameField, locationField, phoneField, emailField, referralSourceField, paidAmountField, removalReasonField, trainerNameField;
    private JComboBox<Integer> dobYearComboBox, dobMonthComboBox, dobDayComboBox, msYearComboBox, msMonthComboBox, msDayComboBox;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JComboBox<String> planComboBox;
    private JTextField regularPriceField, premiumChargeField, discountAmountField;
    private JButton addRegularButton, addPremiumButton, activateButton, deactivateButton, markAttendanceButton, revertRegularButton, revertPremiumButton, displayButton, clearButton;
    private JTextField memberIdInput;

    public GymGUI() {
        // GUI initialization code 
        setTitle("Gym Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout()); // Main layout GridBagLayout
        members = new ArrayList<>();
        

        // Initializing components
        idField = new JTextField(10);
        nameField = new JTextField(10);
        locationField = new JTextField(10);
        phoneField = new JTextField(10);
        emailField = new JTextField(10);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        dobYearComboBox = new JComboBox<>();
        dobMonthComboBox = new JComboBox<>();
        dobDayComboBox = new JComboBox<>();
        msYearComboBox = new JComboBox<>();
        msMonthComboBox = new JComboBox<>();
        msDayComboBox = new JComboBox<>();

        populateYearComboBox(dobYearComboBox, 1950, 2025);
        populateMonthComboBox(dobMonthComboBox);
        populateDayComboBox(dobDayComboBox);
        populateYearComboBox(msYearComboBox, 2000, 2030);
        populateMonthComboBox(msMonthComboBox);
        populateDayComboBox(msDayComboBox);

        referralSourceField = new JTextField(10);
        paidAmountField = new JTextField(10);
        removalReasonField = new JTextField(10);
        trainerNameField = new JTextField(10);

        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        regularPriceField = new JTextField(10);
        premiumChargeField = new JTextField(10);
        discountAmountField = new JTextField(10);
        addRegularButton = new JButton("Add a Regular Member");
        addPremiumButton = new JButton("Add a Premium Member");
        activateButton = new JButton("Activate Membership");
        deactivateButton = new JButton("Deactivate Membership");
        markAttendanceButton = new JButton("Mark Attendance");
        revertRegularButton = new JButton("Revert Regular Member");
        revertPremiumButton = new JButton("Revert Premium Member");
        displayButton = new JButton("Display");
        clearButton = new JButton("Clear");

        memberIdInput = new JTextField(10);

        // Add action listeners
        addRegularButton.addActionListener(this);
        addPremiumButton.addActionListener(this);
        activateButton.addActionListener(this);
        deactivateButton.addActionListener(this);
        markAttendanceButton.addActionListener(this);
        revertRegularButton.addActionListener(this);
        revertPremiumButton.addActionListener(this);
        displayButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Layout the components
        layoutGUI();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void layoutGUI() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST; // Left-align components

        //  Member Details Section 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(createSectionLabel("Member Details"), gbc);

        gbc.gridwidth = 1; // Reset width

        addComponent(gbc, new JLabel("ID:"), 0, 1);
        addComponent(gbc, idField, 1, 1);
        addComponent(gbc, new JLabel("Name:"), 0, 2);
        addComponent(gbc, nameField, 1, 2);
        addComponent(gbc, new JLabel("Location:"), 0, 3);
        addComponent(gbc, locationField, 1, 3);
        addComponent(gbc, new JLabel("Phone:"), 0, 4);
        addComponent(gbc, phoneField, 1, 4);
        addComponent(gbc, new JLabel("Email:"), 0, 5);
        addComponent(gbc, emailField, 1, 5);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(createSubLabel("Gender:"), gbc);
        gbc.gridwidth = 1;

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Using FlowLayout for radio buttons
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(createSubLabel("Date of Birth:"), gbc);
        gbc.gridwidth = 1;

        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // FlowLayout for dates
        dobPanel.add(dobYearComboBox);
        dobPanel.add(dobMonthComboBox);
        dobPanel.add(dobDayComboBox);
        gbc.gridx = 1;
        gbc.gridy = 9;
        add(dobPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        add(createSubLabel("Membership Start Date:"), gbc);
        gbc.gridwidth = 1;

        JPanel msPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // FlowLayout for dates
        msPanel.add(msYearComboBox);
        msPanel.add(msMonthComboBox);
        msPanel.add(msDayComboBox);
        gbc.gridx = 1;
        gbc.gridy = 11;
        add(msPanel, gbc);

        addComponent(gbc, new JLabel("Referral Source:"), 0, 12);
        addComponent(gbc, referralSourceField, 1, 12);
        addComponent(gbc, new JLabel("Paid Amount:"), 0, 13);
        addComponent(gbc, paidAmountField, 1, 13);

        // --- Revert Member Section ---
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2;
        add(createSectionLabel("Revert Member"), gbc);
        gbc.gridwidth = 1;

        addComponent(gbc, new JLabel("Removal Reason:"), 0, 15);
        addComponent(gbc, removalReasonField, 1, 15);

        // --- Premium Member Section ---
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 2;
        add(createSectionLabel("Premium Member"), gbc);
        gbc.gridwidth = 1;

        addComponent(gbc, new JLabel("Trainer's Name:"), 0, 17);
        addComponent(gbc, trainerNameField, 1, 17);

        // --- Plan Details Section ---
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.gridwidth = 2;
        add(createSectionLabel("Plan Details"), gbc);
        gbc.gridwidth = 1;

        addComponent(gbc, new JLabel("Plan:"), 0, 19);
        addComponent(gbc, planComboBox, 1, 19);
        addComponent(gbc, new JLabel("Regular Plan Price:"), 0, 20);
        addComponent(gbc, regularPriceField, 1, 20);
        addComponent(gbc, new JLabel("Premium Plan Charge:"), 0, 21);
        addComponent(gbc, premiumChargeField, 1, 21);
        addComponent(gbc, new JLabel("Discount Amount:"), 0, 22);
        addComponent(gbc, discountAmountField, 1, 22);

        // --- Button Section ---
        gbc.gridx = 0;
        gbc.gridy = 23;
        gbc.gridwidth = 2;
        add(createSectionLabel("Actions"), gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 24;
        gbc.gridwidth = 1;
        add(addRegularButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 24;
        gbc.gridwidth = 1;
        add(addPremiumButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 25;
        gbc.gridwidth = 1;
        add(new JLabel("Member ID:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 25;
        gbc.gridwidth = 1;
        add(memberIdInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 26;
        gbc.gridwidth = 1;
        add(activateButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 26;
        gbc.gridwidth = 1;
        add(deactivateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 27;
        gbc.gridwidth = 1;
        add(markAttendanceButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 27;
        gbc.gridwidth = 1;
        add(revertRegularButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 28;
        gbc.gridwidth = 1;
        add(revertPremiumButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 28;
        gbc.gridwidth = 1;
        add(displayButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 29;
        gbc.gridwidth = 2;
        add(clearButton, gbc);
    }

    // Helper methods
    private void addComponent(GridBagConstraints gbc, Component component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(component, gbc);
    }

    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14));
        return label;
    }

    private JLabel createSubLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 12));
        return label;
    }

    private void populateYearComboBox(JComboBox<Integer> comboBox, int startYear, int endYear) {
        for (int i = startYear; i <= endYear; i++) {
            comboBox.addItem(i);
        }
    }

    private void populateMonthComboBox(JComboBox<Integer> comboBox) {
        for (int i = 1; i <= 12; i++) {
            comboBox.addItem(i);
        }
    }

    private void populateDayComboBox(JComboBox<Integer> comboBox) {
        for (int i = 1; i <= 31; i++) {
            comboBox.addItem(i);
        }
    }

    // ActionPerformed and other methods (addRegularMember, etc.)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRegularButton) {
            addRegularMember();
        } else if (e.getSource() == addPremiumButton) {
            addPremiumMember();
        } else if (e.getSource() == activateButton) {
            activateMember();
        } else if (e.getSource() == deactivateButton) {
            deactivateMember();
        } else if (e.getSource() == markAttendanceButton) {
            markAttendance();
        } else if (e.getSource() == revertRegularButton) {
            revertRegularMember();
        } else if (e.getSource() == revertPremiumButton) {
            revertPremiumMember();
        } else if (e.getSource() == displayButton) {
            displayMembers();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    private void addRegularMember() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            int dobYear = (int) dobYearComboBox.getSelectedItem();
            int dobMonth = (int) dobMonthComboBox.getSelectedItem();
            int dobDay = (int) dobDayComboBox.getSelectedItem();
            String dob = String.format("%04d-%02d-%02d", dobYear, dobMonth, dobDay);
            int msYear = (int) msYearComboBox.getSelectedItem();
            int msMonth = (int) msMonthComboBox.getSelectedItem();
            int msDay = (int) msDayComboBox.getSelectedItem();
            String membershipStartDate = String.format("%04d-%02d-%02d", msYear, msMonth, msDay);
            String referralSource = referralSourceField.getText();
            String paidAmountText = paidAmountField.getText();
            double paidAmount;
            try {
                paidAmount = Double.parseDouble(paidAmountText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid Paid Amount. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isDuplicateId(id)) {
                JOptionPane.showMessageDialog(this, "Member ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            RegularMember member = new RegularMember(id, name, location, phone, email, gender,dob, membershipStartDate,referralSource);
            members.add(member);
            JOptionPane.showMessageDialog(this, "Regular Member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check the fields (ID, etc.).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPremiumMember() {
        //try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            int dobYear = (int) dobYearComboBox.getSelectedItem();
            int dobMonth = (int) dobMonthComboBox.getSelectedItem();
            int dobDay = (int) dobDayComboBox.getSelectedItem();
            String DOB = String.format("%04d-%02d-%02d", dobYear, dobMonth, dobDay);
            int msYear = (int) msYearComboBox.getSelectedItem();
            int msMonth = (int) msMonthComboBox.getSelectedItem();
            int msDay = (int) msDayComboBox.getSelectedItem();
            String membershipStartDate = String.format("%04d-%02d-%02d", msYear, msMonth, msDay);
            String trainerName = trainerNameField.getText();
            String paidAmountText = paidAmountField.getText();
            double paidAmount;
            try {
                paidAmount = Double.parseDouble(paidAmountText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid Paid Amount. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isDuplicateId(id)) {
                JOptionPane.showMessageDialog(this, "Member ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            PremiumMember member = new PremiumMember(id,name,location,phone,email,gender,DOB,membershipStartDate,trainerName);
            members.add(member);
            JOptionPane.showMessageDialog(this, "Premium Member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
         //catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(this, "Invalid input. Please check the fields (ID, etc.).", "Error", JOptionPane.ERROR_MESSAGE);
        
    }

    private void activateMember() {
        try {
            int idToActivate = Integer.parseInt(memberIdInput.getText());
            for (GymMember member : members) {
                if (member.getId() == idToActivate) {
                    member.activateMembership();
                    JOptionPane.showMessageDialog(this, "Member activated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Member with ID " + idToActivate + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deactivateMember() {
        try {
            int idToDeactivate = Integer.parseInt(memberIdInput.getText());
            for (GymMember member : members) {
                if (member.getId() == idToDeactivate) {
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(this, "Member deactivated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Member with ID " + idToDeactivate + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void markAttendance() {
        try {
        int idToMark = Integer.parseInt(memberIdInput.getText());
        GymMember foundMember = null; 

        for (GymMember member : members) {
            if (member.getId() == idToMark) {
                foundMember = member; // for Storing the member if found
                break; // for Exiting the loop since we found the member
            }
        }

        if (foundMember != null) { // Checking if a member was found
            if (foundMember.isActiveStatus()) { 
                foundMember.markAttendance();
                JOptionPane.showMessageDialog(this, "Attendance marked.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Member is not active.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Member with ID " + idToMark + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void revertRegularMember() {
        try {
            int idToRevert = Integer.parseInt(memberIdInput.getText());
            String removalReason = removalReasonField.getText();
            for (GymMember member : members) {
                if (member.getId() == idToRevert && member instanceof RegularMember) {
                    ((RegularMember) member).revertRegularMember(removalReason);
                    members.remove(member);
                    JOptionPane.showMessageDialog(this, "Regular Member is reverted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Regular Member with ID " + idToRevert + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void revertPremiumMember() {
        try {
            int idToRevert = Integer.parseInt(memberIdInput.getText());
            for (GymMember member : members) {
                if (member.getId() == idToRevert && member instanceof PremiumMember) {
                    ((PremiumMember) member).revertPremiumMember();
                    members.remove(member);
                    JOptionPane.showMessageDialog(this, "Premium Member is reverted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Premium Member with ID " + idToRevert + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayMembers() {
        JFrame displayFrame = new JFrame("Member Details");
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        for (GymMember member : members) {
            textArea.append(member.toString() + "\n");
        }

        displayFrame.add(scrollPane);
        displayFrame.pack();
        displayFrame.setVisible(true);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        genderGroup.clearSelection();
        if (dobYearComboBox.getItemCount() > 0) dobYearComboBox.setSelectedIndex(0);
        if (dobMonthComboBox.getItemCount() > 0) dobMonthComboBox.setSelectedIndex(0);
        if (dobDayComboBox.getItemCount() > 0) dobDayComboBox.setSelectedIndex(0);
        if (msYearComboBox.getItemCount() > 0) msYearComboBox.setSelectedIndex(0);
        if (msMonthComboBox.getItemCount() > 0) msMonthComboBox.setSelectedIndex(0);
        if (msDayComboBox.getItemCount() > 0) msDayComboBox.setSelectedIndex(0);
        referralSourceField.setText("");
        paidAmountField.setText("");
        removalReasonField.setText("");
        trainerNameField.setText("");
        planComboBox.setSelectedIndex(0);
        memberIdInput.setText("");
    }

    private boolean isDuplicateId(int id) {
        for (GymMember member : members) {
            if (member.getId() == id) {
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        new GymGUI();
    }
}

    
    
    
        
        
    
        
    
