package flappyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BirdImage {

	private BufferedImage img = null;
	private static int birdDia = 36;
	public static int x = (GamePanel.WIDTH/2)-birdDia/2;
	public static int y = GamePanel.WIDTH/2;
	private static int speed = 2;
	private int acc = 1;
	
	public BirdImage()
	{
		LoadImage();
	}

	private void LoadImage() {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(new File("C://Users//Guide//Desktop//JavaFullCourse//Java_Assignments_JA111//src//Flappy Bird//images//BirdImage5"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void drawBird(Graphics g) {
		g.drawImage(img, x, y, null);
		
	}
	
	public void birdMovement()
	{
          if(y>=0 && y<=GamePanel.HEIGHT)
          {
        	  speed = speed + acc;
        	  y = y + speed;
        	  
          }
          else
          {
        	  boolean option = GamePanel.popupMessage();
  			if(option)
  			{
  			try {
  				Thread.sleep(500);
  			}
  			catch(Exception e)
  			{
  				e.printStackTrace();
  			}
  			reset();
  			}
  			
  			else
  			{
  				JFrame frame = MainBird.getWindow();
  			    frame.dispose();
  				MainBird.timer.stop();
  			}
          }
	}
	
	public void goUpwards()
	{
		speed = -17;
	}
	
	public static void reset()
	{
	   	speed = 2;
	   	y = GamePanel.HEIGHT/2;
	    GamePanel.gameOver = true;
	    GamePanel.score = 0;
	}
	
	public static Rectangle getBirdRect()
	{
		Rectangle birdRect = new Rectangle(x,y,birdDia,35);
	return birdRect;
	}
}
