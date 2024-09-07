package billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {

    JLabel heading, lblname, lblmeterno, lblmeter, lbladdress, lblstate, lblcity, lblemail, lblphone;
    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next, cancel;
    public NewCustomer()
    {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        heading = new JLabel("New Customer");
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24));
        heading.setBounds(180, 10, 200, 25);
        p.add(heading);

        lblname = new JLabel("Customer Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);

        lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lblmeter = new JLabel("");
        lblmeter.setBounds(240, 120, 100, 20);
        p.add(lblmeter);

        Random rand = new Random();
        long number = rand.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number)); // we need to convert number to string as setText, random number is generated -ve too thus need to use absolute

        lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Tahoma",Font.BOLD, 12));
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(240, 160, 200, 20);
        p.add(tfaddress);

        lblstate = new JLabel("State");
        lblstate.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(240, 200, 200, 20);
        p.add(tfstate);

        lblcity = new JLabel("City");
        lblcity.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(240, 240, 200, 20);
        p.add(tfcity);

        lblemail = new JLabel("Email");
        lblemail.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(240, 280, 200, 20);
        p.add(tfemail);

        lblphone = new JLabel("Phone Number");
        lblphone.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(240, 320, 200, 20);
        p.add(tfphone);

        next = new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        p.add(cancel);

        setLayout(new BorderLayout());

        add(p, "Center");

        ImageIcon i1=  new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == next)
       {
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfcity.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
       }
       else{
        setVisible(false);
       }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}