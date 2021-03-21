import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class Home_page extends JFrame implements ActionListener
{

	public Home_page()
	{
		super("Home Page");
		
		setSize(1000,700);
	      setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		JLabel l1 =new JLabel("Recharge Zone");
		l1.setFont(new Font("Wide Latin", Font.ITALIC, 35));
		l1.setForeground(Color.white);
		l1.setBounds(250,70,500,60);
		add(l1);

		JLabel label=new JLabel("ReCharge Zone");
		label.setBounds(630,570,300,28);
		label.setFont(new Font("Wide Latin", Font.ITALIC, 18));
		label.setForeground(Color.white);
		add(label);
		JLabel label1=new JLabel("Project by");
		label1.setBounds(630,595,310,28);
		label1.setFont(new Font("Wide Latin", Font.ITALIC, 18));
		label1.setForeground(Color.white);

		add(label1);
		JLabel label2=new JLabel("Abhishek Shrinath");
		label2.setBounds(625,620,380,28);
		label2.setFont(new Font("Wide Latin", Font.BOLD, 18));
		label2.setForeground(Color.white);

		add(label2);

		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0,0,0,80));
		panel1.setBounds(600,550,400,150);
		getContentPane().add(panel1);
		
		JButton b1=new JButton("LOGIN");
		b1.setBounds(780,180,80,50);
		b1.addActionListener(this);
		JButton b2=new JButton("SIGN UP");
		b2.setBounds(880,180,80,50);
		b2.addActionListener(this);
		add(b1);
		add(b2);

		
		setResizable(false); 
		setLayout(null);
		ImageIcon background_img1=new ImageIcon("recharge_tree.png");
		JLabel background1=new JLabel("",background_img1,JLabel.CENTER);
		Image bg_img1=background_img1.getImage();
		Image temp_img1=bg_img1.getScaledInstance(900,755,Image.SCALE_SMOOTH);
		background_img1=new ImageIcon(temp_img1);
		background1.setBounds(0, 0,900,755);
		add(background1);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,70));
		panel.setBounds(0, 45, 1000, 96);
		getContentPane().add(panel);
		 
		ImageIcon background_img=new ImageIcon("homepage.jpg");
		JLabel background=new JLabel("",background_img,JLabel.CENTER);
		Image bg_img=background_img.getImage();
		Image temp_img=bg_img.getScaledInstance(1000,690,Image.SCALE_SMOOTH);
		background_img=new ImageIcon(temp_img);
		background.setBounds(0, 0,1000,690);
		add(background);

		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String s=ae.getActionCommand();
		if(s.equals("LOGIN"))
		{
			
			
			try {
				new Login();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
		}
		else if(s.equals("SIGN UP"))
		{
			try {
				new Signup();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
		}
		
	}
	public static void main(String[] args)
	{
		new Home_page();

	}

}
