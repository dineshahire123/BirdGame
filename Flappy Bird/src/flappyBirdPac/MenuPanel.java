package flappyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{

	
	private static final long SerialVersioUID = 1L;
	
	private BufferedImage img = null;
	
	public boolean startingPoint = false;
	
	public MenuPanel() {
		LoadImage();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				startingPoint = true;
			}
		});
	}

	private void LoadImage() {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(new File("C://Users//Guide//Desktop//JavaFullCourse//Java_Assignments_JA111//src//Flappy Bird//images//menu panel images"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
	}
}
