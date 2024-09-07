package billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener, Runnable {
    Thread t;
    JLabel image;
    public Splash()
    {
        setTitle("");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        image = new JLabel(i3);
        add(image);

        setVisible(true); // we are making dynamic toh wo dikhna bhi chaiya

        int x = 1;
        for(int i=2; i<600; i+=4, x+=1)
        {
            setSize(new Dimension(i+x, i));
            setLocation(700 - ((i+x)/2), 400 - (i/2));
        } // we want that after some time it should close and new window will open, so we use sleep function

        try
        {
            Thread.sleep(5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        t = new Thread(this);
        t.start(); // internally calls run method

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void run() // now to open login frame after sleep we use run function
    {
        try{
            Thread.sleep(2000);
            setVisible(false);

            new Login().setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae)
    {

    }

    public static void main(String[] args) {
        new Splash();
    }
}
