package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel lblusername, labelusername, lblid, lblnumber, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfadress, tfemail, tfphone, tfgender, tfid;
    JRadioButton rmale, rfemale;
    JButton add, back;
    

    UpdateCustomer(String username) {
        setBounds(600, 300, 930, 570);
        setLayout(null);

        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(100, 30, 410, 25);
        text.setForeground(Color.black);
        add(text);
        

        lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblusername.setBounds(110, 90, 130, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        labelusername.setBounds(280, 90, 130, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);

        lblid = new JLabel("Id :");
        lblid.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblid.setBounds(110, 130, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(280, 130, 130, 25);
        add(tfid);

        lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblnumber.setBounds(110, 170, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(280, 170, 130, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name :");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblname.setBounds(110, 210, 130, 25);
        lblname.setForeground(Color.black);
        add(lblname);

        labelname = new JLabel("");
        labelname.setFont(new Font("Tahoma", Font.ITALIC, 14));
        labelname.setBounds(280, 210, 170, 25);
        labelname.setForeground(Color.black);
        add(labelname);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblgender.setBounds(110, 250, 130, 25);
        lblgender.setForeground(Color.black);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(280, 250, 130, 25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblcountry.setBounds(110, 290, 130, 25);
        lblcountry.setForeground(Color.black);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(280, 290, 130, 25);
        add(tfcountry);

        JLabel lbladress = new JLabel("Adress :");
        lbladress.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lbladress.setBounds(110, 330, 130, 25);
        lbladress.setForeground(Color.black);
        add(lbladress);

        tfadress = new JTextField();
        tfadress.setBounds(280, 330, 130, 25);
        add(tfadress);

        JLabel lblemail = new JLabel("Email :");
        lblemail.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblemail.setBounds(110, 370, 130, 25);
        lblemail.setForeground(Color.black);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(280, 370, 130, 25);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone :");
        lblphone.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblphone.setBounds(110, 410, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(280, 410, 130, 25);
        add(tfphone);

        add = new JButton("update");
        add.setBounds(110, 485, 125, 25);
        add.setFont(new Font("Tahoma", Font.BOLD, 13));
        add.setBackground(new Color(255, 105, 110));
        add.setForeground(new Color(250, 247, 247));
        add.setBorder(new LineBorder(new Color(255, 105, 110)));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(280, 485, 125, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/man.png"));
        Image i2 = i1.getImage().getScaledInstance(270, 270, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570, 120, 200, 250);
        add(image);

        try {
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"' ");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfadress.setText(rs.getString("adress"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfid.setText(rs.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String phone = tfphone.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String adress = tfadress.getText();
            String email = tfemail.getText();
            
            try{
                
                Con c = new Con();
                String query = " update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name ='"+name+"', gender ='"+gender+"', country ='"+country+"', adress = '"+adress+"', phone ='"+phone+"', email = '"+email+"' ";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
                
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
