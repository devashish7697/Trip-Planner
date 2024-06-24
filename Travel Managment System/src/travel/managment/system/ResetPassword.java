package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class ResetPassword extends JFrame implements ActionListener{
    
    JTextField tfnewpassword, tfname, tfquestion, tfanswer;
    JButton back, update;
    JLabel labelusername, labelname, labelquestion;
    JPasswordField tfpassword;
    
    ResetPassword(String username){

        setBounds(550, 280, 1020, 550);
        setTitle("Reset Password");

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 600, 550);
        p.setLayout(null);
        p.setBackground(new Color(38, 38, 38));
        add(p);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgetpass.png"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650, 120, 300, 300);
        add(image);
        
        JLabel wtext = new JLabel("Forgot Your Password ?");
        wtext.setFont(new Font("Tahoma", Font.ITALIC, 19));
        wtext.setBounds(170, 50, 400, 25);
        wtext.setForeground(Color.WHITE);
        p.add(wtext);

        JLabel wtext2 = new JLabel("Well! you don't have to worry When TripPlanner is Here !");
        wtext2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        wtext2.setBounds(100, 75, 400, 25);
        wtext2.setForeground(Color.WHITE);
        p.add(wtext2);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblusername.setBounds(80, 150, 130, 25);
        lblusername.setForeground(Color.WHITE);
        p.add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        labelusername.setBounds(230, 150, 250, 30);
        labelusername.setForeground(Color.WHITE);
        p.add(labelusername);
        
        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblname.setBounds(80, 200, 130, 25);
        lblname.setForeground(Color.WHITE);
        p.add(lblname);
        
        labelname = new JLabel();
        labelname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        labelname.setBounds(230, 200, 250, 30);
        labelname.setForeground(Color.WHITE);
        p.add(labelname);
        
        JLabel lblquestion = new JLabel("Security Que :");
        lblquestion.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblquestion.setBounds(80, 250, 130, 25);
        lblquestion.setForeground(Color.WHITE);
        p.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        tfquestion.setBounds(230, 250, 250, 30);
        p.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer :");
        lblanswer.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblanswer.setBounds(80, 300, 130, 25);
        lblanswer.setForeground(Color.WHITE);
        p.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(230, 300, 250, 30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfanswer);
        
        JLabel lblnewpassword = new JLabel("New Password :");
        lblnewpassword.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblnewpassword.setBounds(80, 350, 130, 25);
        lblnewpassword.setForeground(Color.WHITE);
        p.add(lblnewpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(230, 350, 250, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfpassword);
        
        update = new JButton("Reset Password");
        update.setBounds(150, 430, 140, 25);
        update.setFont(new Font("Tahoma", Font.BOLD, 13));
        update.setBackground(new Color(255, 105, 110));
        update.setForeground(new Color(250, 247, 247));
        update.setBorder(new LineBorder(new Color(255, 105, 110)));
        update.addActionListener(this);
        p.add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 430, 90, 25);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        p.add(back);
        
        try {
            Con c = new Con();
            String query = " select * from account where username = '"+username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfquestion.setText(rs.getString("security"));
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
        else if(ae.getSource() == update){
            String password = tfpassword.getText();
            String answer = tfanswer.getText();
            String username = labelusername.getText();
            if(resetPassword(username,password,answer)){
                JOptionPane.showMessageDialog(this, "Password reset successful.");
            } else{
                JOptionPane.showMessageDialog(this, "Failed to reset password.");
            }
            
            
            
            
        }  
    }
    
    public boolean resetPassword(String username, String password, String answer) {
        try {
            Con c = new Con();
                String query = " update account set password = '"+password+"' where username = '"+username+"' AND answer = '"+answer+"'"; 
               int rowsAffected = c.s.executeUpdate(query);

            // Check if password reset was successful
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void main(String [] args){
    new ResetPassword("");
    }
}


