import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class slideShow extends JFrame {
JLabel pic;
Timer tm;
int x=0;
String[] list = { "C:\\Users\\Gayatri\\Desktop\\pic1.jpg","C:\\Users\\Gayatri\\Desktop\\pic2.jpg","C:\\\\Users\\\\Gayatri\\\\Desktop\\\\pic3.jpg,\"C:\\\\Users\\\\Gayatri\\\\Desktop\\\\pic4.jpg\""};
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void setImageSize(int i)
	{
		ImageIcon icon= new ImageIcon(list[i]);
		Image img = icon.getImage();
		Image newImg= img.getScaledInstance(pic.getWidth(), pic.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
	}
	public static void main(String[] args) {
		new slideShow();
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slideShow frame = new slideShow();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public slideShow() {
		super("Java SlideShow");
		pic=new JLabel();
		pic.setBounds(40, 30, 700, 300);
		setImageSize(6);
		tm=new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setImageSize(x);
				x=x+1;
				if(x>=list.length)
					x=0;
				
			}
			
		});
		add(pic);
		tm.start();
		setLayout(null);
		setSize(800,400);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setVisible(true);
		//setContentPane(contentPane);
		
	}

}
