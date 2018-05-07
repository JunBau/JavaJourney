package com.company;

import sun.font.TextLabel;

import java.awt.*;
import javax.swing.*;

// Testing creating a window on java.

public class SimpleWindowTest {

    public static void CreateWindowTest () {

        // Creating the windowed instance.

        JFrame Window = new JFrame("JunOS v999");
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel WindowLabel = new JLabel("This is a test!", SwingConstants.CENTER);
        WindowLabel.setPreferredSize(new Dimension(300, 300));
        Window.getContentPane().add(WindowLabel, BorderLayout.CENTER);

        // Displaying the parameters set above...
        Window.setLocationRelativeTo(null);
        Window.pack();
        Window.setVisible(true);

    }

    // Excited to experiment more with windows... Next project, BlackJack within a window with unit tests?


}
