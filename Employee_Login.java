import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
public class Employee_Login
{
    public static void main()
    {
        log1 ob = new log1();
    }
}

class log1 extends JFrame implements ActionListener
{
    JFrame f = new JFrame("National Library Admin Login");
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4;
    JTextField f1;
    JPasswordField p1;
    log1()
    {
        l1 = new JLabel("EMPLOYEE LOGIN");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(300,50,300,100);
        l2 = new JLabel("Username:");
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setBounds(150,250,100,50);
        l3 = new JLabel("Password:");
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setBounds(150,350,100,50);
        
        f1 = new JTextField();
        f1.setFont(new Font("MV Boli",Font.PLAIN,20));
        f1.setBounds(275,250,400,40);
        
        p1 = new JPasswordField("");
        p1.setFont(new Font("MV Boli",Font.PLAIN,20));
        p1.setBounds(275,350,400,40);
        
        b1 = new JButton("LOGIN");
        b1.setBounds(250,450,125,30);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("RESET");
        b2.setBounds(400,450,125,30);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Back");
        b3.setBounds(0,500,100,40);
        b3.addActionListener(this);
        b3.setFocusable(false);
        b4 = new JButton("");
        b4.setBounds(50,50,50,50);
        b4.setFocusable(false);
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(f1);
        f.add(p1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setVisible(true);
        f.setSize(800,600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            int check=0;
            String a = f1.getText();
            String b = p1.getText();
            
            try
            {
                String url = "jdbc:mysql://localhost:3306/library";
                String uname = "root";
                String pass = "iwillnottell";
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
        
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from employees");
                
                while(rs.next())
                {
                    String name = rs.getString(1);
                    String pw = rs.getString(5);
                    if(a.equalsIgnoreCase(name) && b.equals(pw))
                    {
                        f.dispose();
                        check++;
                        dash ob = new dash();
                    }
                }
        
                if(check==0)
                {
                    JOptionPane.showMessageDialog(f, "Wrong login details!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
        
                st.close();
                con.close();
            }
            catch(Exception e)
            {
                //System.out.println(e);
            }
        }
        if(ae.getSource()==b2)
        {
            f1.setText("");
            p1.setText("");
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
            Firstpage ob = new Firstpage();
        }
    }
}