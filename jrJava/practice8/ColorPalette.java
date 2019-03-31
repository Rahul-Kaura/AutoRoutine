package jrJava.practice8;

import java.awt.Color;
import java.awt.Graphics;

import resources.DrawingBoard;
import resources.Timer;

public class ColorPalette {

	public static void main(String[] args) {
		int tileSize = 20;
		int numberOfTiles = 30;
		int margin = 50;
		
		DrawingBoard board = new DrawingBoard(200,0,tileSize*numberOfTiles + 2*margin, tileSize*numberOfTiles + 2*margin);
		Graphics g = board.getCanvas();
		Timer timer = new Timer();
		board.clear();
		
		int i;
		int j;
		for(i=1; i<=numberOfTiles; i++)  {
			
			
			for(j=1;j<=numberOfTiles; j++) {
				
				Color tileColor = new Color(  255/numberOfTiles*i,255/numberOfTiles*j, 0 );
				
				g.setColor(tileColor);
				g.fillRect(margin + (i-1)*tileSize,margin+ (j-1)*tileSize,tileSize, tileSize);
				board.repaint();
					
				g.setColor(Color.BLACK);
				g.drawRect(margin + (i-1)*tileSize,margin+ (j-1)*tileSize,tileSize, tileSize);
		
		
				board.repaint();
				timer.pause(10);
			
	}

}
}
}
