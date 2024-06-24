package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton signup, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice question;

    Signup() {
        setSize(1000, 550);
        setLocation(450, 250);
        setLayout(null);
        setTitle("Sign Up");

        getContentPane().setBackground(Color.WHITE);

        JPanel p = new JPanel();
        p.setBackground(new Color(38, 38, 38));
        p.setBounds(0, 0, 590, 550);
        p.setLayout(null);
        add(p);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblusername.setBounds(80, 150, 130, 25);
        lblusername.setForeground(Color.WHITE);
        p.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(210, 150, 260, 30);
        // tfusername.setBackground(Color.);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfusername);

        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblname.setBounds(80, 200, 130, 25);
        lblname.setForeground(Color.WHITE);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(210, 200, 260, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfname);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblpassword.setBounds(80, 250, 130, 25);
        lblpassword.setForeground(Color.WHITE);
        p.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(210, 250, 260, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfpassword);

        JLabel lblquestion = new JLabel("Security Question:");
        lblquestion.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblquestion.setBounds(80, 300, 110, 25);
        lblquestion.setForeground(Color.WHITE);
        p.add(lblquestion);

        question = new Choice();
        question.add("Favourite character from Anime");
        question.add("Favourite Sports");
        question.add("Your Nick Nmae");
        question.add("Favourite MARVEL SuperHero");
        question.setBounds(210, 300, 260, 30);
        question.setBackground(Color.WHITE);
        p.add(question);

        JLabel lblanswer = new JLabel("Answer: ");
        lblanswer.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblanswer.setBounds(80, 350, 110, 25);
        lblanswer.setForeground(Color.WHITE);
        p.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(210, 350, 260, 30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p.add(tfanswer);

        signup = new JButton("Sign Up");
        signup.setBounds(210, 430, 100, 30);
        signup.setFont(new Font("Tahoma", Font.BOLD, 14));
        signup.setBackground(new Color(255, 105, 110));
        signup.setForeground(new Color(250, 247, 247));
        signup.setBorder(new LineBorder(new Color(255, 105, 110)));
        signup.addActionListener(this);
        p.add(signup);

        back = new JButton("Back");
        back.setBounds(330, 430, 100, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBackground(new Color(255, 105, 110));
        back.setForeground(new Color(250, 247, 247));
        back.setBorder(new LineBorder(new Color(255, 105, 110)));
        back.addActionListener(this);
        p.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620, 90, 350, 350);
        add(image);

        JLabel wtext = new JLabel("Welcome to the TripPlanner !");
        wtext.setFont(new Font("Tahoma", Font.ITALIC, 19));
        wtext.setBounds(155, 50, 400, 25);
        wtext.setForeground(Color.WHITE);
        p.add(wtext);

        JLabel wtext2 = new JLabel("Feel Free from All the Plannings !");
        wtext2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        wtext2.setBounds(180, 70, 400, 25);
        wtext2.setForeground(Color.WHITE);
        p.add(wtext2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == signup) {

                String username = tfusername.getText();
                String name = tfname.getText();
                String password = tfpassword.getText();
                String security = question.getSelectedItem();
                String answer = tfanswer.getText();

                String query = " insert into account values('" + username + "', '" + name + "', '" + password + "', '" + security + "', '" + answer + "')";
                try {
                    Con c = new Con();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, " Your Account has been Successfully Created ! ");
                    setVisible(false);
                    new Login();

                } catch (Exception e) {
                    e.printStackTrace();
                } 
                    

            } if (ae.getSource() == back) {
                setVisible(false);
                new Login();
            }
    }

    public static void main(String[] arg) {
        new Signup();
    }
}
