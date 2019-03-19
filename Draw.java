import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent{

	private BufferedImage backgroundImage;
	
	public Player player;
	public Camera cam;

	// randomizer
	public Random randomizer;

	// enemy
	public int enemyCount;
	Monster[] monsters = new Monster[10];

	public Draw(){
		randomizer = new Random();
		player = new Player(70, 385, this);
		cam = new Camera(0, 0);

		spawnEnemy();
		
		try{
			backgroundImage = ImageIO.read(getClass().getResource("castlebackground.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(player.x,player.y);
								cam.tick(player);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		if(enemyCount < 10){
			monsters[enemyCount] = new Monster(600, 385, this);
			enemyCount++;
		}
	}

	public void checkCollision(){

		for (int i = 0; i < monsters.length; i++){
			if(player.isAttacking == true){
				System.out.println("Collision");
				if(monsters[i].getBounds().intersects(player.getBounds())){
					monsters[i].life-= 5;

				}
			}
			
		}
		
	
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, -cam.x, -cam.y, 800, 500, this);
		
		Graphics2D g2d = (Graphics2D) g;

		// character grid for hero
		// g.setColor(Color.YELLOW);
		// g.fillRect(x, y, width, height);
		g2d.translate(cam.getX(), cam.getY());

		g.drawImage(player.image, player.x, player.y, this);

		g2d.translate(-cam.getX(), -cam.getY());
		
		for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				// character grid for monsters
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, 50, 50, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
			}	
		}
	}
}