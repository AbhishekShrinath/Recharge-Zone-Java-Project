import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class Summary extends JFrame
{
    DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);
   public Summary() 
   
   {
	  setSize(900,720);
      setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        setLayout(null);
        model.addColumn("TRANCTION Id");
        model.addColumn("MOBILE NUMBER");
        model.addColumn("OPERATOR");
        model.addColumn("AMOUNT");
        model.addColumn("PAYMENT TYPE");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rechargezone","root","abhishek");
            PreparedStatement pstm = con.prepareStatement("SELECT * from summary");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getBigDecimal(1), Rs.getBigDecimal(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setSize(900,720);
        add(pg);
      
       setResizable(false); 
        setVisible(true);
    }
}