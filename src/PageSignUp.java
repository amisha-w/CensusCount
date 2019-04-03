import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.sql.*;
import java.awt.EventQueue;
import java.awt.Label;

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
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JSeparator;
public class PageSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField CreateName;
	private JTextField age;
	private JTextField email_id;
	private JPasswordField passwordField;
	private JPasswordField password;
	private JTextField pan;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageSignUp frame = new PageSignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {System.out.println(e);}
	}
	public static void connectSQL(String name, String psd,int a,String em,String p) {
		String host = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(host,username, password); 
			PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO censusdata (username, password,age,email_id,pan_no) VALUES(?,?,?,?,?)");
			statement.setString(1,name);
			statement.setString(2,psd);
			statement.setInt(3,a);
			statement.setString(4,em);
			statement.setString(5,p);
			statement.executeUpdate();
			
			
			JOptionPane.showMessageDialog(null,new String("Account created successfully"));
			statement.close();
			connect.close();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public PageSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		
		CreateName = new JTextField();
		CreateName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		CreateName.setForeground(new Color(0, 0, 128));
		CreateName.setBackground(SystemColor.window);
		CreateName.setBounds(379, 155, 238, 20);
		contentPane.add(CreateName);
		CreateName.setColumns(10);
		CreateName.setBorder(new LineBorder(new Color(255,255,255)));
		
		age = new JTextField();
		age.setForeground(new Color(0, 0, 128));
		age.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		age.setColumns(10);
		age.setBounds(379, 186, 86, 16);
		contentPane.add(age);
		age.setBorder(new LineBorder(new Color(255,255,255)));
		
		
		JLabel lblCreateUsername = new JLabel("CREATE USERNAME");
		lblCreateUsername.setForeground(new Color(0, 0, 128));
		lblCreateUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCreateUsername.setBounds(126, 148, 178, 30);
		contentPane.add(lblCreateUsername);
		
		JLabel lblEnterDateOf = new JLabel("ENTER YOUR AGE");
		lblEnterDateOf.setForeground(new Color(0, 0, 128));
		lblEnterDateOf.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterDateOf.setBounds(145, 194, 159, 14);
		contentPane.add(lblEnterDateOf);
		
		
		JButton btnNewButton = new JButton("PROCEED");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = CreateName.getText().toString();
				String pass = password.getText().toString();
				int a = Integer.parseInt(age.getText());
				String e = email_id.getText().toString();
				String p = pan.getText().toString();
				connectSQL(name,pass,a,e,p);
				CensusData cd  = new CensusData(name);
				cd.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton.setBounds(276, 389, 149, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblEmailId = new JLabel("ENTER EMAIL ID");
		lblEmailId.setForeground(new Color(0, 0, 128));
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmailId.setBounds(155, 230, 149, 14);
		contentPane.add(lblEmailId);
		
		email_id = new JTextField();
		email_id.setForeground(new Color(0, 0, 128));
		email_id.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		email_id.setBounds(379, 224, 238, 20);
		contentPane.add(email_id);
		email_id.setColumns(10);
		email_id.setBorder(new LineBorder(new Color(255,255,255)));
		
		JLabel lblCreatePassword = new JLabel("CREATE PASSWORD");
		lblCreatePassword.setForeground(new Color(0, 0, 128));
		lblCreatePassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCreatePassword.setBounds(126, 268, 178, 14);
		contentPane.add(lblCreatePassword);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblConfirmPassword.setForeground(new Color(0, 0, 128));
		lblConfirmPassword.setBounds(112, 307, 193, 14);
		contentPane.add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 128));
		passwordField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		passwordField.setBounds(379, 260, 238, 20);
		contentPane.add(passwordField);
		passwordField.setBorder(new LineBorder(new Color(255,255,255)));
		
		
		password = new JPasswordField();
		password.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		password.setBounds(379, 297, 238, 20);
		contentPane.add(password);
		password.setBorder(new LineBorder(new Color(255,255,255)));
		
		JLabel lblPanNumber = new JLabel("PAN NUMBER");
		lblPanNumber.setForeground(new Color(0, 0, 128));
		lblPanNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPanNumber.setBounds(183, 341, 121, 14);
		contentPane.add(lblPanNumber);
		
		pan = new JTextField();
		pan.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		pan.setForeground(new Color(0, 0, 128));
		pan.setBounds(379, 330, 238, 20);
		contentPane.add(pan);
		pan.setColumns(10);
		pan.setBorder(new LineBorder(new Color(255,255,255)));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(290, 11, 97, 104);
		contentPane.add(lblNewLabel);
		
		
		Image i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\user.jpg").getImage();
		Image n = i.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(n));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(379, 175, 242, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(379, 206, 238, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(379, 245, 238, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(379, 285, 238, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(379, 319, 238, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(379, 353, 238, 2);
		contentPane.add(separator_5);
	}
}
