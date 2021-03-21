import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
public class Prepaid extends JFrame implements ActionListener,KeyListener
{
	JLabel l1,l2;
	JTextField number,Amount;
	JButton pay;
	JComboBox operator,subComboBox;
	Hashtable<Object,Object> subItems = new Hashtable<Object, Object>();
	String airtalplans[]= {"598 unlimited call 1.5gb/day 84days","399 unlimited call 1.5gb/day 56days","449 unlimited call 2gb/day 56days","199 unlimited call 1gb/day 24days","149 unlimited call 2gb only 28days"};
	String opr[]= {"Select your operator","AIRTEL ","JIO ","VODAPONE ","IDEA "};
	
	Connection con;
	
	public Prepaid() 
	{
		super("PREPAID");

		setSize(1000,900);
		setBounds(200, 10, 1000, 900);
		setLayout(null);
		
		
		l1 =new JLabel("PREPAID ZONE");
		l1.setBounds(210, 55, 600,80);
		l1.setForeground(Color.white);
		l1.setFont(new Font("Wide Latin", Font.ITALIC, 35));
		add(l1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,0,80));
		panel_2.setBounds(0, 60, 1000, 80);
		add(panel_2);
		
		Font f=new Font("Tahoma",Font.BOLD,18);
		l1 =new JLabel("ENTER MOBILE NUMBER");
		l1.setForeground(Color.white);

		l1.setBounds(250,250,250,30);
		l1.setFont(f);
		add(l1);
		
		number=new JTextField();
		number.setFont(new Font("Tahoma", Font.PLAIN, 25));
		number.addKeyListener(this);
		number.setBounds(250,290,180,40);
		add(number);
		
		
		l2 =new JLabel("To Confirm ReEnter your Plan Amount");
		l2.setFont(new Font("Tahoma", Font.BOLD, 18));
		l2.setForeground(Color.white);
		l2.setBounds(250,515,350,35);
		
		add(l2);
		
		Amount=new JTextField();
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Amount.addKeyListener(this);
		Amount.setBounds(250,550,80,35);
		add(Amount);
		
		operator=new JComboBox(opr);
	     operator.addActionListener(this);
	
		operator.setBounds(250,350,190,50);

	subComboBox = new JComboBox();
	 subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
		
	 subItems.put(opr[1], airtalplans);
		 
	String jioplans[]= {"149 1gb/day 24days","239 2gd/day 28days","399 1.5gb/day 56days","401 3gb/day 28days disney+Hotstar Annul sub"};
	 subItems.put(opr[2], jioplans);
	 
	 String vodaphoneplans[]= {"449 unlimited call 4gb/day 56days","599 unlimited call 1.5gb/day 56days","399 unlimited call 1.5gb/day 56days","379 unlimited call 6gb only 84days","129 unlimited call 2gb only 24days"};
	 subItems.put(opr[3], vodaphoneplans);
	 
	 String ideaplans[]= {"599 unlimited call 1.5gb/day 84days","399 unlimited call 1.5gb/day 56days","100 Talktime Rs81.75 28days","999 unlimited call 1.5gb/day 365days","98rs 12gb 28days"};
	 subItems.put(opr[4], ideaplans);
		 
	 subComboBox.setBounds(250,440,280,50);
	 operator.setSelectedIndex(0);
	 add(operator);
	 add(subComboBox);
	 
	 pay=new JButton("PROCEED");
	 pay.setBounds(250,600,150,60);
	 pay.setFont(new Font("Tahoma", Font.BOLD, 17));
	 pay.addActionListener(this);
	 add(pay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,80));
		panel_1.setBounds(200, 210, 490, 480);
		add(panel_1);
		
	 
		ImageIcon background_img=new ImageIcon("prepaidbg.png");
		JLabel background=new JLabel("",background_img,JLabel.CENTER);
		Image bg_img=background_img.getImage();
		Image temp_img=bg_img.getScaledInstance(1000,900,Image.SCALE_SMOOTH);
		background_img=new ImageIcon(temp_img);
		background.setBounds(0, 0,1000,900);
		add(background);
		setResizable(false); 
		setVisible(true);
		
		
	}

	@Override
    public void actionPerformed(ActionEvent e)
    {
        String item = (String)operator.getSelectedItem();
        Object o = subItems.get( item );

        if (o == null)
        {
        	subComboBox.setModel( new DefaultComboBoxModel() );
        	
        }
        else
        {
        	subComboBox.setModel( new DefaultComboBoxModel( (String[])o ) );
           
        }
		if(e.getSource()==pay)
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
			else {
				String msg=number.getText();
				
				String msg2=(String)operator.getSelectedItem();
				String msg3=Amount.getText();
				
				this.dispose();
			
				new Payment(msg,msg2,msg3);
			}

		}

    }

	@Override
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==number)
		{
		if(number.getText().length()==10)
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
			JOptionPane.showMessageDialog(null,"NO CHARECTOR ALLOW");
			number.setBackground(Color.red);

		}
		}
		
		if(ke.getSource()==Amount)
		{
		if(Amount.getText().length()==3)
	    {
			Amount.setText(Amount.getText().substring(0,2));	
		  
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
