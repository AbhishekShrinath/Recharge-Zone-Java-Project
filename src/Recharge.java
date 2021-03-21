import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class Recharge extends JFrame implements ActionListener
{

	public Recharge()
	{
		super("RECHARGE ZONE");
	
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("recharge.jpg")));
		setLayout(new FlowLayout());
		JLabel l1=new JLabel();
		add(l1);


		JButton b1=new JButton("prepaid");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(b1);
		b1.setBounds(150,410,150,60);
		
		   ImageIcon i1=new ImageIcon("prepaid.PNG");
	       Image img=i1.getImage();
	       Image new_image=img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	       i1=new ImageIcon(new_image);
	       JLabel l2=new JLabel(i1);
	       l2.setBounds(130,105, 300, 300);
	       add(l2);

		
		JButton b2=new JButton("postpaid");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(b2);
		b2.setBounds(420,410,150,60);
		
		  ImageIcon i2=new ImageIcon("postpaid.PNG");
	       Image img2=i2.getImage();
	       Image new_image1=img2.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	       i2=new ImageIcon(new_image1);
	       JLabel l3=new JLabel(i2);
	       l3.setBounds(345, 110, 300,300);
	       add(l3);
		
		
		JButton b3=new JButton("DTH");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(b3);
		b3.setBounds(690,410,150,60);
		
		  ImageIcon i3=new ImageIcon("dth-512.PNG");
	       Image img3=i3.getImage();
	       Image new_image2=img3.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	       i3=new ImageIcon(new_image2);
	       JLabel l4=new JLabel(i3);
	       l4.setBounds(640,120, 300,300);
	       add(l4);
		
		JButton b4=new JButton("summary");
		b4.addActionListener(this);
		b4.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(b4);
		b4.setBounds(420,610,150,60);
		
		JButton b5=new JButton("logout");
		b5.addActionListener(this);
		b5.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(b5);
		b5.setBounds(800,30,150,60);
		setResizable(false); 
		setLayout(null);
		setSize(1000,900);
	      setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("prepaid"))
		{
				new Prepaid();
			
			this.dispose();
		}
		else if(s.equals("postpaid"))
		{
			
			this.dispose();
			
			new Postpaid();
		}
		else if(s.equals("DTH"))
		{
			new DTH();
			this.dispose();
		}
		else if(s.equals("summary"))
		{
			new Summary();
		}
		else if(s.equals("logout"))
		{
			new Home_page();
			this.dispose();
		}
		
	}

	
}
