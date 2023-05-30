package View;

import Controller.Controller_Driver;
import Controller.Controller_Travel;
import Controller.Controller_Truck;
import Model.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View_Stats extends JPanel {
    private JPanel titlePanel;
    private JTextPane statTextPane;
    private JPanel statsPanel;
    private JButton backMainMenuButton;


    public View_Stats(View_Main vm, Controller_Travel c_travel, Controller_Driver c_driver, Controller_Truck c_truck) {
        Font font = new Font("Dialog", Font.BOLD, 14);
//        scrollPane.setBackground(new Color(0));
//        scrollPane.setPreferredSize(statTextPane.getPreferredSize());
        statTextPane.setBorder(BorderFactory.createLoweredBevelBorder());
//        scrollPane.setViewportView(statTextPane);
        statTextPane.setText("Quelques stats :");

        JLabel label1 = new JLabel();
        label1.setText("Driver who drove the most : ");
        label1.setBounds(10,70,550,20);
        label1.setFont(font);
        statTextPane.add(label1);

        JLabel stat1 = new JLabel();
        stat1.setText(c_travel.Total_Driver(c_driver));
        stat1.setBounds(10,90,550,20);
        stat1.setFont(font);
        stat1.setForeground(Color.blue);
        statTextPane.add(stat1);

        JLabel label2 = new JLabel();
        label2.setText("Truck which has been driven the most : ");
        label2.setBounds(550,70,550,20);
        label2.setFont(font);
        statTextPane.add(label2);

        JLabel stat2 = new JLabel();
        stat2.setText(c_travel.Total_Truck(c_truck));
        stat2.setBounds(550,90,550,20);
        stat2.setFont(font);
        stat2.setForeground(Color.blue);
        statTextPane.add(stat2);

        JLabel label3 = new JLabel();
        label3.setText("Driver who drove the most different Trucks : ");
        label3.setBounds(10,140,550,20);
        label3.setFont(font);
        statTextPane.add(label3);

        JLabel stat3 = new JLabel();
        stat3.setText(c_travel.Travels_byDriver(c_driver));
        stat3.setBounds(10,160,550,20);
        stat3.setFont(font);
        stat3.setForeground(Color.blue);
        statTextPane.add(stat3);

        JLabel label4 = new JLabel();
        label4.setText("Truck which has been driven the most by different Drivers : ");
        label4.setBounds(550,140,550,20);
        label4.setFont(font);
        statTextPane.add(label4);

        JLabel stat4 = new JLabel();
        stat4.setText(c_travel.Travels_byTruck(c_truck));
        stat4.setBounds(550,160,550,20);
        stat4.setFont(font);
        stat4.setForeground(Color.blue);
        statTextPane.add(stat4);

        JLabel label5 = new JLabel();
        label5.setText("Driver who drove the longest single Travel : ");
        label5.setBounds(10,210,550,20);
        label5.setFont(font);
        statTextPane.add(label5);

        JLabel stat5 = new JLabel();
        stat5.setText(c_travel.Top_sDriver(c_driver));
        stat5.setBounds(10,230,550,20);
        stat5.setFont(font);
        stat5.setForeground(Color.blue);
        statTextPane.add(stat5);

        JLabel label6 = new JLabel();
        label6.setText("Truck which has the longest single Travel : ");
        label6.setBounds(550,210,550,20);
        label6.setFont(font);
        statTextPane.add(label6);

        JLabel stat6 = new JLabel();
        stat6.setText(c_travel.Top_sTruck(c_truck));
        stat6.setBounds(550,230,550,20);
        stat6.setFont(font);
        stat6.setForeground(Color.blue);
        statTextPane.add(stat6);

        JLabel label7 = new JLabel();
        label7.setText("List each Truck drove by a selected Driver : ");
        label7.setBounds(10,300,550,30);
        label7.setFont(font);
        statTextPane.add(label7);

        JComboBox<String> selectDriverCombo = new JComboBox<>();

        for (int key : c_driver.map_drivers.keySet()) {
            selectDriverCombo.addItem("Driver "+key+" : "+c_driver.Driver_display_name(key));
        }

//        selectDriverCombo.setModel(new DefaultComboBoxModel<>(c_driver.list_drivers.toArray(new Driver[0])));
        selectDriverCombo.setBounds(10,330,200,30);
        statTextPane.add(selectDriverCombo);

        JLabel stat7 = new JLabel();
        stat7.setText("Select a Driver");
        stat7.setBounds(220,333,800,20);
        stat7.setFont(font);
        stat7.setForeground(Color.blue);
        statTextPane.add(stat7);

        selectDriverCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stat7.setText(c_travel.List_truck_by_driver(c_driver, c_truck, selectDriverCombo.getSelectedIndex()));
            }
        });

        JLabel label8 = new JLabel();
        label8.setText("List each Driver that drove a selected Truck :  ");
        label8.setBounds(10,400,550,30);
        label8.setFont(font);
        statTextPane.add(label8);

        JComboBox<String> selectTruckCombo = new JComboBox<>();

        try {
            for (int i = 0; i < c_truck.Truck_length(); i++) {
                selectTruckCombo.addItem("Truck "+i+" : "+c_truck.Truck_display_name(i));
            }
        } catch (Exception e) {
            System.out.println("error 2");
        }

        //selectTruckCombo.setModel(new DefaultComboBoxModel<>(c_truck.list_Truck.toArray(new Driver[0])));
        selectTruckCombo.setBounds(10,430,200,30);
        statTextPane.add(selectTruckCombo);

        JLabel stat8 = new JLabel();
        stat8.setText("Select a Truck");
        stat8.setBounds(220,433,800,20);
        stat8.setFont(font);
        stat8.setForeground(Color.blue);
        statTextPane.add(stat8);

        selectTruckCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stat8.setText(c_travel.List_driver_used_truck(c_driver, c_truck, selectTruckCombo.getSelectedIndex()));
            }
        });


        backMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.setContentPane(vm.getMainPanel());
                vm.revalidate();

            }
        });

    }

    public JPanel getStatPanel() {
        return statsPanel;
    }


}
