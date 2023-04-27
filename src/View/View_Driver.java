package View;

import javax.swing.*;

public class View_Driver extends JFrame{
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JButton firstButton;
    private JButton lastButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextPane testTextPane;

    public View_Driver(){

        setContentPane(mainPanel);
        setTitle("Projet Java Antony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(810, 450);
        setVisible(true);
    }
}
