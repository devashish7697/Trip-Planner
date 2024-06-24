package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    
  JLabel labelusername, labelpackage, labelpersons, labelid, labelnumber, labelprice, labelphone ;
  JButton back;
    
    ViewPackage(String username) {
        setBounds(600, 250, 1000, 600);
        setLayout(null);

        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("View Package Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 28));
        text.setBounds(100, 50, 350, 30);
        text.setForeground(Color.BLACK);
        add(text);

        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(100, 130, 150, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelusername.setBounds(280, 130, 150, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package :");
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpackage.setBounds(100, 180, 130, 25);
        lblpackage.setForeground(Color.black);
        add(lblpackage);
        
        labelpackage = new JLabel();
        labelpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelpackage.setBounds(280, 180, 150, 25);
        labelpackage.setForeground(Color.black);
        add(labelpackage);
        
        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpersons.setBounds(100, 230, 130, 25);
        lblpersons.setForeground(Color.black);
        add(lblpersons);
        
        labelpersons = new JLabel();
        labelpersons.setFont(new Font("Tahoma", Font.BOLD , 15));
        labelpersons.setBounds(280, 230, 150, 25);
        labelpersons.setForeground(Color.black);
        add(labelpersons);
        
        JLabel lblid = new JLabel("ID  :");
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblid.setBounds(100, 280, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelid.setBounds(280, 280, 190, 25);
        labelid.setForeground(Color.black);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnumber.setBounds(100, 330, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelnumber.setBounds(280, 330, 150, 25);
        labelnumber.setForeground(Color.black);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setBounds(100, 380, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelphone.setBounds(280, 380, 150, 25);
        labelphone.setForeground(Color.black);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Price  :");
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblprice.setBounds(100, 430, 130, 25);
        lblprice.setForeground(Color.black);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelprice.setBounds(280, 430, 150, 25);
        labelprice.setForeground(Color.black);
        add(labelprice);
        
        
        back = new JButton("Back");
        back.setBounds(180, 510, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(530, 90, 400, 400);
        add(image);
        
        
         try {
            Con c = new Con();
            String query = " select * from bookedpackages where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));    
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
        new ViewPackage("");
    }

}

