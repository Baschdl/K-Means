import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Frame extends JFrame{
	
	private Screen screen;
	private Point points[];
	private Cluster clusters[];

	public Frame(Point points[], Cluster clusters[]){
		super("K-Means Algorithm");
		
		this.points = points;
		this.clusters = clusters;
		
		screen = new Screen();
		screen.setBounds(0,0,600,600);
		add(screen);
	}
	
	public void repaintScreen(){
		screen.repaint();
	}
	
	private class Screen extends JLabel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			for(int i=0; i<clusters.length; i++){
				switch(i){
					case 0:
						g.setColor(Color.ORANGE);
						break;
					case 1:
						g.setColor(Color.BLUE);
						break;
					case 2:
						g.setColor(Color.GREEN);
						break;
					case 3:
						g.setColor(Color.PINK);
						break;
					case 4:
						g.setColor(Color.YELLOW);
						break;
					case 5:
						g.setColor(Color.BLACK);
						break;
					case 6:
						g.setColor(Color.CYAN);
						break;
					case 7:
						g.setColor(Color.GRAY);
						break;
					case 8:
						g.setColor(Color.MAGENTA);
						break;
					case 9:
						g.setColor(Color.LIGHT_GRAY);
						break;
				}
					
				for(Point p : clusters[i].getPoints()){
					g.fillRect(p.getX()-4, p.getY()-4, 8, 8);
					g.drawLine(p.getX(), p.getY(), clusters[i].getCentroidX(), clusters[i].getCentroidY());
				}
				g.fillOval(clusters[i].getCentroidX()-5, clusters[i].getCentroidY()-5,10,10);
			}
		}
	}

}
