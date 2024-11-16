import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
public class stats
{
    public static void main()
    {
        st ob = new st(1,1);
    }
}

class st extends JFrame implements ActionListener
{
    JFrame f = new JFrame("Statistics");
    JLabel l1,l2,l3,l4,l5;
    JPanel p = new JPanel();
    JButton b1,b2,b3;
    JTable jt;
    JScrollPane sp;
    int n1;
    int k1;
    st(int n, int k)
    {
        n1 = n;
        k1 = k;
        l1 = new JLabel("Statistics");
        l1.setFont(new Font("MV Boli",Font.PLAIN,30));
        l1.setBounds(330,50,300,100);
        
        int order=25,i=0,j;
        
        String columns[] = {"Issue-no.","Issue Date","Return Date", "Book Issued","Issued to"};
        String datas[][] = new String[order][5];
        
        try
        {
            String url = "jdbc:mysql://localhost:3306/library";
            String uname = "root";
            String pass = "iwillnottell";
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books_issued");
            rs.next();
            for(i=0 ; i<order ; i++)
            {
                if(i>=(k-1))
                {
                    for(j=0 ; j<5 ; j++)
                    {
                        String a = rs.getString(1);
                        String b = rs.getString(2);
                        String c = rs.getString(3);
                        String d = rs.getString(4);
                        String e = rs.getString(5);
                        if(j==0)
                        {
                            datas[i][j] = a;
                        }
                        if(j==1)
                        {
                            datas[i][j] = b;
                        }
                        if(j==2)
                        {
                            datas[i][j] = c;
                        }
                        if(j==3)
                        {
                            datas[i][j] = d;
                        }
                        if(j==4)
                        {
                            datas[i][j] = e;
                        }
                    }
                }
                rs.next();
            }
        
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }
                
        jt=new JTable(datas,columns);    
        jt.setBounds(100,160,800,600);  
        
        //cellRenderer = new DefaultTableCellRenderer();
        //cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        //jt.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        
        jt.setFont(new Font("MV Boli",Font.PLAIN,12));
        
        sp=new JScrollPane(jt); 
        
        l2 = new JLabel();
        p.setBounds(0,150,800,450);
        p.add(sp);
        //p.setBackground(Color.RED);
        
        b1 = new JButton("←");
        b1.setBounds(200,625,75,30);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b2 = new JButton("→");
        b2.setBounds(500,625,75,30);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b3 = new JButton("Back");
        b3.setBounds(0,700,100,40);
        b3.setFocusable(false);
        b3.addActionListener(this);
        
        if(k1==1)
        {
            b1.setEnabled(false);
        }
        
        f.add(l1);
        f.add(p);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(l2);
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
            st ob = new st(n1,k1-25);
        }
        if(ae.getSource()==b2)
        {
            f.dispose();
            st ob = new st(n1,k1+25);
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