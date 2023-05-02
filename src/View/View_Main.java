package View;

import Controller.Controller_Driver;
import Controller.Controller_Travel;
import Controller.Controller_Truck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Main extends JFrame{
    Controller_Driver c_driver = new Controller_Driver();
    Controller_Travel c_travel = new Controller_Travel();
    Controller_Truck c_truck = new Controller_Truck();

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
        View_Driver v_driver = new View_Driver(View_Main.this, c_driver);
        v_driver.add(v_driver.getDriverPanel());
        setContentPane(v_driver);
    }

    public void show_View_Truck() {
        View_Truck v_truck = new View_Truck();
        setContentPane(v_truck);
        // pack, center, and show your new view here
        pack();
    }

    public void show_View_Travel() {
        View_Travel v_travel = new View_Travel();
        setContentPane(v_travel);
        // pack, center, and show your new view here
        pack();
    }

    public void show_View_Stats() {
        View_Stats v_stats = new View_Stats(View_Main.this, c_travel, c_driver, c_truck);
        v_stats.add(v_stats.getDriverPanel());
        setContentPane(v_stats);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
