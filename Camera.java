

public class Camera{

	int x;
	int y;


	public Camera(int x, int y){

		this.x = x;
		this.y = y;
	}

	public void tick(Player player){
		x = player.x + MyFrame.WIDTH/2; 
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	
}