import java.awt.Image;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;

public class HomePage extends JFrame {

	/**
	 * Launch the application.
	 */
	static HomePage frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		getContentPane().setBackground(new Color(0,153,204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 518);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.scrollbar);
		setJMenuBar(menuBar);
		
		JMenu mnMyAccount = new JMenu("My Account");
		mnMyAccount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnMyAccount.setForeground(Color.BLUE);
		menuBar.add(mnMyAccount);
		
		JMenuItem mntmSignIn = new JMenuItem("Sign In");
		mnMyAccount.add(mntmSignIn);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnMyAccount.add(mntmLogout);
		
		JMenu mnRecords = new JMenu("Records");
		mnRecords.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnRecords.setForeground(Color.BLUE);
		menuBar.add(mnRecords);
		
		
		
		JMenuItem Year91 = new JMenuItem("Year 1991");
		mnRecords.add(Year91);
		
		JMenuItem Year01 = new JMenuItem("Year 2001");
		mnRecords.add(Year01);
		
		JMenuItem Year11 = new JMenuItem("Year 2011");
		mnRecords.add(Year11);
		
		JMenu View = new JMenu("View");
		View.setForeground(Color.BLUE);
		View.setFont(new Font("Times New Roman", Font.BOLD, 14));
		View.setBackground(SystemColor.info);
		menuBar.add(View);
		
		JMenuItem Gender = new JMenuItem("Gender Stats");
		View.add(Gender);
		
		JMenuItem Age = new JMenuItem("Age Stats");
		View.add(Age);
		
		JMenuItem Ability = new JMenuItem("Ability Stats ");
		View.add(Ability);
		
		JMenuItem Caste = new JMenuItem("Caste Stats");
		View.add(Caste);
		
		JMenuItem EmpStatus = new JMenuItem("Employement Stats");
		View.add(EmpStatus);
		
		JMenu ContactUs = new JMenu("Contact Us");
		ContactUs.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ContactUs.setForeground(Color.BLUE);
		menuBar.add(ContactUs);
		
		JMenuItem mntmDetails = new JMenuItem("Details");
		ContactUs.add(mntmDetails);
		
		JMenuItem mntmFeedback = new JMenuItem("FeedBack");
		ContactUs.add(mntmFeedback);
		
		JMenuItem mntmFaqs = new JMenuItem("FAQs");
		ContactUs.add(mntmFaqs);
		getContentPane().setLayout(null);

		JLabel main = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Capture.jpg")).getImage();
		main.setIcon(new ImageIcon(img3));
		Image newimg3 = img3.getScaledInstance(300,300, java.awt.Image.SCALE_SMOOTH);
		main.setIcon(new ImageIcon(newimg3));
		main.setBounds(347, 91, 315, 325);
		getContentPane().add(main);
		
		JLabel lblCensusIndia = new JLabel("CENSUS INDIA");
		lblCensusIndia.setForeground(new Color(255, 255, 255));
		lblCensusIndia.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblCensusIndia.setBounds(181, 23, 469, 57);
		getContentPane().add(lblCensusIndia);
		Image img = new ImageIcon(this.getClass().getResource("/img 1.jpg")).getImage();
		Image img1 = new ImageIcon(this.getClass().getResource("/Emblem.png")).getImage();
		Image newimg1 = img1.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
		Image img2 = new ImageIcon(this.getClass().getResource("/Emblem.png")).getImage();
		Image newimg2 = img2.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel = new JLabel("Measuring India's People, Places, and Economy");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(256, 603, 488, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel pie = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/pic1.jpg")).getImage();
		Image newimg4 = img4.getScaledInstance(300,300, java.awt.Image.SCALE_SMOOTH);
		pie.setIcon(new ImageIcon(newimg4));
		pie.setBounds(30, 105, 307, 300);
		getContentPane().add(pie);
		
		
		ActionListener link8 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				String url="http://censusindia.gov.in/2011-FAQ/FAQ-Public.html";
				// TODO Auto-generated method stub
				  try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		mntmFaqs.addActionListener(link8);
		ActionListener link4 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				
				frame.setVisible(false);
				
			}
		};
		mntmSignIn.addActionListener(link4);
		ActionListener link6 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				feedback f = new feedback();
				f.setVisible(true);
				frame.setVisible(false);
			}
				
			
		};
		mntmFeedback.addActionListener(link6);
		
		ActionListener link7 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Details d = new Details();
				d.setVisible(true);
				frame.setVisible(false);
			}
		};
		mntmDetails.addActionListener(link7);
		ActionListener link1 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				String url="http://censusindia.gov.in/DigitalLibrary/data/Census_1991/Publication/India/45969_1991_CHN.pdf";
				// TODO Auto-generated method stub
				  try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		ActionListener link2 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				String url="http://censusindia.gov.in/Ad_Campaign/press/DataHighlghts.pdf";
				// TODO Auto-generated method stub
				  try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		ActionListener link3 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				String url="http://www.censusindia.gov.in/2011Census/pes/Pesreport.pdf";
				// TODO Auto-generated method stub
				  try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		ActionListener link5 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,new String("Session logged out"));
				
			}
		};
	
		mntmLogout.addActionListener(link5);
		Year91.addActionListener(link1);
		Year01.addActionListener(link2);
		Year11.addActionListener(link3);
		
		ActionListener link9 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Charts f;
				try {
					f = new Charts();f.main(null);f.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
				
			
		};
		Gender.addActionListener(link9);
		ActionListener link10 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chart_Age f;
				try {
					f = new chart_Age();
					f.main(null);f.setVisible(false);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
				
			
		};
		Age.addActionListener(link10);
		ActionListener link11 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chart_Ability f;
				try {
					f = new chart_Ability();
					f.main(null);f.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
				
			
		};
		Ability.addActionListener(link11);
		ActionListener link12 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chart_Caste f;
				try {
					f = new chart_Caste();f.main(null);f.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
				
			
		};
		Caste.addActionListener(link12);
		ActionListener link13 = new ActionListener ()
		{
		    
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chart_Emp f;
				try {
					f = new chart_Emp();f.main(null);f.setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
				
			
		};
		EmpStatus.addActionListener(link13);
	}
}
