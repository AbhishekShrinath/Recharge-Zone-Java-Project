import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener,KeyListener
{
	JTextField username;
	JTextField email;
	JTextField phonenumber;
	JPasswordField passwordField;
	JCheckBox term;
	JButton submit,reset,home;
	JLabel res;
	JRadioButton male,female;
	ButtonGroup btngp;
	
	Connection con;
	
	public Signup() throws ClassNotFoundException, SQLException
	{
		setSize(840,800);
		setBounds(222, 10, 840, 800);
		setLayout(null);
		JLabel jb=new JLabel("SIGN UP..");
		jb.setForeground(Color.white);
		jb.setFont(new Font("Wide Latin", Font.ITALIC, 35));
		jb.setBounds(200,98,340,47);
		add(jb);
	
		username = new JTextField();
		username.setBounds(288, 205, 176, 36);
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(username);
		
	
		email = new JTextField();
		
		email.setColumns(10);
		email.setBounds(288, 270, 176, 36);
		email.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(email);
	
		phonenumber = new JTextField();
		phonenumber.setColumns(10);
		phonenumber.setBounds(288, 336, 176, 36);
		phonenumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		phonenumber.addKeyListener(this);
		add(phonenumber);
	
		male = new JRadioButton("MALE");
		male.setBounds(289, 453, 90, 31);
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		male.setSelected(true); 
		add(male);
	
		female = new JRadioButton("FEMALE");
		female.setBounds(401, 453, 100, 31);
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(female);
		
		btngp = new ButtonGroup(); 
		btngp.add(male); 
		btngp.add(female);
	
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(183, 198, 136, 36);
		add(lblNewLabel);
	
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.white);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBounds(223, 270, 85, 36);
		add(lblEmail);
	
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.white);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPhoneNumber.setBounds(130, 334, 159, 36);
		add(lblPhoneNumber);
	
		passwordField = new JPasswordField();
		passwordField.setBounds(288, 406, 176, 36);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(passwordField);
	
		JLabel lblPassword = new JLabel("Enter PassWord");
		lblPassword.setForeground(Color.white);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(130, 406, 159, 36);
		add(lblPassword);
	
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Tahoma", Font.BOLD, 19));
		submit.addActionListener(this);
		submit.setBounds(289, 539, 125, 57);
		add(submit);
		
		reset = new JButton("RESET");
		reset.setFont(new Font("Tahoma", Font.BOLD, 19));
		reset.setBounds(454, 539, 125, 57);
		reset.addActionListener(this);
		add(reset);
		
		term = new JCheckBox("Term and condition");
		term.setFont(new Font("Arial", Font.BOLD, 15));
		term.setBounds(290, 499, 177, 36);
		add(term);
		
		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setForeground(Color.white);
		res.setLocation(219, 620); 
		add(res);
		
		home = new JButton("HOME");
		home.setFont(new Font("Tahoma", Font.BOLD, 22));
		home.setBounds(650,30, 140, 57);
		home.addActionListener(this);
		add(home);
		
		ImageIcon background_img=new ImageIcon("signup.jpg");
		JLabel background=new JLabel("",background_img,JLabel.CENTER);
		Image bg_img=background_img.getImage();
		Image temp_img=bg_img.getScaledInstance(840,800,Image.SCALE_SMOOTH);
		background_img=new ImageIcon(temp_img);
		background.setBounds(0, 0,840,800);
		add(background);
		
	
		
		
		setResizable(false); 
		setVisible(true);
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rechargezone","root","abhishek");
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if (e.getSource()==submit)
		{ 
		
			if(term.isSelected()) 
			{
				String user=username.getText().toString();
				
				String email_patt="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com))+$";
				Pattern patn=Pattern.compile(email_patt);
				Matcher regexmatch=patn.matcher(email.getText());
				
				String p_num=phonenumber.getText().toString();
				String pass=passwordField.getText().toString();
			if(user.equals(""))
			{
				JOptionPane.showMessageDialog(null,"username is Mandotory");
			}
			else if(!regexmatch.matches())
			{
				JOptionPane.showMessageDialog(null,"Email format (example@gmail.com)");
			}
			
			else if(p_num.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Phone Number");
			}
			
			else if(pass.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Password is Mandotary");
			}
			
			else
			{ 
				
			try {
					PreparedStatement ps1=con.prepareStatement("insert into login values(?,?)");
					ps1.setString(1,username.getText());
					
					ps1.setString(2,passwordField.getText());
					
					int cnt=ps1.executeUpdate();
					System.out.println("signup sucessfull"+cnt);
					
					con.close();
				}
				
				catch(Exception xe)
				{
					xe.printStackTrace();
				}

				this.dispose();
				try {
					new Login();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}	
			else
			{
				res.setText("Please accept the terms & conditions..");
			}

		}	
		else if (s.equals("RESET")) 
		{ 
			String def = ""; 
			username.setText(def); 
			email.setText(def); 
			phonenumber.setText(def); 
			passwordField.setText(def);
			res.setText(def); 
			term.setSelected(false);
		}
		else if(s.equals("HOME"))
		{
			new Home_page();
			this.dispose();
		}
	
		
	}

	@Override
	public void keyPressed(KeyEvent ke) 
	{
	if(phonenumber.getText().length()>=10)
	    {
		  phonenumber.setText(phonenumber.getText().substring(0,9));	
		  
	    } 
		int key=ke.getKeyCode();
		if((key>=ke.VK_0 && key<=ke.VK_9) || (key>=ke.VK_NUMPAD0 && key<=ke.VK_NUMPAD9) || (key==ke.VK_BACK_SPACE))
		{
			phonenumber.setEditable(true);
			phonenumber.setBackground(Color.green);
		}
		else
			{
				phonenumber.setEditable(false);
				phonenumber.setBackground(Color.red);
				JOptionPane.showMessageDialog(null,"NO CHARECTOR ALLOW");
			}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
