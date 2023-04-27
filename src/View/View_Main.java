package View;

import javax.swing.*;

public class View_Main extends JFrame{


    private JButton driversButton;
    private JButton trucksButton;
    private JButton travelsButton;
    private JButton statsButton;
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JPanel menuPanel;
    private JButton firstButton;
    private JButton lastButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextPane testTextPane;


    public View_Main(){

        setContentPane(mainPanel);
        setTitle("Projet Java Antony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(810, 450);
        setVisible(true);
    }

}
