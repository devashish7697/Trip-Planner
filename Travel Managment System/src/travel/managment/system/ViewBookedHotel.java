package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice, labelhotelname, labelpersons, labeldays, labelac, labelfood ;
    JButton back;
    
    ViewBookedHotel(String username){
        
    
        setBounds(600, 200, 1000, 700);
        setLayout(null);

        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Booked Hotel Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 28));
        text.setBounds(140, 50, 350, 30);
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(90, 130, 150, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelusername.setBounds(280, 130, 200, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);
        
        JLabel hotelname = new JLabel("Hotel name :");
        hotelname.setFont(new Font("Tahoma", Font.BOLD, 15));
        hotelname.setBounds(90, 180, 150, 25);
        hotelname.setForeground(Color.black);
        add(hotelname);
        
        labelhotelname = new JLabel();
        labelhotelname.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelhotelname.setBounds(280,180,150 ,25);
        labelhotelname.setForeground(Color.black);
        add(labelhotelname);
        
        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblpersons.setBounds(90, 230, 150, 25);
        lblpersons.setForeground(Color.black);
        add(lblpersons);
        
        labelpersons = new JLabel();
        labelpersons.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelpersons.setBounds(280,230,150,25);
        labelpersons.setForeground(Color.black);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days :");
        lbldays.setFont(new Font("Tahoma", Font.BOLD , 15));
        lbldays.setBounds(90, 280, 150, 25);
        lbldays.setForeground(Color.black);
        add(lbldays);
        
        labeldays = new JLabel();
        labeldays.setFont(new Font("Tahoma", Font.BOLD, 15));
        labeldays.setBounds(280,280,150,25);
        labeldays.setForeground(Color.black);
        add(labeldays);
        
        JLabel lblac = new JLabel("AC/Non-AC :");
        lblac.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblac.setBounds(90, 330, 150, 25);
        lblac.setForeground(Color.black);
        add(lblac);
        
        labelac = new JLabel();
        labelac.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelac.setBounds(280,330,150 ,25);
        labelac.setForeground(Color.black);
        add(labelac);
        
        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblfood.setBounds(90, 380, 150, 25);
        lblfood.setForeground(Color.black);
        add(lblfood);
        
        labelfood = new JLabel();
        labelfood.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelfood.setBounds(280,380,150 ,25);
        labelfood.setForeground(Color.black);
        add(labelfood);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblid.setBounds(90, 430, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelid.setBounds(280, 430, 150, 25);
        labelid.setForeground(Color.black);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnumber.setBounds(90, 480, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelnumber.setBounds(280, 480, 150, 25);
        labelnumber.setForeground(Color.black);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setBounds(90, 530, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelphone.setBounds(280, 530, 150, 25);
        labelphone.setForeground(Color.black);
        add(labelphone); 
        
        JLabel lblprice = new JLabel("Price :");
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblprice.setBounds(90, 580, 130, 25);
        lblprice.setForeground(Color.black);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelprice.setBounds(280, 580, 150, 25);
        labelprice.setForeground(Color.black);
        add(labelprice); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(530, 120, 400, 400);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(670, 580, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.addActionListener(this);
        add(back);
        
        try {
            Con c = new Con();
            String query = " select * from bookedhotel where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotelname.setText(rs.getString("name"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));   
                labelfood.setText(rs.getString("food")); 
                labelac.setText(rs.getString("ac")); 
                labeldays.setText(rs.getString("days")); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    
    }
    
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
    new ViewBookedHotel("__devashish45__");
    }
}
