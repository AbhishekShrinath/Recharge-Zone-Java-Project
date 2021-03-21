import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.*;

import javax.swing.*;
public class Recharge_Summery extends JFrame implements ActionListener
{
	JLabel number,operator,amount,ptype,tran_id;
	
	JButton clickhere;
	
	Connection con;
	
	public Recharge_Summery(String msg,String msg2,String msg3,String msg4) throws ClassNotFoundException, SQLException
	{
		super("RECHARGE SUCCESSFULL...");
		
		setSize(550,400);
		setBounds(255, 150, 750, 600);
		setLayout(null);

		
		JLabel l1 =new JLabel("RECHARGE SUCCESSFULL");
		l1.setForeground(Color.red);
		l1.setBounds(90,10, 550,65);
		l1.setFont(new Font("Wide Latin", Font.ITALIC, 20));
		add(l1);
	//------------------------------------------	
		
		JLabel lbl=new JLabel("Tranction ID :");
		lbl.setBounds(280,100,100,10);
		add(lbl);
		tran_id=new JLabel();
		Random ran=new Random();
		int n=ran.nextInt(100000000)+1;
		String var=String.valueOf(n);
		tran_id.setBounds(365,100,100,10);
		tran_id.setText(var);
		add(tran_id);
	//------------------------------------------	
		JLabel lbl1=new JLabel("NUMBER :");
		lbl1.setBounds(300,130,100,10);
		add(lbl1);
		number=new JLabel();
		number.setBounds(365,130,100,10);
		add(number);
		number.setText(msg);
		
		JLabel lbl2=new JLabel("OPERATOR :");
		lbl2.setBounds(290,170,100,10);
		add(lbl2);
		operator=new JLabel();
		operator.setBounds(365,170,100,10);
		add(operator);
		operator.setText(msg2);

		JLabel lbl3=new JLabel("AMOUNT :");
		lbl3.setBounds(300,205,150,18);
		add(lbl3);
		amount=new JLabel();
		amount.setBounds(365,210,100,10);
		add(amount);
		amount.setText(msg3);
		

		JLabel lbl4=new JLabel("Payment Method :");
		lbl4.setBounds(260,245,150,18);
		add(lbl4);
		ptype=new JLabel();
		ptype.setBounds(365,250,100,10);
		ptype.setText(msg4);
		add(ptype);
		
		clickhere=new JButton("Clickhere");
		clickhere.setFont(new Font("time",Font.BOLD,22));
		clickhere.setBounds(255,300,210,55);
		clickhere.addActionListener(this);
		add(clickhere);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		panel.setBounds(155, 90, 400,300);
		add(panel);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false); 
	
		setVisible(true);
		
	
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rechargezone","root","abhishek");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==clickhere)
		{
			try {
				PreparedStatement ps1=con.prepareStatement("insert into summary values(?,?,?,?,?)");
				ps1.setString(1,tran_id.getText());            //tran_ID
			
				
				ps1.setString(2,number.getText());           //pnum
			
				
			
				ps1.setString(3,operator.getText());		//opr
				
				String s4=amount.getText();           	//amt
				int n4=Integer.parseInt(s4);
				ps1.setInt(4,n4);

				ps1.setString(5,ptype.getText());	//ptype
				
				int cnt=ps1.executeUpdate();
				System.out.println("Tranction sucessfull"+cnt);
				
				con.close();
			}
			
			catch(Exception xe)
			{
				xe.printStackTrace();
			}
			
			this.dispose();
			new Recharge();
			
		}

	}

}
