package flappyBirdPac;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static boolean gameOver = false;
	public static int score = 0;
	
	public static boolean starting = false;
	
	public static int begin = -1;
	public static final int WIDTH =600;
	public static int HEIGHT = 800;
	
    
	private int xCoor = 0;
	private BufferedImage img;
	
	BirdImage bi = new BirdImage();
	WallImage wi = new WallImage(GamePanel.WIDTH);
	WallImage wi2 = new WallImage(GamePanel.WIDTH/2);

	public GamePanel()
	{
		LoadImage();
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	// TODO Auto-generated method stub
            	super.mousePressed(e);
            	bi.goUpwards();
            }
		});
		
	}

	private void LoadImage() {
		// TODO Auto-generated method stub
		
		try {
			
			img = ImageIO.read(new File("C://Users//Guide//Desktop//JavaFullCourse//Java_Assignments_JA111//src//Flappy Bird//images//GamePanelImage4.png"));
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.drawImage(img, xCoor, 0, null);
		g.drawImage(img, xCoor+600, 0, null);

		bi.drawBird(g);
		wi.drawWall(g);
		wi2.drawWall(g);
		
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		g.drawString("Score" + score, WIDTH/2, 100);
	   
		if(starting)
		{
			g.setFont(new Font("Tahoma",Font.BOLD,150));
			g.drawString(Integer.toString(begin), WIDTH/2 - 75, 250);
		}
	}
	
	public void move()
	{
		bi.birdMovement();
		wi.wallMovement();
		wi2.wallMovement();
		
		if(gameOver)
		{
			wi.x = GamePanel.WIDTH;
			wi2.x = GamePanel.WIDTH+(GamePanel.WIDTH/2);
			GamePanel.gameOver = false;
		}
		
		xCoor = xCoor + WallImage.speed;
		 
		if(xCoor == -600)
		{
			xCoor = 0;
		}
		
		System.out.println(wi.x + "->" + BirdImage.x + " : "+ wi2.x+"->" +  BirdImage.x);
		
		if(wi.x == BirdImage.x || wi2.x == BirdImage.x)
		{
			score = score + 1;
		}
	}
	
	public static boolean popupMessage()
	{
		int result = JOptionPane.showConfirmDialog(null,"Game Over , Your Score is : "+ score + "\n Do You Want to Restart the Game", "Game Over",JOptionPane.YES_NO_OPTION);
	  
		if(result ==JOptionPane.YES_OPTION)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
