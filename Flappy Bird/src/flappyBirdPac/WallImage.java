package flappyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class WallImage {

	private Random r = new Random();

	public int x;
	public int y = r.nextInt(GamePanel.HEIGHT-400)+200;
	private int widthWall = 45;
	private int height = GamePanel.HEIGHT-y;
	private int gap = 200;
	
	public static int speed = -6;
	
	
	
	private BufferedImage img = null;
	
	public WallImage(int x) {
		this.x = x;
		Loadimage();
		
	}

	private void Loadimage() {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(new File("C://Users//Guide//Desktop//JavaFullCourse//Java_Assignments_JA111//src//Flappy Bird//images//Pipe image"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void drawWall(Graphics g)
	{
		g.drawImage(img, x, y,null);
	    g.drawImage(img,x,(-GamePanel.HEIGHT)+(y-gap),null);
	    
	}
	
	public void wallMovement()
	{
		x = x + speed;
	  
		if(x <= -widthWall)
		{
			x = GamePanel.WIDTH;
			y = r.nextInt((GamePanel.HEIGHT-400)+200);
			height = GamePanel.HEIGHT-y;
			
		}
		
		Rectangle lowerRect = new Rectangle(x,y,widthWall,height);
		Rectangle upperRect = new Rectangle(x,0, widthWall,GamePanel.HEIGHT-(height+gap));
	   
		if(lowerRect.intersects(BirdImage.getBirdRect()) || upperRect.intersects(BirdImage.getBirdRect()))
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
			BirdImage.reset();
			wallReset();
			}
			else
			{
				JFrame frame = MainBird.getWindow();
  			    frame.dispose();
			  MainBird.timer.stop();	
			}
		}
	}

	private void wallReset() {
		// TODO Auto-generated method stub
		y = r.nextInt(GamePanel.HEIGHT-400)+200;
		height = GamePanel.HEIGHT-y;
		GamePanel.gameOver = true;
	
	}

	
}
