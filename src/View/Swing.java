package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Swing extends JFrame {

        public Swing() {
            // Set the overall layout of the frame to BorderLayout
            setLayout(new BorderLayout());

            /*********/
            /**TITLE**/
            /*********/

            JPanel titlePanel = new JPanel();
            JLabel titleLabel = new JLabel("Driver Menu");
            titlePanel.add(titleLabel);
            titlePanel.setBackground(Color.green);
            add(titlePanel, BorderLayout.NORTH);

            //********
            //**MENU**
            //********

            JPanel menuPanel = new JPanel();
            menuPanel.setLayout(new GridLayout(5, 1, 0, 1)); // or any other layout that fits your menu items
            // add your menu items to the menu panel
            JButton menuButton1 = new JButton("Button1");
            JButton menuButton2 = new JButton("Button2");
            menuPanel.add(menuButton1);
            //menuPanel.add(Box.createRigidArea(new Dimension(5, 5)));
            menuPanel.add(menuButton2);
            add(menuPanel, BorderLayout.WEST);
            menuPanel.setBackground(Color.red);

            //**********
            //**CENTER**
            //**********

            JPanel infoPanel = new JPanel(new GridBagLayout());

            JPanel textPanel = new JPanel();
            JTextArea textArea = new JTextArea();
            textArea.setText("Hello World!Hello World!\nHello World!Hello World!Hello World!Hello World!Hello World!Hello World!Hello World!");
            textArea.setBackground(Color.pink);
            textPanel.add(textArea);
            textArea.setPreferredSize(new Dimension(400, 200));
            GridBagConstraints gbc3 = new GridBagConstraints();
            gbc3.gridx = 0;
            gbc3.gridy = 0;
            textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
            gbc3.anchor = GridBagConstraints.WEST;
            //gbc3.insets = new Insets(0, 0, 0, 250);
            gbc3.gridwidth = GridBagConstraints.REMAINDER;
            gbc3.gridheight = 6;
            gbc3.weightx = 1.0; // make the component stretch horizontally
            gbc3.weighty = 0.5;
            gbc3.fill = GridBagConstraints.BOTH;
            infoPanel.add(textArea, gbc3);
            infoPanel.setBackground(Color.cyan);
            //**********
            //**INPUT**
            //**********
            JPanel messagePanel = new JPanel();
            JTextArea message = new JTextArea();
            message.setText("Testing dsf sdf fds dsfdsfdsjfn dsjfjkldsflsfdk,dsfdgfdgdfgfdgfgfdgfdgfgfdgfdg fds fkl!");
            message.setLineWrap(true);
            message.setWrapStyleWord(true);
            message.setBackground(Color.magenta);
            messagePanel.add(message);

            //ontMetrics fm = message.getFontMetrics(message.getFont());
            //int width = fm.stringWidth("Testing dsf sdf fds dsfdsfdsjfn dsjfjkldsflsfdk,ds fds fdll!");
           //message.setPreferredSize(new Dimension(width, 20));

            message.setPreferredSize(new Dimension(650, 20));
            GridBagConstraints gbc4 = new GridBagConstraints();
            gbc4.gridx = 0;
            gbc4.gridy = 7;
            //gbc4.gridwidth = GridBagConstraints.REMAINDER;
           //gbc4.insets = new Insets(0, 0, 0, 250);
            gbc4.gridheight = 1;
            gbc4.weightx = 1.0; // make the component stretch horizontally
            gbc4.weighty = 0.0;
            gbc4.fill = GridBagConstraints.BOTH;
            infoPanel.add(message, gbc4);



            JPanel inputPanel = new JPanel();
            JTextField inputField = new JTextField();
            inputField.setPreferredSize(new Dimension(600, 25));
            inputPanel.add(inputField);
            JButton submitButton = new JButton("Submit");
            inputPanel.add(submitButton);
            GridBagConstraints gbc1 = new GridBagConstraints();
            gbc1.gridx = 0;
            gbc1.gridy = 8;
            //gbc1.gridwidth = GridBagConstraints.REMAINDER;
            gbc1.gridheight = 2;
            gbc1.weightx = 1.0;
            gbc1.weighty = 0.2;
            //gbc1.fill = GridBagConstraints.BOTH;
            inputPanel.setBackground(Color.orange);
            infoPanel.add(inputPanel, gbc1);




            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userInput = inputField.getText(); // Get the user input from the JTextField
                    // Use a Scanner to process the user input
                    Scanner scanner = new Scanner(userInput);
                    while (scanner.hasNext()) {
                        String token = scanner.next();
                        // Process each token here
                    }
                    scanner.close();
                }
            });


            // Create the navigation panel and add it to the bottom region
            JPanel navPanel = new JPanel();
            JButton prevButton = new JButton("<< Previous Driver");
            JButton nextButton = new JButton("Next Driver >>");
            navPanel.add(Box.createHorizontalGlue()); // to center the buttons horizontally
            navPanel.add(prevButton);
            navPanel.add(Box.createRigidArea(new Dimension(5, 5))); // to add some space between the buttons
            navPanel.add(nextButton);
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridx = 0;
            gbc2.gridy = 10;
            //gbc2.gridwidth = GridBagConstraints.REMAINDER;
            gbc2.gridheight = 1;
            gbc2.weightx = 1.0;
            gbc2.weighty = 0.0;
            gbc2.fill = GridBagConstraints.BOTH;
            navPanel.setBackground(Color.yellow);
            infoPanel.add(navPanel, gbc2);

            add(infoPanel);

            //********
            //**FULL**
            //********

            setSize(800, 450);
            setTitle("Projet Java Antony");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }

    // Method to build the menu bar
    private JMenuBar buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu menu = new JMenu("File");

        // Create menu items
        JMenuItem menuItemNew = new JMenuItem("New");
        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSave = new JMenuItem("Save");
        JMenuItem menuItemExit = new JMenuItem("Exit");

        // Add menu items to menu
        menu.add(menuItemNew);
        menu.add(menuItemOpen);
        menu.add(menuItemSave);
        menu.addSeparator(); // Add separator line between Save and Exit menu items
        menu.add(menuItemExit);

        // Add menu to menu bar
        menuBar.add(menu);

        return menuBar;
    }


}
