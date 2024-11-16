import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.time.format.*;
import java.text.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class issue_books
{
    public static void main()
    {
        ib ob = new ib(1);
    }
}

class ib extends JFrame implements ActionListener
{
    JFrame f = new JFrame("Issue Books");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2;
    JButton b1,b2,b3,b4; 
    int serial=0, n1;
    ib(int n)
    {
        n1 = n;
        l1 = new JLabel("Issue Books");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(300,50,300,100);
        l2 = new JLabel("Issue-no.:");
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setBounds(150,250,100,50);
        l3 = new JLabel("");
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setBounds(250,250,150,50);
        l4 = new JLabel("Date:");
        l4.setFont(new Font("MV Boli",Font.PLAIN,20));
        l4.setBounds(475,250,150,50);
        l5 = new JLabel("");
        l5.setFont(new Font("MV Boli",Font.PLAIN,20));
        l5.setBounds(550,250,150,50);
        l6 = new JLabel("Name(Book):");
        l6.setFont(new Font("MV Boli",Font.PLAIN,20));
        l6.setBounds(150,325,150,50);
        l7 = new JLabel("Name(Student):");
        l7.setFont(new Font("MV Boli",Font.PLAIN,20));
        l7.setBounds(150,400,200,50);
        
        serial = (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);
        l3.setText(Integer.toString(serial));
        
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate = formatter.format(date);  
        l5.setText(strDate); 
        
        t1 = new JTextField();
        t1.setFont(new Font("MV Boli",Font.PLAIN,20));
        t1.setBounds(315,330,400,35);
        t2 = new JTextField();
        t2.setFont(new Font("MV Boli",Font.PLAIN,20));
        t2.setBounds(315,405,400,35);
        
        b1 = new JButton("ISSUE");
        b1.setBounds(250,475,125,40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("RESET");
        b2.setBounds(400,475,125,40);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Back");
        b3.setBounds(0,700,100,40);
        b3.setFocusable(false);
        b3.addActionListener(this);
        b4 = new JButton();
        
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(t1);
        f.add(t2);
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
            int a = serial;
            int flag=0, flag1=0;
            String b = '"'+l5.getText()+'"';
            String c = '"'+"Not Returned"+'"';
            String d = '"'+t1.getText()+'"';
            String e = '"'+t2.getText()+'"';
            
            try
            {
                String url = "jdbc:mysql://localhost:3306/library";
                String uname = "root";
                String pass = "iwillnottell";
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
                
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from students;");
                while(rs.next())
                {
                    String ch = rs.getString(2);
                    if(t2.getText().equalsIgnoreCase(ch))
                    {
                        flag++;
                    }
                }
                if(flag==0)
                {
                    JOptionPane.showMessageDialog(f, "Unidentified Student!", "Issue Error", JOptionPane.ERROR_MESSAGE);
                    break inn;
                }
                
                
                ResultSet rs1 = st.executeQuery("select * from books;");
                while(rs1.next())
                {
                    String ch = rs1.getString(1);
                    if(t1.getText().equalsIgnoreCase(ch))
                    {
                        flag1++;
                    }
                }
                if(flag1==0)
                {
                    JOptionPane.showMessageDialog(f, "Book Unavailable!", "Issue Error", JOptionPane.ERROR_MESSAGE);
                    break inn;
                }
                st.close();
                
            
                Statement st2 = con.createStatement();
                int count = st2.executeUpdate("insert into books_issued values ("+a+","+b+","+c+","+d+","+e+")");
                
                JOptionPane.showMessageDialog(f, "Book Issued Successfully!");
        
                st2.close();
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
            t1.setText("");
            t2.setText("");
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
            if(n1==1)
            {
                dash1 ob = new dash1();
            }
            else
            {
                dash ob = new dash();
            }
        }
    }
}