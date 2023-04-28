package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Driver extends JPanel{
    private JFrame frame;
    private View_Main mainView;
    private JPanel driverPanel;
    private JPanel menuPanel;
    private JButton newDriverButton;
    private JButton updateDriverButton;
    private JButton deleteDriverButton;
    private JButton statsButton;
    private JPanel titlePanel;
    private JPanel navPanel;
    private JButton firstButton;
    private JButton lastButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextPane testTextPane;
    private JButton backMainMenuButton;

    public View_Driver(JFrame frame, View_Main mainView) {
        this.frame = frame;
        this.mainView = mainView;

        driverPanel = new JPanel();
        frame.setContentPane(driverPanel);
        frame.revalidate();

        backMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new instance of View_Main

                // Set the content pane of mainView
                frame.setContentPane(mainView.getMainPanel());
                // Pack and display the mainView
                frame.pack();
                frame.revalidate(); // Refresh the frame to show the main panel
                frame.repaint();
                frame.setVisible(true);

            }
        });


    }





    public JPanel getDriverPanel() {
        return driverPanel;
    }
}
