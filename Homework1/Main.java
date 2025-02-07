package Homework1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {
    JPanel jPanel = new JPanel();
    JButton jButton = new JButton("Please click");
    JLabel text = new JLabel("Welcome");
    int count = 0;

    public Main() {
        super("Howdy, Welcome to the Game!");
        super.setSize(400, 250);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Show a message dialog on startup
        JOptionPane.showMessageDialog(this, "Welcome to the Dungeon Crawler!");

        jPanel.add(jButton);
        jPanel.add(text);

        //this does the functionality of the button as shown in class where u increment by clicking
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                System.out.println("CLICK");
                text.setText("Count = " + count);
            }
        });

        this.add(jPanel);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
