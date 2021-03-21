import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.*;

public class Payment extends JFrame implements ActionListener,KeyListener
{
	JTextField textField;
	JTextField textField_1,gtext;
	JTextField txtCvv;
	JLabel l1,l2,l3;
	JButton btnNewButton;
	JRadioButton debit,credit,gpay;
	ButtonGroup bgp;
	JComboBox month,year;


	public Payment(String msg,String msg1,String msg2)
	{
		setType(Type.POPUP);
		setSize(800,900);
	      setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		setLayout(null);
		
		
		
		JLabel lb1=new JLabel("NUMBER   =");
		lb1.setBounds(255,150,100,10);
		add(lb1);
		l1=new JLabel();
		l1.setBounds(335,150,100,10);
		add(l1);
		l1.setText(msg);
		
		JLabel lb2=new JLabel("OPERATOR =");
		lb2.setBounds(250,170,100,10);
		add(lb2);
		l2=new JLabel();
		l2.setBounds(335,170,100,10);
		add(l2);
		l2.setText(msg1);

		JLabel lb3=new JLabel("AMOUNT    = Rs");
		lb3.setBounds(250,190,100,10);
		add(lb3);
		l3=new JLabel();
		l3.setBounds(340,190,100,10);
		add(l3);
		l3.setText(msg2);
		
		
		JLabel lblNewLabel = new JLabel("Select Your Pament Methrd");
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(245, 210, 265,55);
		add(lblNewLabel);
		
		debit = new JRadioButton("Debit Card");
		debit.setFont(new Font("Tahoma", Font.BOLD, 15));
		debit.setSelected(true);
		debit.setActionCommand("Debit Card");
		debit.setBounds(250, 260, 105, 23);
		add(debit);
		
		credit = new JRadioButton("Credit Card");
		credit.setFont(new Font("Tahoma", Font.BOLD, 15));
		credit.setBounds(375, 260, 111, 23);
		credit.setActionCommand("Credit Card");
		add(credit);

		
		JLabel cardname = new JLabel("CARD HOLDER NAME");
		cardname.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		cardname.setBounds(250, 290, 255, 55);
		add(cardname);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(250, 340, 240, 50);
		
		add(textField);
		textField.setColumns(10);
		
		JLabel cardnum = new JLabel("ENTER CARD DETAILS");
		
		cardnum.setFont(new Font("Tahoma", Font.BOLD, 18));
		cardnum.setBounds(250, 390, 255, 55);
		add(cardnum);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(250, 440, 240, 50);
		textField_1.addKeyListener(this);
		add(textField_1);
		
		JLabel cvv=new JLabel("CVV");
		cvv.setBounds(430, 530, 90, 20);
		cvv.setFont(new Font("Tahoma",Font.BOLD,16));
		cvv.setForeground(Color.white);
		add(cvv);
		
		txtCvv = new JTextField();
		txtCvv.setBounds(430, 550, 58, 32);
		txtCvv.addKeyListener(this);
		add(txtCvv);
		txtCvv.setColumns(10);
		
		JLabel mmyy=new JLabel("Expiry/Validity Date");
		mmyy.setBounds(250, 530, 190, 20);
		mmyy.setFont(new Font("Tahoma",Font.BOLD,16));
		mmyy.setForeground(Color.white);
		add(mmyy);
		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month.setBounds(250, 550, 43, 32);
		add(month);
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"", "2021", "2022", "2023", "2024", "2025", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
		year.setBounds(290, 550, 70, 32);
		add(year);

		bgp=new ButtonGroup();
		bgp.add(debit);
		bgp.add(credit);

		
		btnNewButton = new JButton("PAY");
		btnNewButton.setBounds(250, 600, 225, 50);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.addActionListener(this);
		add(btnNewButton);
	 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,80));
		panel.setBounds(200, 110, 390,559);
		add(panel);
		
		ImageIcon background_img=new ImageIcon("payment.png");
		JLabel background=new JLabel("",background_img,JLabel.CENTER);
		Image bg_img=background_img.getImage();
		Image temp_img=bg_img.getScaledInstance(800,900,Image.SCALE_SMOOTH);
		background_img=new ImageIcon(temp_img);
		background.setBounds(0, 0,800,900);
		add(background);
		setResizable(false); 
		setVisible(true);
	

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{

	if(ae.getSource()==btnNewButton)
	{

	
		String name=textField.getText().toString();
		String c_num=textField_1.getText().toString();
		String cv=txtCvv.getText().toString();
		String cmb=month.getSelectedItem().toString();
		String cmb1=year.getSelectedItem().toString();
		int res1= JOptionPane.showConfirmDialog(this,"Press YES for ConFirm or NO","CONFIRM PAyment",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);	

		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null,"card name is mandotary");
		}
		else if(c_num.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Cars number is mandotary");
		}
		else if(cmb1.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Select YEAAR!");
		}
		else if(cmb.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Select MONTH!");
		}
		else if(cv.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Enter CVV");
		}
		else if(res1==JOptionPane.YES_OPTION)
		{
					
				String msg=l1.getText();
				String msg2=l2.getText();
				String msg3=l3.getText();
			
				String msg4=bgp.getSelection().getActionCommand();
				
				this.dispose();
				try {
					new Recharge_Summery(msg,msg2,msg3,msg4);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}
}

	@Override
	public void keyPressed(KeyEvent ke) 
	{
		if(ke.getSource()==textField_1)
		{
		if(textField_1.getText().length()>=16)
	    {
			textField_1.setText(textField_1.getText().substring(0,15));	
		  
	    } 
		int key=ke.getKeyCode();
		if((key>=ke.VK_0 && key<=ke.VK_9) || (key>=ke.VK_NUMPAD0 && key<=ke.VK_NUMPAD9) || (key==ke.VK_BACK_SPACE))
		{
			textField_1.setEditable(true);
			textField_1.setBackground(Color.green);
		}
		else
		{
			textField_1.setEditable(false);
			textField_1.setBackground(Color.red);
			JOptionPane.showMessageDialog(null,"NO CHARECTOR ALLOW");
		}
		}
		
		if(ke.getSource()==txtCvv)
		{
		if(txtCvv.getText().length()==3)
	    {
			txtCvv.setText(txtCvv.getText().substring(0,2));	
		  
	    } 
		int key1=ke.getKeyCode();
		if((key1>=ke.VK_0 && key1<=ke.VK_9) || (key1>=ke.VK_NUMPAD0 && key1<=ke.VK_NUMPAD9) || (key1==ke.VK_BACK_SPACE))
		{
			txtCvv.setEditable(true);
			txtCvv.setBackground(Color.green);
		}
		else
			{
			txtCvv.setEditable(false);
			txtCvv.setBackground(Color.red);
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
