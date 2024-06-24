package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Paytm extends JFrame {
    
    Paytm(){
    
        setTitle("Paytm");
        setBounds(600,200,950,700);
        setLayout(null);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com");
        } catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html> could not Load Error 404  </html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        setVisible(true);
    
    }
    
    public static void main(String[] args){
    new Paytm();
    }
}
