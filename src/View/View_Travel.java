package View;


import Controller.Controller_Travel;
import Model.Travel;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class View_Travel extends JPanel {
    private JPanel travelPanel;
    private JPanel menuPanel;
    private JButton newTravelButton;
    private JButton updateTravelButton;
    private JButton deleteTravelButton;
    private JButton selectTravelButton;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JButton firstButton;
    private JButton lastButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextPane travelTextPane;
    private JButton backMainMenuButton;
    private JTextPane messagePane;
    private JPanel contentPanel;
    private final JComboBox<Travel> selectCombo = new JComboBox<>();
    private final JComboBox<Travel> updateCombo = new JComboBox<>();
    private JTextField truckFK;
    private JTextField driverFK;
    private JTextField travelKM;
    private JTextField travelDAY;
    private final JButton createButton = new JButton("Create");
    private final JButton updateButton = new JButton("Update");

    public View_Travel(View_Main vm, Controller_Travel c_travel) {

        vm.setContentPane(travelPanel);

        if(c_travel.Travel_length() != 0) {
            //TextPanel Travels
            travelTextPane.setText(c_travel.getCurrentTravel().toString());
        } else {
            travelTextPane.setText("There are no Travels, please click New Travel to create a Travel");
        }

        travelTextPane.setBorder(BorderFactory.createLoweredBevelBorder());

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
                c_travel.goPreviousTravel();
                travelTextPane.setText(c_travel.getCurrentTravel().toString());
                if(c_travel.getTravelCurrentIndex() == 0){
                    messagePane.setText(c_travel.goPreviousTravelError());
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_travel.goNextTravel();
                travelTextPane.setText(c_travel.getCurrentTravel().toString());
                if(c_travel.getTravelCurrentIndex() == c_travel.Travel_length()-1){
                    messagePane.setText(c_travel.goNextTravelError());
                }
            }
        });

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_travel.goPreviousTravelError());
                c_travel.getFirstTravel();
                travelTextPane.setText(c_travel.getCurrentTravel().toString());
            }
        });

        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText(c_travel.goNextTravelError());
                c_travel.getLastTravel();
                travelTextPane.setText(c_travel.getCurrentTravel().toString());
            }
        });

        selectTravelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(false);
                messagePane.setVisible(false);
                travelTextPane.removeAll();
                travelTextPane.repaint();

                //contentPanel.remove(travelTextPane);
                selectCombo.setModel(new DefaultComboBoxModel<>(c_travel.map_travels.values().toArray(new Travel[0])));
                //selectCombo = new JComboBox();
        /*for (int i = 0; i < c_travel.Travel_length(); i++) {
            selectCombo.addItem(c_travel.list_travels.get(i));
        }*/
                //selectCombo.setPreferredSize(new Dimension(200, 30));
                selectCombo.setBounds(50,50,1000,50);
                travelTextPane.setText("Select the Travel :");
                travelTextPane.add(selectCombo);

            }
        });

        selectCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_travel.setCurrent_travel(c_travel.map_travels.get(selectCombo.getSelectedIndex()));

                if(selectCombo.getSelectedIndex() == 0){
                    messagePane.setText(c_travel.goPreviousTravelError());
                } else if (selectCombo.getSelectedIndex() == c_travel.Travel_length()-1) {
                    messagePane.setText(c_travel.goNextTravelError());
                }

                travelTextPane.setText(c_travel.getCurrentTravel().toString());
                travelTextPane.remove(selectCombo);

                navPanel.setVisible(true);
                messagePane.setVisible(true);

            }
        });

        newTravelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                travelTextPane.removeAll();
                travelTextPane.repaint();

                travelTextPane.setText("Create the New Travel");

                JLabel truckFKLabel = new JLabel();
                truckFKLabel.setText("Truck : ");
                truckFKLabel.setBounds(10,70,100,30);
                travelTextPane.add(truckFKLabel);

                truckFK = new JTextField();
                truckFK.setBounds(10,100,300,30);
                truckFK.setBackground(new Color(255,255,255));
                truckFK.setEditable(true);
                travelTextPane.add(truckFK);

                JLabel driverFKLabel = new JLabel();
                driverFKLabel.setText("Driver : ");
                driverFKLabel.setBounds(10,150,100,30);
                travelTextPane.add(driverFKLabel);

                driverFK = new JTextField();
                driverFK.setBounds(10,180,300,30);
                driverFK.setBackground(new Color(255,255,255));
                driverFK.setEditable(true);
                travelTextPane.add(driverFK);

                JLabel travelKMLabel = new JLabel();
                travelKMLabel.setText("KM : ");
                travelKMLabel.setBounds(10,230,100,30);
                travelTextPane.add(travelKMLabel);

                travelKM = new JTextField();
                travelKM.setBounds(10,260,300,30);
                travelKM.setBackground(new Color(255,255,255));
                travelKM.setEditable(true);
                travelTextPane.add(travelKM);

                JLabel travelDAYLabel = new JLabel();
                travelDAYLabel.setText("Day : ");
                travelDAYLabel.setBounds(10,310,100,30);
                travelTextPane.add(travelDAYLabel);

                travelDAY = new JTextField();
                travelDAY.setBounds(10,340,300,30);
                travelDAY.setBackground(new Color(255,255,255));
                travelDAY.setEditable(true);
                travelTextPane.add(travelDAY);


                createButton.setBounds(100,420,100,30);
                //create.setBackground(new Color(255,255,255));
                travelTextPane.add(createButton);

            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (truckFK.getText().isEmpty() || !truckFK.getText().matches("[0-9]+")){
                    truckFK.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (driverFK.getText().isEmpty() || !driverFK.getText().matches("[0-9]+")) {
                    truckFK.setBorder(UIManager.getBorder("TextField.border"));
                    driverFK.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (travelKM.getText().isEmpty() || !travelKM.getText().matches("[0-9]+")) {
                    driverFK.setBorder(UIManager.getBorder("TextField.border"));
                    travelKM.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (travelDAY.getText().isEmpty() || !travelDAY.getText().matches("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")) {
                    travelKM.setBorder(UIManager.getBorder("TextField.border"));
                    travelDAY.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    travelDAY.setBorder(UIManager.getBorder("TextField.border"));
                    c_travel.map_travels.put(c_travel.map_travels.size(), new Travel(c_travel.map_travels.size(), parseInt(truckFK.getText()), parseInt(driverFK.getText()), parseInt(travelKM.getText()), travelDAY.getText()));
                    c_travel.setCurrent_travel(c_travel.map_travels.get(c_travel.map_travels.size()-1));

                    travelTextPane.removeAll();

                    travelTextPane.setText(c_travel.getCurrentTravel().toString());
                    messagePane.setText(c_travel.goNextTravelError());

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);

                    //System.out.println(c_travel.list_travels);
                }
            }
        });

        updateTravelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navPanel.setVisible(false);
                messagePane.setVisible(false);
                travelTextPane.removeAll();
                travelTextPane.repaint();
                updateCombo.setModel(new DefaultComboBoxModel<>(c_travel.map_travels.values().toArray(new Travel[0])));
                //selectCombo = new JComboBox();
        /*for (int i = 0; i < c_travel.Travel_length(); i++) {
            selectCombo.addItem(c_travel.list_travels.get(i));
        }*/
                //selectCombo.setPreferredSize(new Dimension(200, 30));
                updateCombo.setBounds(50,50,1000,50);
                travelTextPane.setText("Select the Travel you want to Update :");
                travelTextPane.add(updateCombo);

            }
        });

        updateCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                c_travel.setCurrent_travel(c_travel.map_travels.get(updateCombo.getSelectedIndex()));

                JLabel truckFKLabel = new JLabel();
                truckFKLabel.setText("First Name : ");
                truckFKLabel.setBounds(10,120,100,30);
                travelTextPane.add(truckFKLabel);

                truckFK = new JTextField();
                truckFK.setText(String.valueOf(c_travel.getCurrentTravel().getTruck_fk()));
                truckFK.setBounds(10,150,300,30);
                truckFK.setBackground(new Color(255,255,255));
                truckFK.setEditable(true);
                travelTextPane.add(truckFK);

                JLabel driverFKLabel = new JLabel();
                driverFKLabel.setText("Last Name : ");
                driverFKLabel.setBounds(10,200,100,30);
                travelTextPane.add(driverFKLabel);

                driverFK = new JTextField();
                driverFK.setText(String.valueOf(c_travel.getCurrentTravel().getDriver_fk()));
                driverFK.setBounds(10,230,300,30);
                driverFK.setBackground(new Color(255,255,255));
                driverFK.setEditable(true);
                travelTextPane.add(driverFK);

                JLabel travelKMLabel = new JLabel();
                travelKMLabel.setText("Age : ");
                travelKMLabel.setBounds(10,280,100,30);
                travelTextPane.add(travelKMLabel);

                travelKM = new JTextField();
                travelKM.setText(String.valueOf(c_travel.getCurrentTravel().getTravel_km()));
                travelKM.setBounds(10,310,300,30);
                travelKM.setBackground(new Color(255,255,255));
                travelKM.setEditable(true);
                travelTextPane.add(travelKM);

                JLabel travelDAYLabel = new JLabel();
                travelDAYLabel.setText("Address : ");
                travelDAYLabel.setBounds(10,360,100,30);
                travelTextPane.add(travelDAYLabel);

                travelDAY = new JTextField();
                travelDAY.setText(c_travel.getCurrentTravel().getTravel_day());
                travelDAY.setBounds(10,390,300,30);
                travelDAY.setBackground(new Color(255,255,255));
                travelDAY.setEditable(true);
                travelTextPane.add(travelDAY);

                updateButton.setBounds(100,470,100,30);
                travelTextPane.add(updateButton);

                travelTextPane.repaint();

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (truckFK.getText().isEmpty() || !truckFK.getText().matches("[0-9]+")){
                    truckFK.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (driverFK.getText().isEmpty() || !driverFK.getText().matches("[0-9]+")) {
                    truckFK.setBorder(UIManager.getBorder("TextField.border"));
                    driverFK.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (travelKM.getText().isEmpty() || !travelKM.getText().matches("[0-9]+")) {
                    driverFK.setBorder(UIManager.getBorder("TextField.border"));
                    travelKM.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else if (travelDAY.getText().isEmpty() || !travelDAY.getText().matches("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$")) {
                    travelKM.setBorder(UIManager.getBorder("TextField.border"));
                    travelDAY.setBorder(BorderFactory.createLineBorder(Color.RED));
                } else {
                    travelDAY.setBorder(UIManager.getBorder("TextField.border"));

                    c_travel.getCurrentTravel().setTruck_fk(parseInt(truckFK.getText()));
                    c_travel.getCurrentTravel().setDriver_fk(parseInt(driverFK.getText()));
                    c_travel.getCurrentTravel().setTravel_km(parseInt(travelKM.getText()));
                    c_travel.getCurrentTravel().setTravel_day(travelDAY.getText());

                    //c_travel.setCurrent_travel(c_travel.list_travels.get(c_travel.list_travels.size()-1));

                    travelTextPane.removeAll();

                    travelTextPane.setText(c_travel.getCurrentTravel().toString());


                    if(c_travel.getTravelCurrentIndex() == 0){
                        messagePane.setText(c_travel.goPreviousTravelError());
                    } else if (c_travel.getTravelCurrentIndex() == c_travel.Travel_length()-1) {
                        messagePane.setText(c_travel.goNextTravelError());
                    }

                    navPanel.setVisible(true);
                    messagePane.setVisible(true);
                }
            }
        });

        deleteTravelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                navPanel.setVisible(true);
                messagePane.setVisible(true);
                travelTextPane.removeAll();
                travelTextPane.repaint();

                try {
                    c_travel.Travel_Delete();
                } catch (Exception b) {
                    return;
                }

                if(c_travel.map_travels.size() != 0){
                    travelTextPane.setText(c_travel.getCurrentTravel().toString());
                }else{
                    travelTextPane.setText("There are no Trucks, please click New Truck to create a Truck");
                }
            }
        });
    }

    public JPanel getTravelPanel() {
        return travelPanel;
    }
}
