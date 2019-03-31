package jrJava.memoryCard_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {

	public static final int SIZE = 100;
	private static Image[] images; 
	private static Image backSideImage;
	private static String[] imageNames = {"apple", "bank", "basketball",
			                              "bubble_blue", "bubble_green", "bubble_red",
			                              "building", "cat", "cheese",
			                              "denture", "dog", "hockey_stick",
			                              "keys", "phone", "pizza", 
			                              "santa", "soccer_ball", "sock",
			                              "toilet_bowl", "toilet_paper", "xmas_tree" };
	private int x, y; 
	private Image image;
	private boolean shouldReveal;
	

	static {
		images = new Image[imageNames.length];
		for(int i=0; i<images.length; i++) {
			images[i] = new ImageIcon("jrJava/memoryCard_1/" + imageNames[i] + ".png").getImage();
		}
		
		backSideImage = new ImageIcon("jrJava/memoryCard_1/backside.png").getImage();
	}
	
	
	public Card(int imageIndex, int x, int y) {
		image = images[imageIndex];
		this.x = x;
		this.y = y;
	}
	
	
	public void show() { shouldReveal = true; }
	public void hide() { shouldReveal = false; }
	
	
	public void draw(Graphics g) {
		if(shouldReveal) g.drawImage(image, x+10, y+10, SIZE-20, SIZE-20, null);
		else g.drawImage(backSideImage, x+10, y+10, SIZE-20, SIZE-20, null);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x+5, y+5, SIZE-10, SIZE-10);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, SIZE, SIZE);
		
	}
	
}
