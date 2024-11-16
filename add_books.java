import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class add_books
{
    public static void main()
    {
        ab ob = new ab(1);
    }
}

class ab extends JFrame implements ActionListener
{
    JFrame f = new JFrame("Add Books");
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3,b4;
    JTextField t1,t2;
    int n1;
    ab(int n)
    {
        n1 = n;
        l1 = new JLabel("Add Books");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(300,50,300,100);
        l2 = new JLabel("Name:");
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setBounds(150,200,100,50);
        l3 = new JLabel("Quantity:");
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setBounds(150,300,150,50);
        
        t1 = new JTextField();
        t1.setFont(new Font("MV Boli",Font.PLAIN,20));
        t1.setBounds(300,200,400,35);
        t1.setText("");
        t2 = new JTextField();
        t2.setFont(new Font("MV Boli",Font.PLAIN,20));
        t2.setBounds(300,300,400,35);
        t2.setText("");
        
        b1 = new JButton("ADD");
        b1.setBounds(250,400,125,40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("RESET");
        b2.setBounds(400,400,125,40);
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
        if(ae.getSource()==b1)
        {
            int check=0;
            String a = '"'+t1.getText()+'"';
            String b = '"'+t2.getText()+'"';
            String a_ref = t1.getText();
            String d = t2.getText();
            
            try
            {
                String url = "jdbc:mysql://localhost:3306/library";
                String uname = "root";
                String pass = "iwillnottell";
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
        
                Statement st = con.createStatement();
                Statement st1= con.createStatement();
                ResultSet rs = st.executeQuery("select * from books;");
                
                while(rs.next())
                {
                    String n = rs.getString(1);
                    int q = rs.getInt(2);
                    int c = Integer.parseInt(t2.getText());
                    int k = c+q;
                    d = Integer.toString(k);
                    if(n.equalsIgnoreCase(a_ref))
                    {
                        //System.out.println(q+"  "+c+"  "+k+"  "+d);
                        int count = st1.executeUpdate("update books set qty="+d+" where bname="+a+";");
                        check++;
                    }
                }
                if(check==0)
                {
                    int count = st1.executeUpdate("insert into books values ("+a+","+b+")");
                }
                JOptionPane.showMessageDialog(f, "Book Added Successfully!");
                
                st.close();
                con.close();
                f.dispose();
                dash1 ob = new dash1();
            }
            catch(Exception e)
            {
                System.out.println(e);
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