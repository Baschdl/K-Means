import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		int number_of_data_points = 1;
		int number_of_clusters = 1;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Wie viele Datenpunkte sollen erzeugt werden?");
		number_of_data_points = s.nextInt();
		System.out.println("Wie viele Cluster sollen erzeugt werden?");
		number_of_clusters = s.nextInt();
		
		Point points[] = new Point[number_of_data_points];
		for(int i=0; i<points.length; i++){
			Point point = new Point(550,550);
			points[i] = point;
		}
		
		Cluster clusters[] = new Cluster[number_of_clusters];
		for(int i=0; i<clusters.length; i++){
			Cluster cluster = new Cluster(550,550);
			clusters[i] = cluster;
		}
		
		int iterations = 0;
		double smallestDistanceToClusterCentroid = 10000;
		int nextClusterId = -1;
		boolean cluster_state_changed[] = new boolean[number_of_clusters];
		for(int i=0; i<cluster_state_changed.length; i++)
			cluster_state_changed[i] = true;
		
		while(!checkState(cluster_state_changed)){
			System.out.println();
			for(int k=0; k<points.length; k++){
				Point p = points[k];
				for(int i=0; i<clusters.length; i++){
					Cluster c = clusters[i];
					if (Math.sqrt((Math.abs(p.getX() - c.getCentroidX()) * Math.abs(p.getX() - c.getCentroidX())) + (Math.abs(p.getY() - c.getCentroidY()) * Math.abs(p.getY() - c.getCentroidY()))) < smallestDistanceToClusterCentroid){
						smallestDistanceToClusterCentroid = Math.sqrt((Math.abs(p.getX() - c.getCentroidX()) * Math.abs(p.getX() - c.getCentroidX())) + (Math.abs(p.getY() - c.getCentroidY()) * Math.abs(p.getY() - c.getCentroidY())));
						nextClusterId = i;
					}
				}
				clusters[nextClusterId].addPoint(p);
				smallestDistanceToClusterCentroid = 10000;
			}
			nextClusterId = -1;
			
			for(int j=0; j<clusters.length; j++){
				Cluster c = clusters[j];
				int old_x = c.getCentroidX();
				int old_y = c.getCentroidY();
				c.setCentroid();
				c.clearCluster();
				if((c.getCentroidX() == old_x) || (c.getCentroidY() == old_y))
					cluster_state_changed[j] = false;
			}
			iterations ++;
		}
		
		for(int k=0; k<points.length; k++){
			Point p = points[k];
			for(int i=0; i<clusters.length; i++){
				Cluster c = clusters[i];
				if (Math.sqrt((Math.abs(p.getX() - c.getCentroidX()) * Math.abs(p.getX() - c.getCentroidX())) + (Math.abs(p.getY() - c.getCentroidY()) * Math.abs(p.getY() - c.getCentroidY()))) < smallestDistanceToClusterCentroid){
					smallestDistanceToClusterCentroid = Math.sqrt((Math.abs(p.getX() - c.getCentroidX()) * Math.abs(p.getX() - c.getCentroidX())) + (Math.abs(p.getY() - c.getCentroidY()) * Math.abs(p.getY() - c.getCentroidY())));
					nextClusterId = i;
				}
			}
			clusters[nextClusterId].addPoint(p);
			smallestDistanceToClusterCentroid = 10000;
		}
		
		System.out.println();
		for(Cluster c : clusters){
			System.out.println(c.getCentroidX()+" | "+c.getCentroidY());
		}
		
		System.out.println("\nIterationen: " + iterations);
		
		Frame frame = new Frame(points,clusters);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setResizable(false);

	}
	
	public static boolean checkState(boolean change_states[]){
		boolean finished = false;
		for(boolean b : change_states){
			if(!b)
				finished = true;
			else
				finished = false;
		}
		return finished;
	}
	
}
