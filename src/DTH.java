import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
public class DTH extends JFrame implements ActionListener,KeyListener
{
	JLabel l1,l2,l3;
	JTextField number,Amount;
	JButton pay;
	JComboBox operator,subComboBox;
	Hashtable subItems = new Hashtable();

	
	public DTH()
	{
		super("DTH");

		setSize(1000,900);
		setBounds(200, 10, 1000, 900);
		setLayout(null);
		
		
		l1 =new JLabel("DTH ZONE");
		l1.setBounds(210, 20, 600,80);
		l1.setForeground(Color.GREEN);
		l1.setFont(new Font("Wide Latin", Font.ITALIC, 35));
		add(l1);
		
		Font f=new Font("Serif",Font.BOLD,18);
		l1 =new JLabel("ENTER REGISTOR MOBILE NUMBER");
		l1.setForeground(Color.WHITE);
		l1.setBounds(250,250,330,30);
		l1.setFont(f);
		add(l1);
		
		number=new JTextField();
		number.setFont(new Font("Tahoma", Font.PLAIN, 25));
		number.setBounds(250,290,180,40);
		number.addKeyListener(this);
		add(number);
		
		String opr[]= {"Select your operator","AIRTEL DIGITAL","DISH TV","HATHWAY","D2H"};
		operator=new JComboBox(opr);
	     operator.addActionListener(this);
	
		operator.setBounds(250,350,190,50);

	subComboBox = new JComboBox();
	 subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
		
	 String airtalplans[]= {"Rs710/month HD plan","Rs410/month Famaly plan","Rs320/Month SD paln","Rs235/month FTA"};
	 subItems.put(opr[1], airtalplans);
		 
	String DISHTVplans[]= {"460Rs TATANIUM","387Rs SUPER SPORT","277Rs SUPER FAMALY","237Rs HINDI PREMIUM"};
	 subItems.put(opr[2], DISHTVplans);
	 
	 String HATHWAYplans[]= {"Rs275/month SUPER VALUE","Rs240/month STARTER VALUE","Rs130/month MAHARASHTRA FTA","Rs450/month"};
	 subItems.put(opr[3],HATHWAYplans);
	 
	 String D2Hlans[]= {"Rs307/month","Rs227/month","Rs295/month","Rs420/month"};
	 subItems.put(opr[4], D2Hlans);
		 
	 subComboBox.setBounds(250,440,280,50);
	 operator.setSelectedIndex(0);
	 add(operator);
	 add(subComboBox);
	 
		Font f1=new Font("Tahoma",Font.BOLD,18);
		l2 =new JLabel("To Confirm ReEnter your Plan Amount");
		l2.setForeground(Color.WHITE);
		l2.setBounds(250,515,350,35);
		l2.setFont(f1);
		add(l2);
		
		Amount=new JTextField();
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Amount.addKeyListener(this);
		Amount.setBounds(250,550,80,35);
		add(Amount);
	 
		pay=new JButton("Proceed");
		 pay.setBounds(250,600,150,60);
		 pay.setFont(new Font("Tahoma", Font.BOLD, 17));
		pay.addActionListener(this);
		add(pay);
	 
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 51, 153,80));
		panel_1.setBounds(200, 210, 490, 480);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255,255,255,80));
		panel_2.setBounds(0, 60, 1000, 80);
		add(panel_2);
	 
		ImageIcon background_img=new ImageIcon("dthwallpaper.jpg");
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
        String s=e.getActionCommand();
		if(s.equals("Proceed"))
		{
			String num=number.getText().toString();
		String Amt=Amount.getText().toString();
		String chk=operator.getSelectedItem().toString();
		if(num.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Number is mandotary");
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
			
			String msg2=(String)operator.getSelectedItem();
			String msg3=Amount.getText();
			
			this.dispose();
		
			new Payment(msg,msg2,msg3);
		}
	}

    }

	@Override
	public void keyPressed(KeyEvent ke) 	{
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
