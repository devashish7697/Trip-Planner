package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {
    
    JProgressBar bar;
    Thread t;
    String username;
    
    Loading(String username) {
        
        this.username = username;
        t = new Thread(this);
        
        setBounds(550, 280, 800, 350);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel wtext = new JLabel("Welcome To TripPlanner ! ");
        wtext.setFont(new Font("Tahoma", Font.ITALIC, 33));
        wtext.setBounds(190, 28, 900, 60);
        wtext.setForeground(Color.DARK_GRAY);
        add(wtext);
        
        bar = new JProgressBar();
        bar.setBounds(150, 140, 500, 25);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel lblloading = new JLabel("Wait a moment, we are setting-up ! ");
        lblloading.setFont(new Font("Raleway", Font.ITALIC, 17));
        lblloading.setBounds(250, 180, 400, 30);
        lblloading.setForeground(Color.blue);
        add(lblloading);
        
        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        lblusername.setBounds(20, 310, 400, 20);
        lblusername.setForeground(Color.RED);
        add(lblusername);
        
        t.start();
        
        setVisible(true);
    }
    
    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if (value < max) {
                    bar.setValue( bar.getValue() + 1 );
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                
                Thread.sleep(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Loading("");
    }
}
