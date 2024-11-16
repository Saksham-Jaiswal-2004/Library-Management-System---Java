import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
public class Add_Employee
{
    public static void main()
    {
        sign ob = new sign(1);
    }
}

class sign extends JFrame implements ActionListener
{
    JFrame f = new JFrame("National Library Add Employee");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2,b3,b4;
    JTextField f1,f2,f3;
    JPasswordField p1,p2;
    JRadioButton r1,r2,r3;
    int n1;
    sign(int n)
    {
        n1 = n;
        l1 = new JLabel("ADD EMPLOYEE");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(300,50,300,100);
        l2 = new JLabel("Username:");
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setBounds(150,250,100,50);
        l3 = new JLabel("Phone-no.:");
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setBounds(150,325,120,50);
        l4 = new JLabel("Age:");
        l4.setFont(new Font("MV Boli",Font.PLAIN,20));
        l4.setBounds(150,400,80,50);
        l5 = new JLabel("Gender:");
        l5.setFont(new Font("MV Boli",Font.PLAIN,20));
        l5.setBounds(350,400,100,50);
        l6 = new JLabel("Password:");
        l6.setFont(new Font("MV Boli",Font.PLAIN,20));
        l6.setBounds(150,475,100,50);
        l7 = new JLabel("Confirm-Password:");
        l7.setFont(new Font("MV Boli",Font.PLAIN,20));
        l7.setBounds(150,550,180,50);
        
        f1 = new JTextField();
        f1.setFont(new Font("MV Boli",Font.PLAIN,20));
        f1.setBounds(275,255,400,30);
        f2 = new JTextField();
        f2.setFont(new Font("MV Boli",Font.PLAIN,20));
        f2.setBounds(275,335,400,30);
        f3 = new JTextField();
        f3.setFont(new Font("MV Boli",Font.PLAIN,20));
        f3.setBounds(200,410,80,30);
        
        p1 = new JPasswordField();
        p1.setFont(new Font("MV Boli",Font.PLAIN,20));
        p1.setBounds(275,485,400,30);
        p2 = new JPasswordField();
        p2.setFont(new Font("MV Boli",Font.PLAIN,20));
        p2.setBounds(350,560,400,30);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(450,400,100,50);
        r2 = new JRadioButton("Female");
        r2.setBounds(550,400,100,50);
        r3 = new JRadioButton("");
        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        b1 = new JButton("ADD");
        b1.setBounds(250,650,125,30);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("RESET");
        b2.setBounds(400,650,125,30);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Back");
        b3.setBounds(0,700,100,40);
        b3.setFocusable(false);
        b3.addActionListener(this);
        b4 = new JButton("");
        b4.setBounds(50,50,50,50);
        b4.setFocusable(false);
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(f1);
        f.add(f2);
        f.add(f3);
        f.add(p1);
        f.add(p2);
        f.add(r1);
        f.add(r2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setVisible(true);
        f.setSize(800,800);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
        inn: if(ae.getSource()==b1)
        {
            int check=0;
            String a = f1.getText();
            String b = f2.getText();
            String c = f3.getText();
            String d = p1.getText();
            String e = p2.getText();
            String g = "";
            
            if(a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals(""))
            {
                JOptionPane.showMessageDialog(f, "Enter all details!", "Add Error", JOptionPane.ERROR_MESSAGE);
                break inn;
            }
            else if(r1.isSelected()==false && r2.isSelected()==false)
            {
                JOptionPane.showMessageDialog(f, "Select Gender", "Add Error", JOptionPane.ERROR_MESSAGE);
                break inn;
            }
            if(d.equals(e)==false)
            {
                JOptionPane.showMessageDialog(f, "Both passwords do not match!", "Add Error", JOptionPane.ERROR_MESSAGE);
                break inn;
            }
            
            a = '"'+a+'"';
            d = '"'+d+'"';
            if(r1.isSelected())
            {
                g = "Male";
            }
            if(r2.isSelected())
            {
                g = "Female";
            }
            g = '"'+g+'"';
            
            try
            {
                String url = "jdbc:mysql://localhost:3306/library";
                String uname = "root";
                String pass = "iwillnottell";
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
        
                Statement st = con.createStatement();
                int count = st.executeUpdate("insert into employees values ("+a+","+b+","+c+","+g+","+d+")");
                
                JOptionPane.showMessageDialog(f, "Employee Added Successfully!");
        
                st.close();
                con.close();
                f.dispose();
                dash1 ob = new dash1();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        if(ae.getSource()==b2)
        {
            f1.setText("");
            f2.setText("");
            f3.setText("");
            p1.setText("");
            p2.setText("");
            r3.setSelected(true);
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
            dash1 ob = new dash1();
        }
    }
}