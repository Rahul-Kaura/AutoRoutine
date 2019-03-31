package jrJava.practice8;

import java.awt.Color;
import java.awt.Graphics;

import resources.DrawingBoard;
import resources.Timer;

public class MakeRedCircleMoveAroundDrawingBoard {

	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(500, 500, 900, 900);
		Graphics g = board.getCanvas();
		Timer timer = new Timer();

		int i, j;
	
			
			// Moving from top-right corner to bottom-right corner.
			int z = 300;
			int m = 500;
			int madius = 50;
			for(j=1; j<100; j++) {
				m -= 5;
				board.clear();
				g.setColor(Color.BLUE);
				g.fillOval(z-madius, m-madius, 2*madius, 2*madius);
				board.repaint();
				timer.pause(20);
			}
			
			int c = 100;
			int n = 500;
			int radius = 50;
			for(j=1; j<100; j++) {
				n -= 5;
				board.clear();
				g.setColor(Color.GREEN);
				g.fillOval(c-radius, n-radius, 2*radius, 2*radius);
				board.repaint();
				timer.pause(20);
				
			

			
		
			}	

			
			int l = 200;
			int f = 500;
			int cadius = 50;
			for(j=1; j<100; j++) {
				f -= 5;
				board.clear();
				g.setColor(Color.RED);
				g.fillOval(l-radius, f-radius, 2*cadius, 2*cadius);
				board.repaint();
				timer.pause(20);
			
		}
}
			
}	
	

	

	

