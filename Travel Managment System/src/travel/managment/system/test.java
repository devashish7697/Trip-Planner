package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class test extends JFrame {
    public test() {
        setTitle("Open Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JButton openCalculatorButton = new JButton("Open Calculator");
        openCalculatorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCalculator();
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(openCalculatorButton);
        add(panel, BorderLayout.CENTER);
        
        setSize(300, 200);
        setVisible(true);
    }
    
    private void openCalculator() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(new File("/home/devashishsharma/gnome-calculator"));
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: Could not open calculator.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: Desktop not supported.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new test();
            }
        });
    }
}




