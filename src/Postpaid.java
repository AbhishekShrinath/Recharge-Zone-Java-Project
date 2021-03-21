import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Postpaid extends JFrame implements ActionListener,KeyListener

{
	JTextField number;
	JTextField Amount;
	String opr[]= {"Select your operator","AIRTEL ","JIO ","VODAPONE ","IDEA ","MTNL","BSNL"};
	JComboBox operator;
	public Postpaid()
	{
		setTitle("POSTPAID ZONE");
		setSize(900,800);
		setBounds(200, 10, 900, 800);
		setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("POSTPAID ZONE...");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 44));
		lblNewLabel.setBounds(226, 60, 555, 55);
		add(lblNewLabel);
		
		number = new JTextField();
		number.setFont(new Font("Tahoma", Font.PLAIN, 25));
		number.addKeyListener(this);
		number.setBounds(285,290,180,40);
		add(number);
		
		
		Amount = new JTextField();
		Amount.setBounds(285,460,80,35);
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Amount.addKeyListener(this);
		add(Amount);
		
		JLabel lb = new JLabel("ENTER YOUR NUMBER");
		lb.setForeground(Color.white);
		lb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb.setBounds(285,250,250,30);
		add(lb);
		
		operator=new JComboBox(opr);
	    
		operator.setBounds(285,350,190,50);
		
		add(operator);
		
		JLabel lb1 = new JLabel("ENTER AMOUNT");
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lb1.setBounds(285,420,360,35);
		add(lb1);
		
		
		JButton pay = new JButton("PAY");
		pay.addActionListener(this);
		 pay.setFont(new Font("Tahoma", Font.BOLD, 17));
		pay.setBounds(285,520,150,60);
		add(pay);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,80));
		panel.setBounds(0, 36, 900, 96);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(104,0,104,80));
		panel_1.setBounds(220, 210, 390, 420);
		add(panel_1);
		
		 
		ImageIcon background_img=new ImageIcon("postpaidwallpaper.jpg");
		JLabel background=new JLabel("",background_img,JLabel.CENTER);
		Image bg_img=background_img.getImage();
		Image temp_img=bg_img.getScaledInstance(900,800,Image.SCALE_SMOOTH);
		background_img=new ImageIcon(temp_img);
		background.setBounds(0, 0,900,800);
		add(background);
		setResizable(false); 
	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("PAY"))
		{
			String num=number.getText().toString();
			String Amt=Amount.getText().toString();
			String chk=operator.getSelectedItem().toString();
			if(num.equals(""))
			{
				JOptionPane.showMessageDialog(null,"NUmber is mandotary");
			}
			else if(chk.equals("Select your operator"))
			{
				JOptionPane.showMessageDialog(null, "Select Operator");
			}
			else if(Amt.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Amount is mandotary");
			}
			
			else
			{
			String msg=number.getText();
			String msg1=(String)operator.getSelectedItem();
			String msg2=Amount.getText();
		
			new Payment(msg,msg1,msg2);
			this.dispose();
			}
		}

	}


	@Override
	public void keyPressed(KeyEvent ke) {
		if(ke.getSource()==number)
		{
		if(number.getText().length()>=10)
	    {
			number.setText(number.getText().substring(0,9));	
		  
	    } 
		int key=ke.getKeyCode();
		if((key>=ke.VK_0 && key<=ke.VK_9) || (key>=ke.VK_NUMPAD0 && key<=ke.VK_NUMPAD9) || (key==ke.VK_BACK_SPACE))
		{
			number.setEditable(true);
			number.setBackground(Color.green);
		}
		else
		{
			number.setEditable(false);
			number.setBackground(Color.red);
			JOptionPane.showMessageDialog(null,"NO CHARECTOR ALLOW");
		}
		}
		
		if(ke.getSource()==Amount)
		{
		if(Amount.getText().length()==5)
	    {
			Amount.setText(Amount.getText().substring(0,4));	
		  
	    } 
		int key1=ke.getKeyCode();
		if((key1>=ke.VK_0 && key1<=ke.VK_9) || (key1>=ke.VK_NUMPAD0 && key1<=ke.VK_NUMPAD9) || (key1==ke.VK_BACK_SPACE))
		{
			Amount.setEditable(true);
			Amount.setBackground(Color.green);
		}
		else
			{
			Amount.setEditable(false);
			Amount.setBackground(Color.red);
			JOptionPane.showMessageDialog(null,"NO CHARECTOR ALLOW");
			}
		} 
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
