package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton resetpassword, about, notepad, personDetail, updatedetails, viewdetail, deletePersonalDetail, payments , calculator ,checkPackages, bookPackages, viewPackage, destinations ,viewHotels, bookHotels, yourBookedHotel;
    String username;
    
    Dashboard( String username) {

        this.username = username;
        //setBounds(0,0,1500,950);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setTitle("TriPlanner");

        JPanel p = new JPanel();
        p.setBounds(0, 0, 2000, 65);
        p.setBackground(new Color(61, 61, 61));
        // p.setBorder(new LineBorder(Color.BLUE));
        add(p);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(15, 5, 60, 60);
        p.setLayout(null);
        p.add(image);

        JLabel cname = new JLabel("TriPlanner");
        cname.setBounds(80, 25, 130, 25);
        cname.setFont(new Font("SAN_SERIF", Font.BOLD, 19));
        cname.setForeground(Color.WHITE);
        p.add(cname);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 65, 260, 900);
        p1.setBackground(new Color(61, 61, 61));
        p1.setLayout(null);
        add(p1);

        personDetail = new JButton("Add Personal Details");
        personDetail.setBounds(10, 20, 200, 35);
        personDetail.setBackground(new Color(61, 61, 61));
        personDetail.setForeground(Color.WHITE);
        personDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        personDetail.setBorder(BorderFactory.createEmptyBorder());
        personDetail.setLayout(null);
        personDetail.setMargin(new Insets(0, 0, 0, 50));
        personDetail.addActionListener(this);
        p1.add(personDetail);

        updatedetails = new JButton("Update Personal Details");
        updatedetails.setBounds(10, 70, 220, 35);
        updatedetails.setBackground(new Color(61, 61, 61));
        updatedetails.setForeground(Color.WHITE);
        updatedetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
        updatedetails.setBorder(BorderFactory.createEmptyBorder());
        updatedetails.setLayout(null);
        updatedetails.setMargin(new Insets(0, 60, 0, 0));
        updatedetails.addActionListener(this);
        p1.add(updatedetails);
        
        viewdetail = new JButton("View Detail");
        viewdetail.setBounds(20, 120, 120, 35);
        viewdetail.setBackground(new Color(61, 61, 61));
        viewdetail.setForeground(Color.WHITE);
        viewdetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        viewdetail.setBorder(BorderFactory.createEmptyBorder());
        viewdetail.setLayout(null);
        viewdetail.addActionListener(this);
        viewdetail.setMargin(new Insets(0, 0, 0, 60));
        p1.add(viewdetail);
        
        deletePersonalDetail = new JButton("Delete Personal Details");
        deletePersonalDetail.setBounds(6, 170, 220, 35);
        deletePersonalDetail.setBackground(new Color(61, 61, 61));
        deletePersonalDetail.setForeground(Color.WHITE);
        deletePersonalDetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deletePersonalDetail.setBorder(BorderFactory.createEmptyBorder());
        deletePersonalDetail.setLayout(null);
        deletePersonalDetail.setMargin(new Insets(0, 0, 0, 90));
        p1.add(deletePersonalDetail);
        
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(10, 220, 170, 35);
        checkPackages.setBackground(new Color(61, 61, 61));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 14));
        checkPackages.setBorder(BorderFactory.createEmptyBorder());
        checkPackages.setLayout(null);
        checkPackages.setMargin(new Insets(0, 0, 0, 60));
        checkPackages.addActionListener(this);
        p1.add(checkPackages);
        
        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(10, 270, 160, 35);
        bookPackages.setBackground(new Color(61, 61, 61));
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bookPackages.setBorder(BorderFactory.createEmptyBorder());
        bookPackages.setLayout(null);
        bookPackages.setMargin(new Insets(0, 0, 0, 90));
        bookPackages.addActionListener(this);
        p1.add(bookPackages);
        
        viewPackage = new JButton("Your Bookings");
        viewPackage.setBounds(10, 320, 160, 35);
        viewPackage.setBackground(new Color(61, 61, 61));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        viewPackage.setBorder(BorderFactory.createEmptyBorder());
        viewPackage.setLayout(null);
        viewPackage.setMargin(new Insets(0, 0, 0, 90));
        viewPackage.addActionListener(this);
        p1.add(viewPackage);
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(10, 370, 140, 35);
        viewHotels.setBackground(new Color(61, 61, 61));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 14));
        viewHotels.setBorder(BorderFactory.createEmptyBorder());
        viewHotels.setLayout(null);
        viewHotels.setMargin(new Insets(0, 0, 0, 90));
        viewHotels.addActionListener(this);
        p1.add(viewHotels);
        
        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(10, 420, 140, 35);
        bookHotels.setBackground(new Color(61, 61, 61));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bookHotels.setBorder(BorderFactory.createEmptyBorder());
        bookHotels.setLayout(null);
        bookHotels.setMargin(new Insets(0, 0, 0, 90));
        bookHotels.addActionListener(this);
        p1.add(bookHotels);
        
        yourBookedHotel = new JButton("Your Booked Hotel");
        yourBookedHotel.setBounds(10, 470, 180, 35);
        yourBookedHotel.setBackground(new Color(61, 61, 61));
        yourBookedHotel.setForeground(Color.WHITE);
        yourBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        yourBookedHotel.setBorder(BorderFactory.createEmptyBorder());
        yourBookedHotel.setLayout(null);
        yourBookedHotel.setMargin(new Insets(0, 0, 0, 90));
        yourBookedHotel.addActionListener(this);
        p1.add(yourBookedHotel);
        
        destinations = new JButton("View Destinations");
        destinations.setBounds(6, 520, 180, 35);
        destinations.setBackground(new Color(61, 61, 61));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 14));
        destinations.setBorder(BorderFactory.createEmptyBorder());
        destinations.setLayout(null);
        destinations.setMargin(new Insets(0, 0, 0, 90));
        destinations.addActionListener(this);
        p1.add(destinations);
        
        payments = new JButton("Payment");
        payments.setBounds(10, 570, 120, 35);
        payments.setBackground(new Color(61, 61, 61));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 14));
        payments.setBorder(BorderFactory.createEmptyBorder());
        payments.setLayout(null);
        payments.setMargin(new Insets(0, 0, 0, 90));
        p1.add(payments);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(10, 620, 120, 35);
        calculator.setBackground(new Color(61, 61, 61));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 14));
        calculator.setBorder(BorderFactory.createEmptyBorder());
        calculator.setLayout(null);
        calculator.setMargin(new Insets(0, 0, 0, 90));
        calculator.addActionListener(this);
        p1.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(10, 670, 115, 35);
        notepad.setBackground(new Color(61, 61, 61));
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        notepad.setBorder(BorderFactory.createEmptyBorder());
        notepad.setLayout(null);
        notepad.setForeground(Color.WHITE);
        notepad.setMargin(new Insets(0, 0, 0, 90));
        notepad.addActionListener(this);
        p1.add(notepad);

        about = new JButton("About");
        about.setBounds(10, 720, 100, 35);
        about.setBackground(new Color(61, 61, 61));
        about.setFont(new Font("Tahoma", Font.PLAIN, 14));
        about.setBorder(BorderFactory.createEmptyBorder());
        about.setLayout(null);
        about.setForeground(Color.WHITE);
        about.setMargin(new Insets(0, 0, 0, 90));
        about.addActionListener(this);
        p1.add(about);
        
        resetpassword = new JButton("Reset Password");
        resetpassword.setBounds(1350, 20, 150, 25);
        resetpassword.setBackground(new Color(61, 61, 61));
        resetpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resetpassword.setBorder(BorderFactory.createEmptyBorder());
        resetpassword.setLayout(null);
        resetpassword.setForeground(Color.WHITE);
        resetpassword.setMargin(new Insets(0, 0, 0, 90));
        resetpassword.addActionListener(this);
        p.add(resetpassword);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel7.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1920, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(0, 0, 1920, 1000);
        p.setLayout(null);
        add(image2);
        
        JLabel wtext = new JLabel("Welcome to TripPlanner !");
        wtext.setBounds(1150, 100, 1000, 70);
        wtext.setFont(new Font("Tahoma", Font.ITALIC, 30));
        wtext.setForeground(Color.white);
        image2.add(wtext);
        

        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == personDetail){
            new AddCustomer(username);
        } 
        else if(ae.getSource()== viewdetail){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == updatedetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == checkPackages){
            new CheckPackage();
        }
        else if(ae.getSource() == bookPackages){
            new BookPackage(username);
        }
        else if(ae.getSource() == viewPackage){
            new ViewPackage(username);
        }
        else if(ae.getSource() == viewHotels){
            new ViewHotels();
        }
        else if(ae.getSource() == destinations){
            new ViewDestination();
        }
        else if(ae.getSource() == bookHotels){
            new BookHotel(username);
        }
        else if(ae.getSource() == yourBookedHotel ){
            new ViewBookedHotel(username);
        }
        else if(ae.getSource() == resetpassword ){
            new ResetPassword(username);
        }
        else if(ae.getSource() == calculator ){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == notepad ){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }

}
