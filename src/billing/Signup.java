package billing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Signup extends JFrame implements ActionListener{

    JLabel cacc,user, name, pass, image;
    JTextField userTxt, nameTxt;
    JPasswordField passTxt;
    Choice acc;
    JButton create, back;
    JPanel panel;
    public Signup()
    {
       super("Sign UP");
       setLayout(null);

       panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.WHITE);
       panel.setBounds(30, 30, 650, 300);
       panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
       panel.setForeground(new Color(34, 139, 34));
       add(panel);

       cacc = new JLabel("Create Account as");
       cacc.setBounds(60, 30, 150, 30);
       cacc.setFont(new Font("Raleway", Font.BOLD, 16));
       panel.add(cacc);

       acc = new Choice();
       acc.add("Admin");
       acc.add("Customer");
       acc.setBounds(250, 35, 180, 30);
       panel.add(acc);

       user = new JLabel("Username");
       user.setBounds(60, 100, 150, 30);
       user.setFont(new Font("Raleway", Font.BOLD, 16));
       panel.add(user);

       userTxt = new JTextField();
       userTxt.setBounds(250,107, 180, 20);
       userTxt.setFont(new Font("Raleway", Font.ITALIC, 16));
       panel.add(userTxt);

       name = new JLabel("Name");
       name.setBounds(60, 140, 150, 30);
       name.setFont(new Font("Raleway", Font.BOLD, 16));
       panel.add(name);

       nameTxt = new JTextField();
       nameTxt.setBounds(250,147, 180, 20);
       nameTxt.setFont(new Font("Raleway", Font.ITALIC, 16));
       panel.add(nameTxt);

       pass = new JLabel("Password");
       pass.setBounds(60, 180, 150, 30);
       pass.setFont(new Font("Raleway", Font.BOLD, 16));
       panel.add(pass);

       passTxt = new JPasswordField();
       passTxt.setBounds(250,187, 180, 20);
       passTxt.setFont(new Font("Raleway", Font.ITALIC, 16));
       panel.add(passTxt);

       create = new JButton("Create");
       create.setBounds(110, 240, 120, 25);
       create.setForeground(Color.WHITE);
       create.setBackground(Color.BLACK);
       create.setFont(new Font("Raleway", Font.BOLD, 16));
       create.addActionListener(this);
       panel.add(create);

       back = new JButton("Back");
       back.setBounds(260, 240, 120, 25);
       back.setForeground(Color.WHITE);
       back.setBackground(Color.BLACK);
       back.setFont(new Font("Raleway", Font.BOLD, 16));
       back.addActionListener(this);
       panel.add(back);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
       Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       image = new JLabel(i3);
       image.setBounds(450, 40, 200, 200);
       panel.add(image);



       getContentPane().setBackground(Color.WHITE);
       setLocation(400, 120);
       setSize(new Dimension(700, 400));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        if(ae.getSource() == create)
        {
            String atype = acc.getSelectedItem();
            String susername = userTxt.getText();
            String sname = nameTxt.getText();
            String spassword = passTxt.getText();
//            String smeter = meter.getText();
            try {
                ConnectionProv con = new ConnectionProv();
//                String sql = "insert into login values('"+smeter+"', '"susername"', '"+sname+"', '"spassword"', '"+atype+"')";

//                con.stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login().setVisible(true);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
