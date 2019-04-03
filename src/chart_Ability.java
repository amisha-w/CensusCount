import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class chart_Ability extends JFrame {

	private JPanel contentPane;static ChartFrame f2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException{
		
		int a=0,d=0;
		 
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "");
			
			 java.sql.Statement statement = con.createStatement( );
		      java.sql.ResultSet resultSet = statement.executeQuery("select * from censusdata" );
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      
		     while( resultSet.next( ) ) {
		         if(resultSet.getString( "disabilityStatus" ).equals("Able") )
		         
		        	a++;
		         
		          else
		        	 d++;
		     }
		         
		         dataset.setValue("Abled",new Integer(a));
		         dataset.setValue("Disabled", new Integer(d));
		        
		         JFreeChart chart = ChartFactory.createPieChart3D(
		                 "Ability Statistics",   // chart title           
		                 dataset,          // data           
		                 true,             // include legend          
		                 true,           
		                 false );
		          f2 = new ChartFrame("pie",chart);
		         
		         f2.setVisible(true);
		         f2.setSize(450,500);
		       
		         

		         
		      
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
					chart_Ability frame = new chart_Ability();
					
					f2.setVisible(true);
					frame.add(f2);
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
	public chart_Ability() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
	}

}
