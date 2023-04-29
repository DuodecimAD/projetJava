package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Main extends JFrame{
    private View_Driver v_driver;
    private View_Truck v_truck;
    private View_Travel v_travel;
    private View_Stats v_stats;

    private JButton driversButton;
    private JButton trucksButton;
    private JButton travelsButton;
    private JButton statsButton;
    private JPanel mainPanel;
    private JPanel titlePanel;
    private JPanel menuPanel;


    public View_Main(){

        show_View_Main();
        setContentPane(mainPanel);
        setTitle("Projet Java Antony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        //setSize(810, 450);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        driversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                show_View_Driver();
            }
        });
        trucksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                show_View_Truck();
            }
        });
        travelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                show_View_Travel();
            }
        });
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                show_View_Stats();
            }
        });
    }

    public void show_View_Main() {
        setContentPane(mainPanel);
        // pack, center, and show your new view here
        //pack();
    }

    public void show_View_Driver() {
        v_driver = new View_Driver(View_Main.this);
        v_driver.add(v_driver.getDriverPanel());
        setContentPane(v_driver);
        // pack, center, and show your new view here
        //pack();
        //setVisible(true);
    }

    public void show_View_Truck() {
        v_truck = new View_Truck();
        setContentPane(v_truck);
        // pack, center, and show your new view here
        pack();
    }

    public void show_View_Travel() {
        v_travel = new View_Travel();
        setContentPane(v_travel);
        // pack, center, and show your new view here
        pack();
    }

    public void show_View_Stats() {
        v_stats = new View_Stats();
        setContentPane(v_stats);
        // pack, center, and show your new view here
        pack();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
