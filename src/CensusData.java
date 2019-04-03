import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.Statement;

import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class CensusData extends JFrame {
	
  static String un;
	
	public CensusData()
	{
		
	}
	
	public CensusData(String un) {
		this.un=un;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(250, 223, 333, 20);
		contentPane.add(Address);
		
		lblSelectGender = new JLabel("GENDER");
		lblSelectGender.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSelectGender.setForeground(new Color(255, 255, 255));
		lblSelectGender.setBounds(70, 154, 131, 20);
		contentPane.add(lblSelectGender);
		
		lblOccupation = new JLabel("OCCUPATION");
		lblOccupation.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblOccupation.setForeground(new Color(255, 255, 255));
		lblOccupation.setBounds(70, 477, 122, 28);
		contentPane.add(lblOccupation);
		
		lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddress.setBounds(70, 223, 145, 20);
		contentPane.add(lblAddress);
		
		lblEnterDetails = new JLabel("ENTER DETAILS ");
		lblEnterDetails.setForeground(new Color(255, 255, 255));
		lblEnterDetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblEnterDetails.setBounds(220, 11, 243, 48);
		contentPane.add(lblEnterDetails);
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(70, 74, 134, 20);
		contentPane.add(lblName);
		
		lblNewLabel_1 = new JLabel("AADHAR NUMBER");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(70, 105, 170, 38);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("RELIGION");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(70, 347, 131, 20);
		contentPane.add(lblNewLabel_2);
		
		city = new JTextField();
		city.setBounds(250, 262, 131, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JRadioButton govt = new JRadioButton("Government ");
		govt.setBounds(250, 517, 131, 20);
		contentPane.add(govt);
		
		JRadioButton nongovt = new JRadioButton("Non-Government");
		nongovt.setBounds(411, 517, 172, 20);
		contentPane.add(nongovt);
		
		lblNewLabel_3 = new JLabel("CASTE");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(70, 389, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		state = new JTextField();
		state.setText("");
		state.setBounds(250, 301, 131, 20);
		contentPane.add(state);
		state.setColumns(10);
		
		String occ[]= {"Service","Business","Self-Employed","None"};
		occupation = new JComboBox(occ);
		occupation.setSelectedIndex(-1);
		occupation.setBounds(250, 477, 131, 20);
		contentPane.add(occupation);
		
		lblDisabilityStatus = new JLabel("DISABILITY STATUS");
		lblDisabilityStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDisabilityStatus.setForeground(new Color(255, 255, 255));
		lblDisabilityStatus.setBounds(47, 576, 193, 14);
		contentPane.add(lblDisabilityStatus);
		
		able = new JRadioButton("Able");
		able.setBounds(250, 574, 109, 23);
		contentPane.add(able);
		
		disable = new JRadioButton("Differently Abled");
		disable.setBounds(411, 574, 172, 23);
		contentPane.add(disable);
		
		lblNewLabel_5 = new JLabel("MOTHERTONGUE");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(70, 428, 156, 18);
		contentPane.add(lblNewLabel_5);
		
		String gen[]= {"Female","Male"};
		gender = new JComboBox(gen);
		gender.setSelectedIndex(-1);
		gender.setBounds(250, 157, 109, 20);
		contentPane.add(gender);
		
		
		
		btnNewButton = new JButton("PROCEED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String govtSts,abilitySts;
				String n=name.getText().toString();
				String aad = aadhar.getText().toString();
				String gen = gender.getSelectedItem().toString();
				String addr= Address.getText().toString();
				String c = city.getText().toString();
				String s = state.getText().toString();
				String r = religion.getText().toString();
				String cst = caste.getText().toString();
				String mt = mothertongue.getText().toString();
				String occ = occupation.getSelectedItem().toString();
				if(govt.isSelected())
					 govtSts = "Government";
				else
					govtSts = "Non-Government";
				if(able.isSelected())
					abilitySts= "Able";
				else
					abilitySts = "Disabled";
				
				connectSQL(n,aad,gen,addr,c,s,r,cst,mt,occ,govtSts,abilitySts);
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 204));
		btnNewButton.setBounds(251, 659, 162, 28);
		contentPane.add(btnNewButton);
		
		lblCity = new JLabel("CITY");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setBounds(70, 259, 99, 20);
		contentPane.add(lblCity);
		
		aadhar = new JTextField();
		aadhar.setBounds(250, 116, 195, 20);
		contentPane.add(aadhar);
		aadhar.setColumns(10);
		
		name = new JTextField();
		name.setBounds(248, 73, 197, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 50, 574, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 204, 574, 8);
		contentPane.add(separator_1);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("STATE");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(70, 295, 122, 28);
		contentPane.add(lblNewLabel_7);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(42, 334, 569, 2);
		contentPane.add(separator_2);
		
		religion = new JTextField();
		religion.setBounds(250, 349, 131, 20);
		contentPane.add(religion);
		religion.setColumns(10);
		
		caste = new JTextField();
		caste.setBounds(250, 388, 131, 20);
		contentPane.add(caste);
		caste.setColumns(10);
		
		mothertongue = new JTextField();
		mothertongue.setBounds(250, 429, 131, 20);
		contentPane.add(mothertongue);
		mothertongue.setColumns(10);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(42, 467, 569, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(47, 556, 574, 2);
		contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(42, 622, 579, 2);
		contentPane.add(separator_5);
	}



	private JPanel contentPane;
	private JTextField Address;
	private JLabel lblSelectGender;
	private JLabel lblOccupation;
	private JLabel lblAddress;
	private JLabel lblNewLabel;
	private JLabel lblEnterDetails;
	private JLabel lblName;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField city;
	private JLabel lblNewLabel_3;
	private JTextField state;
	private JComboBox occupation;
	private JLabel lblDisabilityStatus;
	private JRadioButton able;
	private JRadioButton disable;
	private JLabel lblNewLabel_5;
	private JComboBox gender;
	private JButton btnNewButton;
	private JLabel lblCity;
	private JTextField aadhar;
	private JTextField name;
	private JSeparator separator_2;
	private JTextField religion;
	private JTextField caste;
	private JTextField mothertongue;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CensusData frame = new CensusData(null);
				
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
		}catch(Exception e) {System.out.println(e);} //connectSQL(n,aad,gen,addr,c,s,r,cst,mt,occ,govtSts,abilitySts);
	}
	public static void connectSQL(String n, String aad,String gen,String addr,String c,String s,String r,String cst, String mt,String occ,String govtSts,String abilitySts) {
		String host = "jdbc:mysql://localhost:3306/userinfo";
		String username = "root";
		String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//CensusData cd = new CensusData();
			Connection connect = DriverManager.getConnection(host,username, password); 
			java.sql.Statement   st = connect.createStatement();
	          st.executeUpdate("update censusdata set name = '"+n+"', aadhar_no='"+aad+"',gender='"+gen+"',address='"+addr+"',city='"+c+"' , state = '"+s+"' ,religion = '"+r+"', caste = '"+cst+"',mothertongue='"+mt+"',occupation='"+occ+"',govtStatus='"+govtSts+"' , disabilityStatus='"+abilitySts+"' where username = '"+un+"'");
			/*PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO censusdata (name,aadhar_no,gender,address,city,state,religion,caste,mothertongue,occupation,govtStatus,disabilityStatus) VALUES(?,?,?,?,?)");
			statement.setString(1,n);
			statement.setString(2,aad);
			statement.setString(3,gen);
			statement.setString(4,addr);
			statement.setString(5,c);
			statement.setString(6,s);
			statement.setString(7,r);
			statement.setString(8,cst);
			statement.setString(9,mt);
			statement.setString(10,occ);
			statement.setString(11,govtSts);
			statement.setString(12,abilitySts);
			statement.executeUpdate();*/
			
			
			JOptionPane.showMessageDialog(null,new String("Data entered successfully"));
			//statement.close();
			connect.close();
		}catch(Exception e) {System.out.println(e);}
	}
	}
