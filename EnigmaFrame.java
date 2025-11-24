import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JComboBox<Integer> innerBox;
    private JComboBox<Integer> middleBox;
    private JComboBox<Integer> outerBox;
    private JTextField startField;

    private JTextArea inputArea;
    private JTextArea outputArea;

    private JButton encryptButton;
    private JButton decryptButton;

    public EnigmaFrame() {

        super("Enigma Machine GUI");

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); 

        // Top panel for the rotor selection

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(4, 2, 10, 10));
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels for the rotors and starting letters
        JLabel innerLabel = new JLabel("Inner Rotor:");
        JLabel middleLabel = new JLabel("Middle Rotor:");
        JLabel outerLabel = new JLabel("Outer Rotor:");
        JLabel startLabel = new JLabel("Starting Letters:");

        // Combo boxes for the rotors selection

        Integer[] rotorChoices = {1, 2, 3, 4, 5};
        innerBox = new JComboBox<>(rotorChoices);
        middleBox = new JComboBox<>(rotorChoices);
        outerBox = new JComboBox<>(rotorChoices);

        // Starting letters positions

        startField = new JTextField(3);

        settingsPanel.add(innerLabel);
        settingsPanel.add(innerBox);

        settingsPanel.add(middleLabel);
        settingsPanel.add(middleBox);

        settingsPanel.add(outerLabel);
        settingsPanel.add(outerBox);

        settingsPanel.add(startLabel);
        settingsPanel.add(startField);

        add(settingsPanel, BorderLayout.NORTH);

        // Center panel for the text area (input and output)

        JPanel ioPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        ioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input label and area
        JLabel inputLabel = new JLabel("Plaintext Input:");
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane inputScroll = new JScrollPane(inputArea);

        // Output label and area
        JLabel outputLabel = new JLabel("Output:");
        outputArea = new JTextArea();
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);

        ioPanel.add(inputLabel);
        ioPanel.add(outputLabel);
        ioPanel.add(inputScroll);
        ioPanel.add(outputScroll);

        add(ioPanel, BorderLayout.CENTER);

        // Bottom panel for the buttons

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        // Set button sizes
        encryptButton.setPreferredSize(new Dimension(120, 40));
        decryptButton.setPreferredSize(new Dimension(120, 40));

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button logic 

        encryptButton.addActionListener(e -> process("encrypt"));
        decryptButton.addActionListener(e -> process("decrypt"));

        setVisible(true);

    }

    private void process(String mode) {

        try{
            int r1 = (int) innerBox.getSelectedItem();
            int r2 = (int) middleBox.getSelectedItem();
            int r3 = (int) outerBox.getSelectedItem();
 

            String start = startField.getText().trim().toUpperCase();

            if(start.length() != 3){
                JOptionPane.showMessageDialog(this, "Starting letters should be 3 characters.");
                return;
            }
            
            // Check that the  starting characters are valid 
            for(char c : start.toCharArray()) {
                if(!Character.isUpperCase(c) && c != '#') {
                    JOptionPane.showMessageDialog(this, "Starting letters should be uppercase A-Z or #");
                    return;
                } 
            }

            String message = inputArea.getText().trim().toUpperCase();
            
            if(message.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter text to encrypt/decrypt.");
                return;
            }

            String[] args = {String.valueOf(r1), String.valueOf(r2), String.valueOf(r3), start, mode, message};

            System.out.println("Processing: " + mode + " with rotors " + r1 + " " + r2 + " " + r3 + " and start " + start);
            System.out.println("Message: " + message);
            System.out.flush();
            
            String result = Comms.run(args);
            
            System.out.println("Result: " + result);
            System.out.flush();
            outputArea.setText(result);
        }

        catch (Throwable ex) {
            System.out.println("CAUGHT EXCEPTION!");
            System.out.println("Exception type: " + ex.getClass().getName());
            System.out.println("Exception message: " + ex.getMessage());
            ex.printStackTrace(System.out);
            System.out.flush();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }

}