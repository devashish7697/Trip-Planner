package travel.managment.system; 
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class splash extends JFrame implements Runnable{

    splash() {
        //setSize(1300, 700);
        // setLocation(330,170);
        setTitle("TriPlannner");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        

        setVisible(true); 
      
        Thread thread;
        thread = new Thread(this);
        thread.start();
    }
    
    public void run(){
      try{
        Thread.sleep(7000);
        setVisible(false);
        new Login();
      }catch(InterruptedException e){}
    }
        

public static void main(String[] args) throws Exception{
        splash frame = new splash();

        Thread.sleep(1000);
        int x = 1;
        for (int i = 1; i <= 600; x += 6, i += 6) {
            frame.setSize(x + i, i);
            frame.setLocation(750 - (x + i) / 3, 400 - (i / 3));
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {}

        }
        
       
}
}