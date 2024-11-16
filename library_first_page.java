import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class library_first_page
{
    public static void main()
    {
        Firstpage fp = new Firstpage();
    }
}

class Firstpage extends JFrame implements ActionListener
{
    JFrame f = new JFrame("National Library Dashboard");
    JLabel l1;
    JButton b1,b2,b3,b4;
    JMenuBar mb;
    JMenu fm,hm;
    JMenuItem li,si,ei;
    Firstpage()
    {
        l1 = new JLabel("Library Management System");
        l1.setBounds(140,25,500,100);
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setVerticalAlignment(JLabel.TOP);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1 = new JButton("Admin Login");
        b1.setBounds(190,250,150,40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("Employee Login");
        b2.setBounds(440,250,150,40);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Close");
        b3.setBounds(0,500,100,40);
        b3.addActionListener(this);
        b3.setFocusable(false);
        b4 = new JButton("TEST3");
        b4.setBounds(600,250,150,40);
        b4.setFocusable(false);
        
        mb = new JMenuBar();
        f.setJMenuBar(mb);
        
        fm = new JMenu("File");
        hm = new JMenu("Help");
        
        li = new JMenuItem("Load");
        si = new JMenuItem("Save");
        ei = new JMenuItem("Exit");
        
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        mb.add(fm);
        mb.add(hm);
        fm.add(li);
        fm.add(si);
        fm.add(ei);
        
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
            f.dispose();
            //progress ob1 = new progress();
            log ob = new log();
        }
        if(ae.getSource()==b2)
        {
            f.dispose();
            //progress ob1 = new progress();
            log1 ob = new log1();
        }
        if(ae.getSource()==b3)
        {
            f.dispose();
        }
    }
}