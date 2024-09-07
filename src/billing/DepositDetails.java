package billing;

import javax.swing.*;
import java.awt.*;
import java.lang.module.ResolutionException;
import java.sql.ResultSet;

public class DepositDetails extends JFrame {

    JLabel lblmeterNumber;
    Choice meter;
    public DepositDetails()
    {
        super("Deposit Details");

        lblmeterNumber = new JLabel("Search by Meter Number");
        lblmeterNumber.setBounds(180, 20, 150, 20);
        add(lblmeterNumber);

        meter = new Choice();
        meter.setBounds(180, 20, 150, 20);
        add(meter);

        try
        {
            ConnectionProv con = new ConnectionProv();
            ResultSet rs = con.stmt.executeQuery("select * from customer");
            while(rs.next())
            {
                meter.add(rs.getString("meter_no"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        setSize(700, 700);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DepositDetails();
    }
}
