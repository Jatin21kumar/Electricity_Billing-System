package billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MeterInformation extends JFrame implements ActionListener {

    JLabel heading, lblname, lblmeterno, lblmeter, lbladdress, lblstate, lblcity, lblemail, lblphone;
    JTextField tfname, tfaddress, tfcity, tfemail, tfphone;
    JButton next, cancel;
    Choice meterLocation, meterType, phaseCode, billType;
    public MeterInformation()
    {
        setSize(700, 500);
        setLocation(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        heading = new JLabel("Meter Information");
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24));
        heading.setBounds(180, 10, 200, 25);
        p.add(heading);

        lblname = new JLabel("Meter Location");
        lblname.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        meterLocation = new Choice();
        meterLocation.add("Outside");
        meterLocation.add("Inside");
        meterLocation.setBounds(240, 80, 200, 20);
        p.add(meterLocation);

        lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lblmeter = new JLabel("");
        lblmeter.setBounds(240, 120, 100, 20);
        p.add(lblmeter);

        Random rand = new Random();
        long number = rand.nextLong() % 1000000;
        lblmeter.setText("" + Math.abs(number)); // we need to convert number to string as setText, random number is generated -ve too thus need to use absolute

        lbladdress = new JLabel("Meter Type");
        lbladdress.setFont(new Font("Tahoma",Font.BOLD, 12));
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        meterType = new Choice();
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        meterType.setBounds(240, 160, 200, 20);
        p.add(meterType);

        lblstate = new JLabel("Phase Code");
        lblstate.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);

        phaseCode = new Choice();
        phaseCode.add("011");
        phaseCode.add("022");
        phaseCode.add("033");
        phaseCode.add("044");
        phaseCode.add("055");
        phaseCode.add("066");
        phaseCode.add("077");
        phaseCode.add("088");
        phaseCode.add("099");
        phaseCode.setBounds(240, 200, 200, 20);
        p.add(phaseCode);

        lblcity = new JLabel("Bill Type");
        lblcity.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);

        billType = new Choice();
        billType.add("Normal");
        billType.add("Industrial");
        billType.setBounds(240, 240, 200, 20);
        p.add(billType);

        lblemail = new JLabel("Days");
        lblemail.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);

        lblemail = new JLabel("30 Days");
        lblemail.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblemail.setBounds(240, 280, 100, 20);
        p.add(lblemail);

        lblphone = new JLabel("Note");
        lblphone.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblphone.setBounds(100, 320, 100, 20);
        p.add(lblphone);

        lblphone = new JLabel("By default Bill is calculated for 30 days");
        lblphone.setFont(new Font("Tahoma",Font.BOLD, 12));
        lblphone.setBounds(240, 320, 500, 20);
        p.add(lblphone);

        next = new JButton("Submit");
        next.setBounds(200, 390, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        p.add(next);

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
        new MeterInformation();
    }
}
