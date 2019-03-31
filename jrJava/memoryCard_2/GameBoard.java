package jrJava.memoryCard_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	public static final int NUM_OF_CARDS = 42;
	public static final int NUM_OF_COLS = 7;
	public static final int MARGIN = 20;
	
	private Card[] cards;
	
	
	public GameBoard() {
		
		JFrame frame = new JFrame("Memory Card Game");
		frame.setBounds(200, 0, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.add(this);
		
		cards = new Card[NUM_OF_CARDS];
		
		for(int i=0; i<cards.length; i++) {
			cards[i] = new Card(i/2, MARGIN + i%NUM_OF_COLS*Card.SIZE, MARGIN + i/NUM_OF_COLS*Card.SIZE);
			if(i%2==0) cards[i].show();
		}
		
		frame.setVisible(true); 
	}
	
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for(int i=0; i<cards.length; i++) cards[i].draw(g); 
	}
	
	  

	public static void main(String[] args) {
		new GameBoard();
		
		while(true) {
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
		}
		
	}
	
}




