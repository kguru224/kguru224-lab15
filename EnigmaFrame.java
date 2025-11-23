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
    }



}