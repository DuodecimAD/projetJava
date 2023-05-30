package View;

import Controller.Controller_Truck;
import Model.Truck;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class View_Truck extends JPanel {
    private JPanel menuPanel;
    private JButton newTruckButton;
    private JButton backMainMenuButton;
    private JButton selectTruckButton;
    private JButton deleteTruckButton;
    private JButton updateTruckButton;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JButton nextButton;
    private JButton previousButton;
    private JButton firstButton;
    private JButton lastButton;
    private JPanel contentPanel;
    private JTextPane messagePane;
    private JTextPane truckTextPane;
    private JPanel truckPanel;
    private final JComboBox<Truck> selectCombo = new JComboBox<>();
    private final JComboBox<Truck> updateCombo = new JComboBox<>();
    private JTextField name;
    private JTextField matricule;
    private JTextField year;
    private JTextField brand;
    private final JButton createButton = new JButton("Create");
    private final JButton updateButton = new JButton("Update");

    public View_Truck(View_Main vm, Controller_Truck c_truck) {

        vm.setContentPane(truckPanel);

        if (c_truck.Truck_length() != 0) {
            //TextPanel Trucks
            truckTextPane.setText(c_truck.getCurrentTruck().toString());
        } else {
            truckTextPane.setText("There are no Trucks, please click New Truck to create a Truck");
        }

        truckTextPane.setBorder(BorderFactory.createLoweredBevelBorder());

        backMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vm.setContentPane(vm.getMainPanel());
                //frame.pack();
                vm.revalidate();
                // frame.repaint();
                //frame.setVisible(true);
            }
        });

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_truck.goPreviousTruck();
                truckTextPane.setText(c_truck.getCurrentTruck().toString());
                if (c_truck.getTruckCurrentIndex() == 0) {
                    messagePane.setText(c_truck.goPreviousTruckError());
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_truck.goNextTruck();
                truckTextPane.setText(c_truck.getCurrentTruck().toString());
                if (c_truck.getTruckCurrentIndex() == c_truck.Truck_length() - 1) {
                    messagePane.setText(c_truck.goNextTruckError());
                }
            }
        });

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_truck.goPreviousTruckError());
                c_truck.getFirstTruck();
                truckTextPane.setText(c_truck.getCurrentTruck().toString());
            }
        });

        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_truck.goNextTruckError());
                c_truck.getLastTruck();
                truckTextPane.setText(c_truck.getCurrentTruck().toString());
            }
        });

        selectTruckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(false);
                messagePane.setVisible(false);
                truckTextPane.removeAll();
                truckTextPane.repaint();

                //contentPanel.remove(truckTextPane);
                selectCombo.setModel(new DefaultComboBoxModel<>(c_truck.map_trucks.values().toArray(new Truck[0])));
                //selectCombo = new JComboBox();
                /*for (int i = 0; i < c_truck.Truck_length(); i++) {
                    selectCombo.addItem(c_truck.list_trucks.get(i));
                }*/
                //selectCombo.setPreferredSize(new Dimension(200, 30));
                selectCombo.setBounds(50, 50, 1000, 50);
                truckTextPane.setText("Select the Truck :");
                truckTextPane.add(selectCombo);

            }
        });

        selectCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_truck.setCurrent_truck(c_truck.map_trucks.get(selectCombo.getSelectedIndex()));

                if(selectCombo.getSelectedIndex() == 0){
                    messagePane.setText(c_truck.goPreviousTruckError());
                } else if (selectCombo.getSelectedIndex() == c_truck.Truck_length()-1) {
                    messagePane.setText(c_truck.goNextTruckError());
                }

                truckTextPane.setText(c_truck.getCurrentTruck().toString());
                truckTextPane.remove(selectCombo);

                navPanel.setVisible(true);
                messagePane.setVisible(true);

            }
        });

        newTruckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                truckTextPane.removeAll();
                truckTextPane.repaint();

                truckTextPane.setText("Create the New Truck");

                JLabel nameLabel = new JLabel();
                nameLabel.setText("Name : ");
                nameLabel.setBounds(10,70,100,30);
                truckTextPane.add(nameLabel);

                name = new JTextField();
                name.setBounds(10,100,300,30);
                name.setBackground(new Color(255,255,255));
                name.setEditable(true);
                truckTextPane.add(name);

                JLabel matriculeLabel = new JLabel();
                matriculeLabel.setText("Matricule : ");
                matriculeLabel.setBounds(10,150,100,30);
                truckTextPane.add(matriculeLabel);

                matricule = new JTextField();
                matricule.setBounds(10,180,300,30);
                matricule.setBackground(new Color(255,255,255));
                matricule.setEditable(true);
                truckTextPane.add(matricule);

                JLabel yearLabel = new JLabel();
                yearLabel.setText("Year : ");
                yearLabel.setBounds(10,230,100,30);
                truckTextPane.add(yearLabel);

                year = new JTextField();
                year.setBounds(10,260,300,30);
                year.setBackground(new Color(255,255,255));
                year.setEditable(true);
                truckTextPane.add(year);

                JLabel brandLabel = new JLabel();
                brandLabel.setText("Brand : ");
                brandLabel.setBounds(10,310,100,30);
                truckTextPane.add(brandLabel);

                brand = new JTextField();
                brand.setBounds(10,340,300,30);
                brand.setBackground(new Color(255,255,255));
                brand.setEditable(true);
                truckTextPane.add(brand);


                createButton.setBounds(100,420,100,30);
                //create.setBackground(new Color(255,255,255));
                truckTextPane.add(createButton);

            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || !name.getText().matches("[a-zA-Z]+")){
                    name.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (matricule.getText().isEmpty() || !matricule.getText().matches("[A-Z0-9]+")) {
                    name.setBorder(UIManager.getBorder("TextField.border"));
                    matricule.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (year.getText().isEmpty() || !year.getText().matches("[0-9]+")) {
                    matricule.setBorder(UIManager.getBorder("TextField.border"));
                    year.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (brand.getText().isEmpty() || !brand.getText().matches("[a-zA-Z]+")) {
                    year.setBorder(UIManager.getBorder("TextField.border"));
                    brand.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    brand.setBorder(UIManager.getBorder("TextField.border"));
                    c_truck.map_trucks.put(c_truck.map_trucks.size(), new Truck(c_truck.map_trucks.size(), name.getText(), matricule.getText(), parseInt(year.getText()), brand.getText()));
                    c_truck.setCurrent_truck(c_truck.map_trucks.get(c_truck.map_trucks.size()-1));

                    truckTextPane.removeAll();

                    truckTextPane.setText(c_truck.getCurrentTruck().toString());
                    messagePane.setText(c_truck.goNextTruckError());

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);
                }
            }
        });

        updateTruckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                truckTextPane.removeAll();
                truckTextPane.repaint();
                updateCombo.setModel(new DefaultComboBoxModel<>(c_truck.map_trucks.values().toArray(new Truck[0])));
                updateCombo.setBounds(50,50,1000,50);
                truckTextPane.setText("Select the Truck you want to Update :");
                truckTextPane.add(updateCombo);
            }
        });

        updateCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_truck.setCurrent_truck(c_truck.map_trucks.get(updateCombo.getSelectedIndex()));

                JLabel nameLabel = new JLabel();
                nameLabel.setText("Name : ");
                nameLabel.setBounds(10,120,100,30);
                truckTextPane.add(nameLabel);

                name = new JTextField();
                name.setText(c_truck.getCurrentTruck().getTruck_name());
                name.setBounds(10,150,300,30);
                name.setBackground(new Color(255,255,255));
                name.setEditable(true);
                truckTextPane.add(name);

                JLabel matriculeLabel = new JLabel();
                matriculeLabel.setText("Matricule : ");
                matriculeLabel.setBounds(10,200,100,30);
                truckTextPane.add(matriculeLabel);

                matricule = new JTextField();
                matricule.setText(c_truck.getCurrentTruck().getTruck_matricule());
                matricule.setBounds(10,230,300,30);
                matricule.setBackground(new Color(255,255,255));
                matricule.setEditable(true);
                truckTextPane.add(matricule);

                JLabel yearLabel = new JLabel();
                yearLabel.setText("Year : ");
                yearLabel.setBounds(10,280,100,30);
                truckTextPane.add(yearLabel);

                year = new JTextField();
                year.setText(String.valueOf(c_truck.getCurrentTruck().getTruck_year()));
                year.setBounds(10,310,300,30);
                year.setBackground(new Color(255,255,255));
                year.setEditable(true);
                truckTextPane.add(year);

                JLabel brandLabel = new JLabel();
                brandLabel.setText("Brand : ");
                brandLabel.setBounds(10,360,100,30);
                truckTextPane.add(brandLabel);

                brand = new JTextField();
                brand.setText(c_truck.getCurrentTruck().getTruck_brand());
                brand.setBounds(10,390,300,30);
                brand.setBackground(new Color(255,255,255));
                brand.setEditable(true);
                truckTextPane.add(brand);

                updateButton.setBounds(100,470,100,30);
                truckTextPane.add(updateButton);

                truckTextPane.repaint();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || !name.getText().matches("[a-zA-Z]+")){
                    name.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (matricule.getText().isEmpty() || !matricule.getText().matches("[A-Z0-9]+")) {
                    name.setBorder(UIManager.getBorder("TextField.border"));
                    matricule.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (year.getText().isEmpty() || !year.getText().matches("[0-9]+")) {
                    matricule.setBorder(UIManager.getBorder("TextField.border"));
                    year.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (brand.getText().isEmpty() || !brand.getText().matches("[a-zA-Z]+")) {
                    year.setBorder(UIManager.getBorder("TextField.border"));
                    brand.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    brand.setBorder(UIManager.getBorder("TextField.border"));

                    c_truck.getCurrentTruck().setTruck_name(name.getText());
                    c_truck.getCurrentTruck().setTruck_matricule(matricule.getText());
                    c_truck.getCurrentTruck().setTruck_year(parseInt(year.getText()));
                    c_truck.getCurrentTruck().setTruck_brand(brand.getText());

                    //c_truck.setCurrent_truck(c_truck.list_trucks.get(c_truck.list_trucks.size()-1));

                    truckTextPane.removeAll();

                    truckTextPane.setText(c_truck.getCurrentTruck().toString());


                    if(c_truck.getTruckCurrentIndex() == 0){
                        messagePane.setText(c_truck.goPreviousTruckError());
                    } else if (c_truck.getTruckCurrentIndex() == c_truck.Truck_length()-1) {
                        messagePane.setText(c_truck.goNextTruckError());
                    }

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);
                }
            }
        });

        deleteTruckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(true);
                messagePane.setVisible(true);
                truckTextPane.removeAll();
                truckTextPane.repaint();

                try {
                    c_truck.Truck_Delete();
                } catch (Exception b) {
                   return;
                }

                if(c_truck.map_trucks.size() != 0){
                    truckTextPane.setText(c_truck.getCurrentTruck().toString());
                }else{
                    truckTextPane.setText("There are no Trucks, please click New Truck to create a Truck");
                }
            }
        });

    }

    public JPanel getTruckPanel() {
        return truckPanel;
    }

}
