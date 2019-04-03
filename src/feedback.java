import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class feedback extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField Feedback;

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
	public feedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("FEEDBACK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(191, 25, 160, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username ");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(107, 73, 143, 24);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 128));
		username.setBounds(248, 76, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("State your Feedback here");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBounds(46, 119, 170, 41);
		contentPane.add(lblNewLabel_2);
		
		Feedback = new JTextField();
		Feedback.setForeground(new Color(0, 0, 128));
		Feedback.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Feedback.setBounds(248, 130, 295, 123);
		contentPane.add(Feedback);
		Feedback.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,new String("Feedback submitted successfully"));
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBounds(208, 297, 120, 41);
		contentPane.add(btnNewButton);
		
		
		
	}
}
