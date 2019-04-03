import java.awt.BorderLayout;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.DefaultPieDataset;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Charts extends JFrame {

	private JPanel contentPane; static ChartFrame f1;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException {
		String gens[] = {"Male","Female"}; int m =0,f=0;
		 
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "");
			
			 java.sql.Statement statement = con.createStatement( );
		      java.sql.ResultSet resultSet = statement.executeQuery("select * from censusdata" );
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      
		     while( resultSet.next( ) ) {
		         if(resultSet.getString( "gender" ).equals("Male") )
		         {
		        	 m++;
		         }
		         else
		        	 f++;
		     }
		         
		         dataset.setValue("Male",new Integer(m));
		         dataset.setValue("Female", new Integer(f));
		         JFreeChart chart = ChartFactory.createPieChart3D(
		                 "Gender Statistics",   // chart title           
		                 dataset,          // data           
		                 true,             // include legend          
		                 true,           
		                 false );
		         f1 = new ChartFrame("pie",chart);
		         f1.setVisible(true);
		         f1.setSize(450,500);
		         

		         
		      
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Charts frame = new Charts();
					frame.add(f1);
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Charts() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	
	
	 
	         	      

}
