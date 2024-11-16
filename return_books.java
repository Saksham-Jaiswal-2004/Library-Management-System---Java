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
public class return_books
{
    public static void main()
    {
        rb ob = new rb(1);
    }
}

class rb extends JFrame implements ActionListener
{
    JFrame f = new JFrame("Return Books");
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3,b4; 
    int n1;
    rb(int n)
    {
        n1 = n;
        l1 = new JLabel("Return Books");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(300,50,300,100);
        l2 = new JLabel("Issue-no.:");
        l2.setFont(new Font("MV Boli",Font.PLAIN,20));
        l2.setBounds(150,250,100,50);
        l3 = new JLabel("Issue Date:");
        l3.setFont(new Font("MV Boli",Font.PLAIN,20));
        l3.setBounds(150,325,150,50);
        l4 = new JLabel("Return Date:");
        l4.setFont(new Font("MV Boli",Font.PLAIN,20));
        l4.setBounds(450,325,150,50);
        l5 = new JLabel("");
        l5.setFont(new Font("MV Boli",Font.PLAIN,20));
        l5.setBounds(600,325,150,50);
        l6 = new JLabel("Name(Book):");
        l6.setFont(new Font("MV Boli",Font.PLAIN,20));
        l6.setBounds(150,400,150,50);
        l7 = new JLabel("Name(Student):");
        l7.setFont(new Font("MV Boli",Font.PLAIN,20));
        l7.setBounds(150,475,200,50);
        
        //int serial = (int)Math.floor(Math.random()*(999999999-100000000+1)+100000000);
        //l3.setText(Integer.toString(serial));
        
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate = formatter.format(date);  
        l5.setText(strDate); 
        
        t1 = new JTextField();
        t1.setFont(new Font("MV Boli",Font.PLAIN,20));
        t1.setBounds(250,260,150,30);
        t2 = new JTextField();
        t2.setFont(new Font("MV Boli",Font.PLAIN,20));
        t2.setBounds(275,335,150,30);
        t3 = new JTextField();
        t3.setFont(new Font("MV Boli",Font.PLAIN,20));
        t3.setBounds(315,405,400,35);
        t4 = new JTextField();
        t4.setFont(new Font("MV Boli",Font.PLAIN,20));
        t4.setBounds(315,480,400,35);
        
        b1 = new JButton("RETURN");
        b1.setBounds(250,550,125,40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("RESET");
        b2.setBounds(400,550,125,40);
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
        f.add(t3);
        f.add(t4);
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
            String a = '"'+t1.getText()+'"';
            String b = '"'+t2.getText()+'"';
            String c = '"'+t3.getText()+'"';
            String d = '"'+t4.getText()+'"';
            String e = '"'+l5.getText()+'"';
            //if(a.equals("") || b.equals("") || c.equals("") || d.equals(""))
            //{
                //JOptionPane.showMessageDialog(f, "Fill all login details!", "Error", JOptionPane.ERROR_MESSAGE);
               // break inn;
            //}
            //long day=0;
            //String dateStart = t2.getText();
            //String dateStop = l5.getText();

            //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

            //Date d1 = null;
            //Date d2 = null;
            //try {
                   //d1 = format.parse(dateStart);
                   //d2 = format.parse(dateStop);
                //} catch (ParseException e) {
                       // e.printStackTrace();
            //}
            //long diff = d2.getTime() - d1.getTime();
            //long diffHours = diff / (60*60*1000);
            //day = diffHours/24;
            
            //f.dispose();
            //System.out.println("Issue-no : "+t1.getText());
            //System.out.println("Issue Date : "+t2.getText());
            //System.out.println("Return Date : "+l5.getText());
            //System.out.println("Number of days : "+day);
            //System.out.println("Book Returned : "+t3.getText());
            //System.out.println("Student : "+t4.getText());
            
            
            
            
            int check=0;
            //int a = serial;
            //String b = '"'+l5.getText()+'"';
            //String c = '"'+"Not Returned"+'"';
            //String d = '"'+t1.getText()+'"';
            //String e = '"'+t2.getText()+'"';
            
            try
            {
                String url = "jdbc:mysql://localhost:3306/library";
                String uname = "root";
                String pass = "iwillnottell";
        
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
        
                Statement st = con.createStatement();
                int count = st.executeUpdate("update books_issued set rdate="+e+" where ino="+a);
                
                JOptionPane.showMessageDialog(f, "Book Returned Successfully!");
        
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
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
            if(n1==1)
            {
                f.dispose();
                dash1 ob = new dash1();
            }
            else
            {
                f.dispose();
                dash ob = new dash();
            }
        }
    }
}