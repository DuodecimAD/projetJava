package View;

import Controller.Controller_Driver;
import Model.Driver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Driver extends JPanel{
   // private JFrame frame;
  //  private View_Main mainView;

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

    public View_Driver(View_Main vm, Controller_Driver c_driver) {

        //this.frame = frame;
        //this.mainView = mainView;
        //JPanel driverPanel = new JPanel();
        vm.setContentPane(driverPanel);
        //frame.revalidate();

        backMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vm.setContentPane(vm.getMainPanel());
                //frame.pack();
                vm.revalidate(); // Refresh the frame to show the main panel
               // frame.repaint();
                //frame.setVisible(true);
            }
        });

        //TextPanel Drivers
        driverTextPane.setText(c_driver.getCurrentDriver().toString());

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_driver.goPreviousDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
                if(c_driver.getCurrentIndex() == 0){
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
                if(c_driver.getCurrentIndex() == c_driver.Driver_length()-1){
                    messagePane.setText(c_driver.goNextDriverError());
                }
            }
        });
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_driver.getFirstDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
            }
        });
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePane.setText("");
                c_driver.getLastDriver();
                driverTextPane.setText(c_driver.getCurrentDriver().toString());
            }
        });
        selectDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        newDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public JPanel getDriverPanel() {
        return driverPanel;
    }
}
