package travel.managment.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, fpassword;
    JTextField tfusername, tfpassword;

    Login() {
        setSize(990, 500);
        setLocation(450, 250);
        setLayout(null);
        setTitle("Login");

        // getContentPane().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        p.setBounds(0, 0, 450, 600);
        p.setLayout(null);
        add(p);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login2.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 50, 300, 300);
        p.add(image);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(38, 38, 38));
        p1.setBounds(450, 0, 540, 600);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(90, 180, 130, 25);
        lblusername.setFont(new Font("SAN_SERIF", Font.ITALIC, 16));
        lblusername.setForeground(Color.WHITE);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 180, 240, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setBounds(90, 230, 130, 25);
        lblpassword.setFont(new Font("SAN_SERIF", Font.ITALIC, 16));
        lblpassword.setForeground(Color.WHITE);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 230, 240, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(170, 300, 110, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p1.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(290, 300, 110, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p1.add(signup);

        fpassword = new JButton("Forget Password ?");
        fpassword.setBounds(220, 350, 140, 30);
        fpassword.setBackground(new Color(133, 193, 233));
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(new LineBorder(new Color(133, 193, 233)));
        fpassword.addActionListener(this);
        p1.add(fpassword);

        JLabel text = new JLabel("Trouble Signing in ?");
        text.setBounds(240, 390, 150, 15);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SAN_SERIF", Font.ROMAN_BASELINE, 10));
        p1.add(text);

        JLabel wtext = new JLabel("Welcome to the TripPlanner !");
        wtext.setFont(new Font("Tahoma", Font.ITALIC, 20));
        wtext.setBounds(120, 80, 400, 25);
        wtext.setForeground(Color.WHITE);
        p1.add(wtext);

        JLabel wtext2 = new JLabel("Feel Free from All the Plannings !");
        wtext2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        wtext2.setBounds(160, 100, 400, 25);
        wtext2.setForeground(Color.WHITE);
        p1.add(wtext2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();

                String query = " select * from account where username = '" + username + "' AND password = '" + pass + "' ";
                Con c = new Con();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, " Incorrect Username Or Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();

        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
