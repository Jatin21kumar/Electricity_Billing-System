package billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel user, pass, image, login;
    JTextField userText;
    JPasswordField passText;
    JButton loginbt, cancel,sign;
    Choice loginch;
    ImageIcon i1, i3, i4, i6, i7, i9, i10, i11;
    Image i2, i5, i8, i12;
    public Login()
    {
        super("Login Page");
        setLayout(null);

        user = new JLabel("Username");
        user.setBounds(260, 50, 200, 30);
        user.setFont(new Font("Raleway", Font.BOLD, 20));
        add(user);

        userText = new JTextField();
        userText.setBounds(430, 53, 200, 25);
        userText.setFont(new Font("Raleway", Font.ITALIC, 18));
        add(userText);

        pass = new JLabel("Password");
        pass.setBounds(260, 110, 200, 30);
        pass.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pass);

        passText = new JPasswordField();
        passText.setBounds(430, 113,200, 25);
        passText.setFont(new Font("Rlaeway", Font.ITALIC, 18));
        add(passText);

        login = new JLabel("Logginng in as");
        login.setBounds(260, 170, 150, 30);
        login.setFont(new Font("Rlaleway", Font.BOLD, 20));
        add(login);

        loginch = new Choice();
        loginch.add("Admin");
        loginch.add("Customer");
        loginch.setBounds(430, 173,200, 30);
        add(loginch);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        loginbt = new JButton("Login", i3);
        loginbt.setFont(new Font("Raleway", Font.BOLD, 18));
        loginbt.setBounds(330, 250, 120, 25);
        loginbt.addActionListener(this);
        add(loginbt);

        i4 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        i5 = i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        i6 = new ImageIcon(i5);
        cancel = new JButton("Cancel", i6);
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBounds(470, 250, 120, 25);
        cancel.addActionListener(this);
        add(cancel);

        i7 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        i8 = i7.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        i9 = new ImageIcon(i8);
        sign = new JButton("SignUp", i9);
        sign.setFont(new Font("Raleway", Font.BOLD, 18));
        sign.setBounds(400, 300, 120, 25);
        sign.addActionListener(this);;
        add(sign);

        i10 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        i12 = i10.getImage().getScaledInstance(230, 220, Image.SCALE_DEFAULT);
        i11 = new ImageIcon(i12);
        image = new JLabel(i11);
        image.setBounds(40, 40, 150, 200);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setLocation(400, 120);
        setSize(new Dimension(700, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == loginbt)
        {
            String susername = userText.getText();
            String spassword = passText.getText();
            String suser = loginch.getSelectedItem();

            try
            {
                ConnectionProv con = new ConnectionProv();
                String sql = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+suser+"'";

                ResultSet rs = con.stmt.executeQuery(sql);

                if(rs.next())
                {
                    setVisible(false);
                    new Project().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    userText.setText("");
                    passText.setText("");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
        if(ae.getSource() == sign)
        {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}
