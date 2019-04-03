import java.sql.*;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JSeparator;

public class MainPage {

	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0, 153, 204));
		frame.setBounds(100, 100, 670, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("LOG IN ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setLayout(null);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo", "root", "");
					Statement stmt = con.createStatement();
					String sql = "Select * from censusdata where username ='"+textField.getText()+"' and password ='"+passwordField.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,new String("Login Successful!!"));
						CensusData cd  = new CensusData(textField.getText());
						cd.setVisible(true);
						frame.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null,new String("Invalid credentails!!"));
					}
					con.close();
				}catch(Exception e) {System.out.println(e);}

			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(386, 320, 120, 30);
		btnNewButton.setBackground(Color.WHITE);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnSignUp_1 = new JButton("SIGN UP");
		btnSignUp_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignUp_1.setForeground(Color.BLUE);
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PageSignUp sign = new PageSignUp();
				sign.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnSignUp_1.setBounds(386, 399, 120, 30);
		frame.getContentPane().add(btnSignUp_1);
		btnSignUp_1.setBackground(Color.WHITE);
		
		JLabel lblCensusCount = new JLabel("CENSUS COUNT");
		lblCensusCount.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 24));
		lblCensusCount.setForeground(new Color(255, 255, 255));
		lblCensusCount.setBounds(354, 28, 307, 23);
		frame.getContentPane().add(lblCensusCount);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		textField_1.setBounds(359, 190, 169, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0,153,204));
		textField_1.setBorder(new LineBorder(new Color(0,153,204)));
		
		JLabel lblUsername = new JLabel("PAN NO.");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setBounds(359, 165, 107, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(355, 242, 106, 17);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewUser = new JLabel("Not Registered?");
		lblNewUser.setForeground(new Color(255, 255, 255));
		lblNewUser.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewUser.setBounds(386, 368, 168, 20);
		frame.getContentPane().add(lblNewUser);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		passwordField.setBounds(365, 263, 163, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setBackground(new Color(0,153,204));
		passwordField.setBorder(new LineBorder(new Color(0,153,204)));
		
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUserName.setBounds(356, 98, 158, 17);
		frame.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0,153,204));
		textField.setBounds(364, 115, 163, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0,153,204)));
		
		JLabel census_lab = new JLabel("");
		Image i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\census1.jpg").getImage();
		Image n = i.getScaledInstance(300,500, java.awt.Image.SCALE_SMOOTH);
		census_lab.setIcon(new ImageIcon(n));
		
		census_lab.setBounds(0, 0, 344, 468);
		frame.getContentPane().add(census_lab);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(358, 140, 169, 14);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(359, 212, 169, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(359, 285, 169, 2);
		frame.getContentPane().add(separator_2);
	}
}
