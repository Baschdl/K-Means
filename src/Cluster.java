import java.awt.List;
import java.util.LinkedList;
import java.util.Random;


public class Cluster {

	private int max_width;
	private int max_height;
	private int centroid_x;
	private int centroid_y;
	private LinkedList<Point> points = new LinkedList<Point>();
	
	public Cluster(int max_width, int max_height){
		this.max_width = max_width;
		this.max_height = max_height;
		createCentroid();
	}
	
	private void createCentroid(){
		Random position = new Random();
		centroid_x = position.nextInt(max_width);
		centroid_y = position.nextInt(max_height);
		System.out.println(centroid_x + " | " + centroid_y);
	}
	
	public void addPoint(Point point){
		points.add(point);
	}
	
	public void clearCluster(){
		points.clear();
	}
	
	public void setCentroid(){
		int sum_x = 0;
		int sum_y = 0;
		int number_of_points = points.size();
		
		if(number_of_points > 0){
			for(int i=0; i<number_of_points; i++){
				sum_x += points.get(i).getX();
				sum_y += points.get(i).getY();
			}
			
			centroid_x = sum_x / number_of_points;
			centroid_y = sum_y / number_of_points;
		}
		System.out.println(centroid_x+" | "+centroid_y);
	}
	
	public LinkedList<Point> getPoints(){
		return points;
	}
	
	public int getCentroidX(){
		return centroid_x;
	}
	
	public int getCentroidY(){
		return centroid_y;
	}
	
}
