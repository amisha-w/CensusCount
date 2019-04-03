import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class chart_Caste extends JFrame {

	private JPanel contentPane;static ChartFrame f1;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		int open=0,sc=0,st=0,obc=0;
		 
		Class.forName("com.mysql.jdbc.Driver");
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "");
			
			 java.sql.Statement statement = con.createStatement( );
		      java.sql.ResultSet resultSet = statement.executeQuery("select * from censusdata" );
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      
		     while( resultSet.next( ) ) {
		         if(resultSet.getString( "caste" ).equals("Open") )
		         
		        	open++;
		         else if(resultSet.getString( "caste" ).equals("OBC"))
		             obc++;
		         else if(resultSet.getString( "caste" ).equals("SC"))
		        	 sc++;
		          else
		        	 st++;
		     }
		         
		         dataset.setValue("Open",new Integer(open));
		         dataset.setValue("OBC", new Integer(obc));
		         dataset.setValue("ST", new Integer(sc));
		         dataset.setValue("SC", new Integer(st));
		        
		         JFreeChart chart = ChartFactory.createPieChart3D(
		                 "Caste Statistics",   // chart title           
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
					chart_Caste frame = new chart_Caste();
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
	public chart_Caste() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
