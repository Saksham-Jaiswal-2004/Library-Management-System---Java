import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class admin_dashboard
{
    public static void main()
    {
        dash1 ob = new dash1();
    }
}

class dash1 extends JFrame implements ActionListener
{
    JFrame f = new JFrame("National Library Admin Dashboard");
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    dash1()
    {
        l1 = new JLabel("National Library Admin Console");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(125,50,500,100);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1 = new JButton("New Student");
        b1.setBounds(150,250,200,50);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("Statistics");
        b2.setBounds(150,350,200,50);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Inventory");
        b3.setBounds(150,450,200,50);
        b3.setFocusable(false);
        b3.addActionListener(this);
        b4 = new JButton("Add Books");
        b4.setBounds(400,250,200,50);
        b4.setFocusable(false);
        b4.addActionListener(this);
        b5 = new JButton("Return Books");
        b5.setBounds(400,350,200,50);
        b5.setFocusable(false);
        b5.addActionListener(this);
        b6 = new JButton("Issue Books");
        b6.setBounds(400,450,200,50);
        b6.setFocusable(false);
        b6.addActionListener(this);
        b7 = new JButton("Add Employee");
        b7.setBounds(150,550,200,50);
        b7.setFocusable(false);
        b7.addActionListener(this);
        b8 = new JButton("Employee Details");
        b8.setBounds(400,550,200,50);
        b8.setFocusable(false);
        b8.addActionListener(this);
        b9 = new JButton("Student Details");
        b9.setBounds(275,650,200,50);
        b9.setFocusable(false);
        b9.addActionListener(this);
        b10 = new JButton("Log-out");
        b10.setBounds(0,700,100,40);
        b10.setFocusable(false);
        b10.addActionListener(this);
        b11 = new JButton("");
        b11.setBounds(50,50,50,50);
        b11.setFocusable(false);
        
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
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
            f.dispose();
            ns ob = new ns(1);
        }
        if(ae.getSource()==b2)
        {
            f.dispose();
            st ob = new st(1,1);
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
            in ob = new in(1,1);
        }
        if(ae.getSource()==b4)
        {
            f.dispose();
            ab ob = new ab(1);
        }
        if(ae.getSource()==b5)
        {
            f.dispose();
            rb ob = new rb(1);
        }
        if(ae.getSource()==b6)
        {
            f.dispose();
            ib ob = new ib(1);
        }
        if(ae.getSource()==b7)
        {
            f.dispose();
            sign ob = new sign(1);
        }
        if(ae.getSource()==b8)
        {
            f.dispose();
            ed ob = new ed(1,1);
        }
        if(ae.getSource()==b9)
        {
            f.dispose();
            sd ob = new sd(1,1);
        }
        if(ae.getSource()==b10)
        {
            f.dispose();
            Firstpage ob = new Firstpage();
        }
    }
}