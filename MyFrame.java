import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.player.moveUp();
			System.out.println("pos: " + drawing.player.x + ", " + drawing.player.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.player.moveRight();
			System.out.println("pos: " + drawing.player.x + ", " + drawing.player.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.player.moveDown();
			System.out.println("pos: " + drawing.player.x + ", " + drawing.player.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.player.moveLeft();
			System.out.println("pos: " + drawing.player.x + ", " + drawing.player.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.player.attack();
			System.out.println("attack");
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			drawing.player.ultimate();
		}

	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){

		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
	
		}
	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(800,500);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		System.out.println("practical programming");
	}
}