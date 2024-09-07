package billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.module.ResolutionException;
import java.security.spec.ECField;
import java.sql.ResultSet;
import java.util.Random;

public class CalculateBill extends JFrame implements ActionListener {

    JLabel heading, lblname, lblmeterno, lblmeter, lbladdress, lblstate, lblcity, lblemail, lblphone;
    JTextField tfname, tfaddress, tfunits, tfcity, tfemail, tfphone;
    JButton next, cancel;
    Choice meterNumber, cmonth;
    public CalculateBill()
    {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        heading = new JLabel("Calculate Electricity Bill");
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24));
        heading.setBounds(160, 10, 500, 25);
        p.add(heading);

        lblname = new JLabel("Meter Number");
        lblname.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        meterNumber = new Choice();

        try
        {
            ConnectionProv con = new ConnectionProv();
            ResultSet rsv = con.stmt.executeQuery("select * from customers");

            while(rsv.next())
            {
                meterNumber.add(rsv.getString("meter_no"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        meterNumber.setBounds(240, 80, 200, 20);
        p.add(meterNumber);

        lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lblname = new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);

//        Random rand = new Random();
//        long number = rand.nextLong() % 1000000;
//        lblmeter.setText("" + Math.abs(number)); // we need to convert number to string as setText, random number is generated -ve too thus need to use absolute

        lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Tahoma",Font.BOLD, 12));
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(240, 160, 200, 20);
        p.add(tfaddress);

        try
        {
            ConnectionProv con = new ConnectionProv();
            ResultSet rs = con.stmt.executeQuery("select * from customer where meter_no = '"+meterNumber.getSelectedItem()+"'");
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                lbladdress.setText(rs.getString("address"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        meterNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try
                {
                    ConnectionProv con = new ConnectionProv();
                    ResultSet rs = con.stmt.executeQuery("select * from customer where meter_no = '"+meterNumber.getSelectedItem()+"'");
                    while(rs.next())
                    {
                        lblname.setText(rs.getString("name"));
                        lbladdress.setText(rs.getString("address"));
                    }
                }
                catch(Exception ee)
                {
                    ee.printStackTrace();
                }
            }
        });

        lblstate = new JLabel("Units Consumed");
        lblstate.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);

        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);

        lblcity = new JLabel("Month");
        lblcity.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);

        next = new JButton("Submit");
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

        ImageIcon i1=  new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
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
        new CalculateBill();
    }
}