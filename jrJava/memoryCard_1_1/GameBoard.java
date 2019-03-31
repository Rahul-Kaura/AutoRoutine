package jrJava.memoryCard_1_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private Card[] cards;
	
	
	public GameBoard() {
		
		JFrame frame = new JFrame("Memory Card Game");
		frame.setBounds(200, 0, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		frame.add(this);
		
		cards = new Card[4];
		Image image1 = new ImageIcon("jrJava/memoryCard_1/apple.png").getImage();
		Image image2 = new ImageIcon("jrJava/memoryCard_1/cheese.png").getImage();
		
		cards[0] = new Card(50, 50, image1);
		cards[1] = new Card(150, 50, image2);
		cards[2] = new Card(250, 50, image2);
		cards[3] = new Card(350, 50, image1);
		
		frame.setVisible(true); 
	}
	
	 
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
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




