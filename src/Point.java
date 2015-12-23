import java.util.Random;


public class Point {
	
	private int max_width;
	private int max_height;
	private int x;
	private int y;
	
	public Point(int max_width, int max_height){
		this.max_height = max_height;
		this.max_width = max_width;
		createPoint();
	}
	
	private void createPoint(){
		Random position = new Random();
		x = position.nextInt(max_width);
		y = position.nextInt(max_height);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

}
