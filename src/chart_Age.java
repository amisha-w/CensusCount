import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
public class chart_Age extends JFrame {

	private JPanel contentPane; static ChartFrame f1;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		 int below18=0,btwn18to60=0,above60=0;
		 
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "");
			
			 java.sql.Statement statement = con.createStatement( );
		      java.sql.ResultSet resultSet = statement.executeQuery("select * from censusdata" );
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      
		     while( resultSet.next( ) ) {
		         if(resultSet.getInt( "age" )<18 )
		         
		        	 below18++;
		         
		         else if(resultSet.getInt( "age" )>18&&resultSet.getInt( "age" )<60)
		        	 btwn18to60++;
		         else
		        	 above60++;
		     }
		         
		         dataset.setValue("Below 18",new Integer(below18));
		         dataset.setValue("Between 18 to 60", new Integer(btwn18to60));
		         dataset.setValue("Above 60", new Integer(above60));
		         JFreeChart chart = ChartFactory.createPieChart3D(
		                 "Age Statistics",   // chart title           
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
					chart_Age frame = new chart_Age();
					frame.add(f1);
					frame.setVisible(true);
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
	public chart_Age() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
