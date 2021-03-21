import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login extends JFrame implements ActionListener
{
	JPanel contentPane;
	JTextField username;
	JPasswordField password;
	JButton b1;
	
	JButton login;
	
	Connection con;
	
	public Login() throws ClassNotFoundException, SQLException
	{
		super("LOGIN..");
		
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			getContentPane().setLayout(null);
			contentPane.setLayout(null);
			
			login = new JButton("Login");
			login.setActionCommand("Login");
			login.addActionListener(this);
			login.setFont(new Font("Tahoma", Font.BOLD, 17));
			login.setForeground(Color.BLACK);
			login.setBounds(397, 450, 99, 43);
			contentPane.add(login);
			
			username = new JTextField();
			username.setBounds(400, 238, 255, 43);
			
			username.setFont(new Font("Tahoma", Font.BOLD, 19));
			add(username);
						
			password = new JPasswordField();
			password.setBounds(400, 358, 255, 43);
			password.setFont(new Font("Tahoma", Font.BOLD, 19));
			contentPane.add(password);
			
			b1 = new JButton("signup");
			b1.addActionListener(this);
			b1.setBounds(557, 450, 99, 43);
			b1.setFont(new Font("Tahoma", Font.BOLD, 17));
			contentPane.add(b1);
			
			JLabel lblNewLabel = new JLabel("Login page");
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC , 59));
			lblNewLabel.setBounds(330, 30, 499, 110);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Enter User Name");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(400, 190, 299, 53);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Enter Password");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_2.setBounds(400, 310, 299, 53);
			contentPane.add(lblNewLabel_2);
			
			
			
			JPanel panel1 = new JPanel();
			panel1.setBackground(new Color(255,255,255,90));
			panel1.setBounds(330,190,400,400);
			add(panel1);
			
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(102, 0, 102,90));
			panel2.setBounds(0,50,1000,90);
			add(panel2);
			
			setSize(1000,720);
		    setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

			ImageIcon background_img=new ImageIcon("login.jpg");
			JLabel background=new JLabel("",background_img,JLabel.CENTER);
			Image bg_img=background_img.getImage();
			Image temp_img=bg_img.getScaledInstance(1000,720,Image.SCALE_SMOOTH);
			background_img=new ImageIcon(temp_img);
			background.setBounds(0, 0,1000,720);
			add(background);
			setResizable(false); 
			setLayout(null);
			setVisible(true);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rechargezone","root","abhishek");
			

	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	
		  if (ae.getSource()==login)
		  {
			  try 
			  {
				PreparedStatement ps1 = con.prepareStatement("select * from login where username=? AND password=?");
				ps1.setString(1,username.getText());
					
				ps1.setString(2,password.getText());
				

				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
				  this.dispose();
				  new Recharge();
				  con.close();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.INFORMATION_MESSAGE);

				}
				
				}
				
				catch(Exception xe)
				{
					xe.printStackTrace();
				}
   		  }
		  
		  else if(ae.getSource()==b1)
		  {
			  this.dispose();
			  try {
				new Signup();
			} 
			  catch (ClassNotFoundException e) 
			  {
				  e.printStackTrace();
			  }
			  catch (SQLException e) 
			  {
				  e.printStackTrace();
			  }
		  }

	}

}
