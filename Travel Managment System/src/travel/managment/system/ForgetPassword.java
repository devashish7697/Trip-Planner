package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, fetch, back;

    ForgetPassword() {
        setBounds(480, 280, 1020, 550);
        fetch = new JButton("retrieve");
        setTitle("Forget Password");

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

        tfusername = new JTextField();
        tfusername.setBounds(230, 150, 250, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfusername);

        search = new JButton("search");
        search.setBounds(230, 190, 75, 25);
        search.setFont(new Font("Tahoma", Font.BOLD, 14));
        search.setBackground(new Color(255, 105, 110));
        search.setForeground(new Color(250, 247, 247));
        search.setBorder(new LineBorder(new Color(255, 105, 110)));
        search.addActionListener(this);
        p.add(search);

        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblname.setBounds(80, 240, 130, 25);
        lblname.setForeground(Color.WHITE);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(230, 240, 250, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfname);

        JLabel lblquestion = new JLabel("Security Que :");
        lblquestion.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblquestion.setBounds(80, 280, 130, 25);
        lblquestion.setForeground(Color.WHITE);
        p.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(230, 280, 250, 30);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer :");
        lblanswer.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblanswer.setBounds(80, 320, 130, 25);
        lblanswer.setForeground(Color.WHITE);
        p.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(230, 320, 250, 30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfanswer);

        fetch = new JButton("retrieve");
        fetch.setBounds(230, 360, 75, 25);
        fetch.setFont(new Font("Tahoma", Font.BOLD, 13));
        fetch.setBackground(new Color(255, 105, 110));
        fetch.setForeground(new Color(250, 247, 247));
        fetch.setBorder(new LineBorder(new Color(255, 105, 110)));
        fetch.addActionListener(this);
        p.add(fetch);

        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblpassword.setBounds(80, 400, 130, 25);
        lblpassword.setForeground(Color.WHITE);
        p.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(230, 400, 250, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(400, 460, 80, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 13));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        p.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            try {
                String query = " select * from account where username = '" + tfusername.getText() + "' ";
                Con c = new Con();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == fetch) {
            try {
                String query = " select * from account where answer = '" + tfanswer.getText() + "' AND username = '" + tfusername.getText() + "' ";
                Con c = new Con();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                   tfpassword.setText(rs.getString("password"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
