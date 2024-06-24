package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener{
    
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice ;
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    JButton bookhotel,back,checkprice;
    
    BookHotel(String username){
        this.username = username;
        
        setBounds(600, 200, 1000, 700);
        setLayout(null);

        getContentPane().setBackground(Color.white);
    
        JLabel text = new JLabel("Book Hotel");
        text.setFont(new Font("Tahoma", Font.BOLD, 28));
        text.setBounds(160, 50, 250, 30);
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
        
        JLabel Selectpackage = new JLabel("Select Hotel :");
        Selectpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        Selectpackage.setBounds(90, 180, 150, 25);
        Selectpackage.setForeground(Color.black);
        add(Selectpackage);
        
        chotel = new Choice();
        chotel.setBounds(280,180,150 ,25);
        chotel.setFont(new Font("Tahoma", Font.BOLD, 13)); 
        chotel.setBackground(Color.white);
        add(chotel);
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
        
        JLabel lblpersons = new JLabel("Total Persons :");
        lblpersons.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblpersons.setBounds(90, 230, 150, 25);
        lblpersons.setForeground(Color.black);
        add(lblpersons);
        
        tfpersons = new JTextField();
        tfpersons.setBounds(280,230,150,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days :");
        lbldays.setFont(new Font("Tahoma", Font.BOLD , 15));
        lbldays.setBounds(90, 280, 150, 25);
        lbldays.setForeground(Color.black);
        add(lbldays);
        
        tfdays = new JTextField();
        tfdays.setBounds(280,280,150,25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/NON-AC :");
        lblac.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblac.setBounds(90, 330, 150, 25);
        lblac.setForeground(Color.black);
        add(lblac);
        
        cac = new Choice();
        cac.setBounds(280,330,150 ,25);
        cac.add("AC");
        cac.add("NON-AC");
        cac.setFont(new Font("Tahoma", Font.BOLD, 13)); 
        cac.setBackground(Color.white);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included :");
        lblfood.setFont(new Font("Tahoma", Font.BOLD , 15));
        lblfood.setBounds(90, 380, 150, 25);
        lblfood.setForeground(Color.black);
        add(lblfood);
        
        cfood = new Choice();
        cfood.setBounds(280,380,150 ,25);
        cfood.add("Yes");
        cfood.add("NO");
        cfood.setFont(new Font("Tahoma", Font.BOLD, 13)); 
        cfood.setBackground(Color.white);
        add(cfood);
        
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
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(580, 490, 140, 25);
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 13));
        checkprice.setBackground(new Color(255, 105, 110));
        checkprice.setForeground(new Color(250, 247, 247));
        checkprice.setBorder(new LineBorder(new Color(255, 105, 110)));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book");
        bookhotel.setBounds(740, 490, 140, 25);
        bookhotel.setFont(new Font("Tahoma", Font.BOLD, 13));
        bookhotel.setBackground(new Color(255, 105, 110));
        bookhotel.setForeground(new Color(250, 247, 247));
        bookhotel.setBorder(new LineBorder(new Color(255, 105, 110)));
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBounds(670, 540, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(133, 193, 233));
        back.setForeground(new Color(250, 247, 247));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(510, 150, 400, 300);
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
            try{
                Con c = new Con();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                 while(rs.next()){
                     int cost = Integer.parseInt(rs.getString("costperperson"));
                     int food = Integer.parseInt(rs.getString("foodincluded"));
                     int ac = Integer.parseInt(rs.getString("acroom"));
                     
                     int persons = Integer.parseInt(tfpersons.getText());
                     int days = Integer.parseInt(tfdays.getText());
                     String acselected = cac.getSelectedItem();
                     String foodselected = cfood.getSelectedItem();
                     
                     if(persons * days > 0){
                         int total =0;
                         total += acselected.equals("AC") ? ac : 0;
                         total += foodselected.equals("Yes") ? food : 0;
                         total += cost;
                         total = total*persons*days;
                         labelprice.setText("Rs. "+total);
                     } else {
                         JOptionPane.showMessageDialog(null, "Please enter a valid Number ");
                     }
                     
                 }
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == bookhotel){
            try{
                Con c = new Con();
                String query = "insert into bookedhotel values ('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"' ,'"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"' )";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfuly!");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args){
        new BookHotel(""); 
    }
}
