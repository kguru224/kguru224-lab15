import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JComboBox<Integer> innerBox;
    private JComboBox<Integer> middleBox;
    private JComboBox<Integer> outerBox;
    private JTextField startField;

    private JButton encryptButton;
    private JButton decryptButton;

    public EnigmaFrame() {

        super("Enigma Machine GUI");

        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 

        // Top panel for the rotor selection

        JPanel settingPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(3,4,10,5));

        // Labels for the rotors and starting letters
        JLabel innerLabel = new JLabel("Inner Rotor");
        JLabel middleLabel = new JLabel("Middle Rotor");
        JLabel outerLabel = new JLabel("Outer Rotor");
        JLabel startLabel = new JLabel("Starting Latters");

        // Combo boxes for the rotors selection

        Integer[] rotorChoices = {1,2,3,4,5};
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
        settingsPanel.add(outBox);

        settingsPanel.add(startLabel);
        settingsPanel.add(startField);

        add(settingsPanel BorderLayout.NORTH);

        // Center panel for the text area (input and output)

        JPanel ioPanel = new JPanel(new GridLayout(1,2,10,10));

        inputArea = new JTextArea();
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane inputScroll = new JScrollPane(inputArea);
        JScrollPane outputScroll = new JScrollPane(outputArea);

        ioPanel.add(inputScroll);
        ioPanel.add(outputScroll);

        add(ioPanel, BorderLayout.CENTER);

        // Bottom panel for the buttons

        JPanel buttonPanel = new JButton();

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button logic 

        encryptButton.addActionListener(e -> process("encrypt"));
        decryptButton.addActionListener(e -> process("decrypt"));

        setVisible(true);

    }



}