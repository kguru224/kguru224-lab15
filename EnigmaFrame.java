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
    }



}