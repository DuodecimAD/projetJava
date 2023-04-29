package View;

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
    private JTextPane testTextPane;
    private JButton backMainMenuButton;

    public View_Driver(View_Main vm) {
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
    }

    public JPanel getDriverPanel() {
        return driverPanel;
    }
}
