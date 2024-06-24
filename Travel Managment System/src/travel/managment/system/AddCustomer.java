package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblusername, labelusername, lblid, lblnumber, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfadress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    

    AddCustomer(String username) {
        setBounds(600, 300, 900, 550);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        lblusername = new JLabel("Username :");
        lblusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblusername.setBounds(80, 50, 130, 25);
        lblusername.setForeground(Color.black);
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        labelusername.setBounds(250, 50, 130, 25);
        labelusername.setForeground(Color.black);
        add(labelusername);

        lblid = new JLabel("Id :");
        lblid.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblid.setBounds(80, 90, 130, 25);
        lblid.setForeground(Color.black);
        add(lblid);

        comboid = new JComboBox(new String[]{"Passport", "Aadhar Card", "Pan Card"});
        comboid.setBounds(250, 90, 130, 25);
        comboid.setBackground(Color.white);
        add(comboid);

        lblnumber = new JLabel("Number :");
        lblnumber.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblnumber.setBounds(80, 130, 130, 25);
        lblnumber.setForeground(Color.black);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(250, 130, 130, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name :");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblname.setBounds(80, 170, 130, 25);
        lblname.setForeground(Color.black);
        add(lblname);

        labelname = new JLabel("");
        labelname.setFont(new Font("Tahoma", Font.ITALIC, 14));
        labelname.setBounds(250, 170, 170, 25);
        labelname.setForeground(Color.black);
        add(labelname);

        JLabel lblgender = new JLabel("Gender :");
        lblgender.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblgender.setBounds(80, 210, 130, 25);
        lblgender.setForeground(Color.black);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(250, 210, 60, 25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(310, 210, 80, 25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country :");
        lblcountry.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblcountry.setBounds(80, 250, 130, 25);
        lblcountry.setForeground(Color.black);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(250, 250, 130, 25);
        add(tfcountry);

        JLabel lbladress = new JLabel("Adress :");
        lbladress.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lbladress.setBounds(80, 290, 130, 25);
        lbladress.setForeground(Color.black);
        add(lbladress);

        tfadress = new JTextField();
        tfadress.setBounds(250, 290, 130, 25);
        add(tfadress);

        JLabel lblemail = new JLabel("Email :");
        lblemail.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblemail.setBounds(80, 330, 130, 25);
        lblemail.setForeground(Color.black);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(250, 330, 130, 25);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone :");
        lblphone.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblphone.setBounds(80, 370, 130, 25);
        lblphone.setForeground(Color.black);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(250, 370, 130, 25);
        add(tfphone);

        add = new JButton("Add");
        add.setBounds(100, 450, 120, 25);
        add.setFont(new Font("Tahoma", Font.BOLD, 13));
        add.setBackground(new Color(255, 105, 110));
        add.setForeground(new Color(250, 247, 247));
        add.setBorder(new LineBorder(new Color(255, 105, 110)));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(260, 450, 120, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 60, 280, 465);
        add(image);

        try {
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"' ");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String phone = tfphone.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String adress = tfadress.getText();
            String email = tfemail.getText();
            
            try{
                
                Con c = new Con();
                String query = " insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+adress+"', '"+phone+"', '"+email+"') ";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details added Successfully");
                setVisible(false);
                
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
