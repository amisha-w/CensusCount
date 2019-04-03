import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
//import javax.swing.JApplet;

public class Slide extends Applet {

	Slide s2 = new Slide();static Slide s;
	/**
	 * Create the applet.
	 */
	
	  
	   public static void main(String []args)
	   {
		    s = new Slide();
		   s.setVisible(true);
	   }
	
	private Image img[];
	private int totalImages = 4,
		    currentImage = 0,
		    sleepTime = 1000; // 1 sec = 1000 milliseconds
	 public void start()
		{
			currentImage = 0;	// always start with the first image
		}
	
   public void init()
// load the image when the applet begins executing
     	{
	   this.s2=s;
		Image i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\pic1.jpg").getImage();
		Image img1 = i.getScaledInstance(300,500, java.awt.Image.SCALE_SMOOTH);
		i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\pic2.jpg").getImage();
		Image img2 = i.getScaledInstance(300,500, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\pic3.jpg").getImage();
		Image img3 = i.getScaledInstance(300,500, java.awt.Image.SCALE_SMOOTH);
		 i = new ImageIcon("C:\\Users\\Gayatri\\Desktop\\pic4.jpg").getImage();
		Image img4 = i.getScaledInstance(300,500, java.awt.Image.SCALE_SMOOTH);
		img[0]=img1; img[1]=img2; img[2]=img3; img[3]=img4;
	}

  

// display the image in the Applet's Graphics context
// then sleep and call repaint
   public void paint(Graphics g)
     {
	   
	g.drawImage(img[currentImage], 1, 1, this);
	
	
// fix to help load images in Netscape Navigator
// make browser "think" there is a mouse event
	postEvent (new Event( this, Event.MOUSE_ENTER, "" ) );

	currentImage = ++currentImage % totalImages;

	try
		{ Thread.sleep( sleepTime ); }
	catch ( InterruptedException e )
		{ showStatus (e.toString() ); }
	
	repaint ();	
      }
 

}
/*<applet code = "Slide.class" width = "300" height = "300">
</applet>*/
