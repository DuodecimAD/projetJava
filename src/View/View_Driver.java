package View;

import Controller.Controller_Driver;
import Model.Driver;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class View_Driver extends JPanel{
    private JPanel driverPanel;
    private JPanel menuPanel;
    private JButton newDriverButton;
    private JButton updateDriverButton;
    private JButton deleteDriverButton;
    private JButton selectDriverButton;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JButton firstButton;
    private JButton lastButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextPane driverTextPane;
    private JButton backMainMenuButton;
    private JTextPane messagePane;
    private JPanel contentPanel;
    private final JComboBox<Driver> selectCombo = new JComboBox<>();
    private final JComboBox<Driver> updateCombo = new JComboBox<>();
    private JTextField firstName;
    private JTextField lastName;
    private JTextField age;
    private JTextField address;
    private final JButton createButton = new JButton("Create");
    private final JButton updateButton = new JButton("Update");

    public View_Driver(View_Main vm, Controller_Driver c_driver) {

        vm.setContentPane(driverPanel);


        if(c_driver.Driver_length() != 0) {
            //TextPanel Drivers
            driverTextPane.setText(c_driver.getCurrentDriver().toString());
        }else{
            driverTextPane.setText("There are no Drivers, please click New Driver to create a Driver");
        }

        driverTextPane.setBorder(BorderFactory.createLoweredBevelBorder());

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
                c_driver.goPreviousDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
                if(c_driver.getDriverCurrentIndex() == 0){
                    messagePane.setText(c_driver.goPreviousDriverError());
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_driver.goNextDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
                if(c_driver.getDriverCurrentIndex() == c_driver.getLastDriverIndex()){
                    messagePane.setText(c_driver.goNextDriverError());
                }
            }
        });

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_driver.goPreviousDriverError());
                c_driver.getFirstDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
            }
        });

        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_driver.goNextDriverError());
                c_driver.getLastDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
            }
        });

        selectDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(false);
                messagePane.setVisible(false);
                driverTextPane.removeAll();
                driverTextPane.repaint();

                //contentPanel.remove(driverTextPane);
                selectCombo.setModel(new DefaultComboBoxModel<>(c_driver.map_drivers.values().toArray(new Driver[0])));
                //selectCombo = new JComboBox();
                /*for (int i = 0; i < c_driver.Driver_length(); i++) {
                    selectCombo.addItem(c_driver.list_drivers.get(i));
                }*/
                //selectCombo.setPreferredSize(new Dimension(200, 30));
                selectCombo.setBounds(50,50,1000,50);
                driverTextPane.setText("Select the Driver :");
                driverTextPane.add(selectCombo);

            }
        });

        selectCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_driver.setCurrent_driver(c_driver.map_drivers.get(selectCombo.getSelectedIndex()));

                if(selectCombo.getSelectedIndex() == 0){
                    messagePane.setText(c_driver.goPreviousDriverError());
                } else if (selectCombo.getSelectedIndex() == c_driver.Driver_length()-1) {
                    messagePane.setText(c_driver.goNextDriverError());
                }

                driverTextPane.setText(c_driver.getCurrentDriver().toString());
                driverTextPane.remove(selectCombo);

                navPanel.setVisible(true);
                messagePane.setVisible(true);

            }
        });

        newDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                driverTextPane.removeAll();
                driverTextPane.repaint();

                driverTextPane.setText("Create the New Driver");

                JLabel firstNameLabel = new JLabel();
                firstNameLabel.setText("First Name : ");
                firstNameLabel.setBounds(10,70,100,30);
                driverTextPane.add(firstNameLabel);

                firstName = new JTextField();
                firstName.setBounds(10,100,300,30);
                firstName.setBackground(new Color(255,255,255));
                firstName.setEditable(true);
                driverTextPane.add(firstName);

                JLabel lastNameLabel = new JLabel();
                lastNameLabel.setText("Last Name : ");
                lastNameLabel.setBounds(10,150,100,30);
                driverTextPane.add(lastNameLabel);

                lastName = new JTextField();
                lastName.setBounds(10,180,300,30);
                lastName.setBackground(new Color(255,255,255));
                lastName.setEditable(true);
                driverTextPane.add(lastName);

                JLabel ageLabel = new JLabel();
                ageLabel.setText("Age : ");
                ageLabel.setBounds(10,230,100,30);
                driverTextPane.add(ageLabel);

                age = new JTextField();
                age.setBounds(10,260,300,30);
                age.setBackground(new Color(255,255,255));
                age.setEditable(true);
                driverTextPane.add(age);

                JLabel addressLabel = new JLabel();
                addressLabel.setText("Address : ");
                addressLabel.setBounds(10,310,100,30);
                driverTextPane.add(addressLabel);

                address = new JTextField();
                address.setBounds(10,340,300,30);
                address.setBackground(new Color(255,255,255));
                address.setEditable(true);
                driverTextPane.add(address);


                createButton.setBounds(100,420,100,30);
                //create.setBackground(new Color(255,255,255));
                driverTextPane.add(createButton);

            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstName.getText().isEmpty() || !firstName.getText().matches("[a-zA-Z]+")){
                    firstName.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (lastName.getText().isEmpty() || !lastName.getText().matches("[a-zA-Z]+")) {
                    firstName.setBorder(UIManager.getBorder("TextField.border"));
                    lastName.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (age.getText().isEmpty() || !age.getText().matches("[0-9]+")) {
                    lastName.setBorder(UIManager.getBorder("TextField.border"));
                    age.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (address.getText().isEmpty() || !address.getText().matches("^[a-zA-Z0-9\\s.,']+$")) {
                    age.setBorder(UIManager.getBorder("TextField.border"));
                    address.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    address.setBorder(UIManager.getBorder("TextField.border"));
                    c_driver.map_drivers.put(c_driver.map_drivers.size(),new Driver(c_driver.map_drivers.size(), firstName.getText(), lastName.getText(), parseInt(age.getText()), address.getText()));
//                    c_driver.setCurrent_driver(c_driver.map_drivers.get(c_driver.map_drivers.size()-1));
                    c_driver.getLastDriver();

                    driverTextPane.removeAll();

                    driverTextPane.setText(c_driver.getCurrentDriver().toString());
                    messagePane.setText(c_driver.goNextDriverError());

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);

                    //System.out.println(c_driver.list_drivers);
                }
            }
        });

        updateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                driverTextPane.removeAll();
                driverTextPane.repaint();
                updateCombo.setModel(new DefaultComboBoxModel<>(c_driver.map_drivers.values().toArray(new Driver[0])));
                //selectCombo = new JComboBox();
                /*for (int i = 0; i < c_driver.Driver_length(); i++) {
                    selectCombo.addItem(c_driver.list_drivers.get(i));
                }*/
                //selectCombo.setPreferredSize(new Dimension(200, 30));
                updateCombo.setBounds(50,50,1000,50);
                driverTextPane.setText("Select the Driver you want to Update :");
                driverTextPane.add(updateCombo);

            }
        });

        updateCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_driver.setCurrent_driver(c_driver.map_drivers.get(updateCombo.getSelectedIndex()));

                JLabel firstNameLabel = new JLabel();
                firstNameLabel.setText("First Name : ");
                firstNameLabel.setBounds(10,120,100,30);
                driverTextPane.add(firstNameLabel);

                firstName = new JTextField();
                firstName.setText(c_driver.getCurrentDriver().getDriver_first_name());
                firstName.setBounds(10,150,300,30);
                firstName.setBackground(new Color(255,255,255));
                firstName.setEditable(true);
                driverTextPane.add(firstName);

                JLabel lastNameLabel = new JLabel();
                lastNameLabel.setText("Last Name : ");
                lastNameLabel.setBounds(10,200,100,30);
                driverTextPane.add(lastNameLabel);

                lastName = new JTextField();
                lastName.setText(c_driver.getCurrentDriver().getDriver_last_name());
                lastName.setBounds(10,230,300,30);
                lastName.setBackground(new Color(255,255,255));
                lastName.setEditable(true);
                driverTextPane.add(lastName);

                JLabel ageLabel = new JLabel();
                ageLabel.setText("Age : ");
                ageLabel.setBounds(10,280,100,30);
                driverTextPane.add(ageLabel);

                age = new JTextField();
                age.setText(String.valueOf(c_driver.getCurrentDriver().getDriver_age()));
                age.setBounds(10,310,300,30);
                age.setBackground(new Color(255,255,255));
                age.setEditable(true);
                driverTextPane.add(age);

                JLabel addressLabel = new JLabel();
                addressLabel.setText("Address : ");
                addressLabel.setBounds(10,360,100,30);
                driverTextPane.add(addressLabel);

                address = new JTextField();
                address.setText(c_driver.getCurrentDriver().getDriver_address());
                address.setBounds(10,390,300,30);
                address.setBackground(new Color(255,255,255));
                address.setEditable(true);
                driverTextPane.add(address);

                updateButton.setBounds(100,470,100,30);
                driverTextPane.add(updateButton);

                driverTextPane.repaint();

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstName.getText().isEmpty() || !firstName.getText().matches("[a-zA-Z]+")){
                    firstName.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (lastName.getText().isEmpty() || !lastName.getText().matches("[a-zA-Z]+")) {
                    firstName.setBorder(UIManager.getBorder("TextField.border"));
                    lastName.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (age.getText().isEmpty() || !age.getText().matches("[0-9]+")) {
                    lastName.setBorder(UIManager.getBorder("TextField.border"));
                    age.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (address.getText().isEmpty() || !address.getText().matches("^[a-zA-Z0-9\\s.,']+$")) {
                    age.setBorder(UIManager.getBorder("TextField.border"));
                    address.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    address.setBorder(UIManager.getBorder("TextField.border"));

                    c_driver.getCurrentDriver().setDriver_first_name(firstName.getText());
                    c_driver.getCurrentDriver().setDriver_last_name(lastName.getText());
                    c_driver.getCurrentDriver().setDriver_age(parseInt(age.getText()));
                    c_driver.getCurrentDriver().setDriver_address(address.getText());

                    //c_driver.setCurrent_driver(c_driver.list_drivers.get(c_driver.list_drivers.size()-1));

                    driverTextPane.removeAll();

                    driverTextPane.setText(c_driver.getCurrentDriver().toString());


                    if(c_driver.getDriverCurrentIndex() == 0){
                        messagePane.setText(c_driver.goPreviousDriverError());
                    } else if (c_driver.getDriverCurrentIndex() == c_driver.Driver_length()-1) {
                        messagePane.setText(c_driver.goNextDriverError());
                    }

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);
                }
            }
        });

        deleteDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(true);
                messagePane.setVisible(true);
                driverTextPane.removeAll();
                driverTextPane.repaint();

                try {
                    c_driver.Driver_Delete();
                }catch (Exception g){
                    return;
                }

                if(c_driver.map_drivers.size() != 0){
                    driverTextPane.setText(c_driver.getCurrentDriver().toString());
                }else{
                    driverTextPane.setText("There are no Drivers, please click New Driver to create a Driver");
                }

            }
        });

    }

    public JPanel getDriverPanel() {
        return driverPanel;
    }
}
