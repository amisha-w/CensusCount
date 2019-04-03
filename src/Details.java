import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Details extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback();
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
	public Details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DETAILS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(140, 0, 119, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact  EMAIL: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(45, 67, 167, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("developercensus@indiagov.in");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(172, 69, 221, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact Number: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setBounds(48, 101, 119, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("9967549192");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setBounds(172, 102, 151, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A PROJECT BY");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(140, 150, 183, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gayatri Srinivasan - 1711058");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setBounds(102, 187, 221, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Girish Thatte - 1711059");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setBounds(134, 212, 204, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Amisha Waghela - 1711063");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setForeground(new Color(0, 0, 128));
		lblNewLabel_8.setBounds(113, 237, 210, 14);
		contentPane.add(lblNewLabel_8);
	}

}
