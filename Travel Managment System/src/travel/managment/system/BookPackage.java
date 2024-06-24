package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername, labelid ,labelnumber, labelphone, labelprice;
    String username;
    JButton checkprice, bookpackage, back; 
    
    BookPackage(String username){
        
        this.username = username;
        
        setBounds(600, 250, 1000, 600);
        setLayout(null);

        getContentPane().setBackground(Color.white);
    
        JLabel text = new JLabel("Book Package");
        text.setFont(new Font("Tahoma", Font.BOLD, 28));
        text.setBounds(120, 50, 250, 30);
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblusername.setBounds(90, 130, 150, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);
        
        labelusername = new JLabel("__devashish45__");
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelusername.setBounds(280, 130, 200, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);
        
        JLabel Selectpackage = new JLabel("Select Package :");
        Selectpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        Selectpackage.setBounds(90, 180, 150, 25);
        Selectpackage.setForeground(Color.black);
        add(Selectpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Platinum Package");
        cpackage.add("Silver Package ");
        cpackage.setBounds(280,180,150 ,25);
        cpackage.setFont(new Font("Tahoma", Font.BOLD, 13));
        Selectpackage.setBackground(Color.white);
        add(cpackage);
        
        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblpersons.setBounds(90, 230, 150, 25);
        lblpersons.setForeground(Color.black);
        add(lblpersons);
        
        tfpersons = new JTextField();
        tfpersons.setBounds(280,230,150,25);
        add(tfpersons);
        
        JLabel lblid = new JLabel("ID :");
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblid.setBounds(90, 280, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelid.setBounds(280, 280, 150, 25);
        labelid.setForeground(Color.black);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnumber.setBounds(90, 330, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelnumber.setBounds(280, 330, 150, 25);
        labelnumber.setForeground(Color.black);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setBounds(90, 380, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelphone.setBounds(280, 380, 150, 25);
        labelphone.setForeground(Color.black);
        add(labelphone); 
        
        JLabel lblprice = new JLabel("Price :");
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblprice.setBounds(90, 430, 130, 25);
        lblprice.setForeground(Color.black);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelprice.setBounds(280, 430, 150, 25);
        labelprice.setForeground(Color.black);
        add(labelprice); 
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(110, 500, 120, 25);
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 13));
        checkprice.setBackground(new Color(255, 105, 110));
        checkprice.setForeground(new Color(250, 247, 247));
        checkprice.setBorder(new LineBorder(new Color(255, 105, 110)));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book");
        bookpackage.setBounds(260, 500, 120, 25);
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 13));
        bookpackage.setBackground(new Color(255, 105, 110));
        bookpackage.setForeground(new Color(250, 247, 247));
        bookpackage.setBorder(new LineBorder(new Color(255, 105, 110)));
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(650, 500, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(133, 193, 233));
        back.setForeground(new Color(250, 247, 247));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(510, 120, 400, 300);
        add(image);
        
            try {
            Con c = new Con();
            String query = " select * from customer where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
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
        else if(ae.getSource() == checkprice){
            
            String pack = cpackage.getSelectedItem();
            
            int cost=0;
            if(pack.equals("Gold Package")){
                cost += 32000;
            } else if(pack.equals("Platinum Package")){
                cost += 24000;
            } else {
                cost += 16000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs."+cost);
            
        }
        else if(ae.getSource() == bookpackage){
            
            try{
                Con c = new Con();
                String query = "insert into bookedpackages values ('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"' )";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Booked Successfuly!");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    

    
    public static void main(String[] args){
    new BookPackage("");
    }
}
