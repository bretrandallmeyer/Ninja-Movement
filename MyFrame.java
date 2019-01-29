import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener{
	
  Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

   public void keyPressed(KeyEvent e){

       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           drawing.moveRight();
       }

       else if(e.getKeyCode() == KeyEvent.VK_LEFT){
           drawing.moveLeft();
       }

      else if(e.getKeyCode() == KeyEvent.VK_Z){
           drawing.attack();
      }

      else if(e.getKeyCode() == KeyEvent.VK_A){
           drawing.punch();
      }
      else if(e.getKeyCode() == KeyEvent.VK_S){
           drawing.kick();
      }

   }

   public void keyReleased(KeyEvent e){

   }

   public void keyTyped(KeyEvent e){
       System.out.println("....");
   }

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(500, 500);
		gameFrame.setVisible(true);
    gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
	}
}