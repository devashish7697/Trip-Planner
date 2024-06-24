package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener {

  JLabel labelusername, labelid, labelnumber, labelname, labelgender, labelcountry, labeladress, labelphone, labelemail ;
  JButton back;
    
    ViewCustomer(String username) {
        setBounds(600, 250, 1000, 600);
        setLayout(null);

        getContentPane().setBackground(Color.white);
        
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(100, 50, 150, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelusername.setBounds(280, 50, 150, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblid.setBounds(100, 110, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelid.setBounds(280, 110, 150, 25);
        labelid.setForeground(Color.black);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnumber.setBounds(100, 170, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.BOLD , 15));
        labelnumber.setBounds(280, 170, 150, 25);
        labelnumber.setForeground(Color.black);
        add(labelnumber);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setBounds(100, 230, 130, 25);
        lblname.setForeground(Color.black);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelname.setBounds(280, 230, 190, 25);
        labelname.setForeground(Color.black);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblgender.setBounds(100, 290, 130, 25);
        lblgender.setForeground(Color.black);
        add(lblgender);
        
        labelgender = new JLabel("Male");
        labelgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelgender.setBounds(280, 290, 150, 25);
        labelgender.setForeground(Color.black);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblcountry.setBounds(560, 50, 130, 25);
        lblcountry.setForeground(Color.black);
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelcountry.setBounds(730, 50, 150, 25);
        labelcountry.setForeground(Color.black);
        add(labelcountry);
        
        JLabel lbladress = new JLabel("Adress   :");
        lbladress.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbladress.setBounds(560, 110, 130, 25);
        lbladress.setForeground(Color.black);
        add(lbladress);
        
        labeladress = new JLabel();
        labeladress.setFont(new Font("Tahoma", Font.BOLD, 15));
        labeladress.setBounds(730, 110, 150, 25);
        labeladress.setForeground(Color.black);
        add(labeladress);
        
        JLabel lblphone = new JLabel("Phone    :");
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setBounds(560, 170, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelphone.setBounds(730, 170, 150, 25);
        labelphone.setForeground(Color.black);
        add(labelphone);
        
        JLabel lblemail = new JLabel("Email     :");
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblemail.setBounds(560, 230, 130, 25);
        lblemail.setForeground(Color.black);
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelemail.setBounds(730, 230, 200, 25);
        labelemail.setForeground(Color.black);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBounds(560, 290, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(140, 390, 700, 220);
        add(image);
        
        
         try {
            Con c = new Con();
            String query = " select * from customer where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladress.setText(rs.getString("adress"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
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

    public static void main(String[] args) {
        new ViewCustomer("");
    }

}
