package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class CheckPackage extends JFrame {
    
    CheckPackage(){
    setBounds(550, 250,1000,600);
    
    String [] package1 = {"GOLD PACKAGE", "1.  6 Days and 7 Nights", "2.  Airpot Assistance", "3.  Half Day City Tour", "4.  Daily Buffet", "5.  2 Night Bonfire Camping", "6.  Welcome Drinks on Arrival", "7.  Full Fay 3 Island Cruise", "8.  Special English Speaking Guide", "Book Now", "Summer Special", "Rs. 32000/-", "package1.jpg" };
    String [] package2 = {"PLATINUM PACKAGE", "1.  5 Days 6 Nights", "2.  Toll Free", "3.  Entrance Free ticket", "4.  Meet & Greet at Airport", "5. Welcome Drinks on Arrival", "6.  Night Safari", "7.  Cruise with Dinner","8.  River Rafting", "Book Now", "Winter Special", "Rs. 24000/-", "package2.jpg"};
     String [] package3 = {"SILVER PACKAGE", "1.  6 Days and 5 Nights", "2.  Return Airfare", "3.  Free Clubing", "4.  Horse Riding & Other Games", "5. Hard Drinks", "6.  Daily Buffet", "7.  BBQ Dinner", "8.  1 day Night Camping", "Book Now", "Winter Special", "Rs. 16000/-", "package3.jpg"};
    
    JTabbedPane tab = new JTabbedPane();
    
    JPanel p = createPackage(package1);
    tab.addTab("package 1", null, p);
    
    JPanel p1 = createPackage(package2);
    tab.addTab("package 2", null, p1);
    
    JPanel p2 = createPackage(package3);
    tab.addTab("package 3", null, p2);
    
    add(tab);
    
    setVisible(true);
    }
    
    public JPanel createPackage(String [] pack){
    JPanel p = new JPanel();
    p.setLayout(null);
    p.setBackground(Color.WHITE);   
    
    JLabel l1 = new JLabel(pack[0]);
    l1.setFont(new Font("Tahoma", Font.BOLD, 30));
    l1.setBounds(90, 50, 300, 35);
    l1.setForeground(Color.RED);
    p.add(l1);
    
    JLabel l2 = new JLabel(pack[1]);
    l2.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l2.setBounds(90, 120, 250, 25);
    l2.setForeground(Color.BLACK);
    p.add(l2);
    
    JLabel l3 = new JLabel(pack[2]);
    l3.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l3.setBounds(90, 150, 250, 25);
    l3.setForeground(Color.BLACK);
    p.add(l3);
    
    JLabel l4 = new JLabel(pack[3]);
    l4.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l4.setBounds(90, 180, 250, 25);
    l4.setForeground(Color.BLACK);
    p.add(l4);
    
    JLabel l5 = new JLabel(pack[4]);
    l5.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l5.setBounds(90, 210, 250, 25);
    l5.setForeground(Color.BLACK);
    p.add(l5);
    
    JLabel l6 = new JLabel(pack[5]);
    l6.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l6.setBounds(90, 240, 250, 25);
    l6.setForeground(Color.BLACK);
    p.add(l6);
    
    JLabel l7 = new JLabel(pack[6]);
    l7.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l7.setBounds(90, 270, 250, 25);
    l7.setForeground(Color.BLACK);
    p.add(l7);
    
    JLabel l8 = new JLabel(pack[7]);
    l8.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l8.setBounds(90, 300, 250, 25);
    l8.setForeground(Color.BLACK);
    p.add(l8);
    
    JLabel l9 = new JLabel(pack[8]);
    l9.setFont(new Font("Tahoma", Font.ITALIC, 16));
    l9.setBounds(90, 330, 250, 25);
    l9.setForeground(Color.BLACK);
    p.add(l9);
    
    JLabel l10 = new JLabel(pack[9]);
    l10.setFont(new Font("Tahoma", Font.ITALIC, 25));
    l10.setBounds(120, 390, 200, 25);
    l10.setForeground(Color.BLUE);
    p.add(l10);
    
    JLabel l11 = new JLabel(pack[10]);
    l11.setFont(new Font("Tahoma", Font.ITALIC, 18));
    l11.setBounds(120, 415, 200, 20);
    l11.setForeground(Color.RED);
    p.add(l11);
    
    JLabel l12 = new JLabel(pack[11]);
    l12.setFont(new Font("Tahoma", Font.ITALIC, 20));
    l12.setBounds(590, 405,200, 25);
    l12.setForeground(Color.RED);
    p.add(l12);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+ pack[12]));
    Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(420, 90, 500, 300);
    p.add(image);
    
    
    return p;
    }
    
    public static void main(String[] args){
    new CheckPackage();
    }
    
}
