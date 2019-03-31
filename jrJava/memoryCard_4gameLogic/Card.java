package jrJava.memoryCard_4gameLogic;

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


	private int x, y; // card position
	private Image image;
	private boolean shouldReveal;
	private boolean matched;




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

	public void setMatched() {
		matched = true;
	}
	public boolean hasBeenMatched() {
		return matched;
	}
	public boolean matchWith(Card anotherCard) {
		// will check whether one card and the card 
		//which came in as a parameter is same or not

		return (this.image) == (anotherCard.image);
		// check to see whether the two references match
	}
	public void swapImages(Card anotherCard) {
		Image temp = image;
		image = anotherCard.image;
		anotherCard.image = temp;
	}

	public boolean isSelected(int mx, int my) {
		return mx>x && mx<x+SIZE && my>y && my<y+SIZE;
	}


	public void draw(Graphics g) { 
		if(matched) return;

		if(shouldReveal) g.drawImage(image, x+10,  y+10, SIZE-20, SIZE-20, null);
		else g.drawImage(backSideImage, x+10,  y+10, SIZE-20, SIZE-20, null);

		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x+5, y+5, SIZE-10, SIZE-10); 
		g.setColor(Color.BLACK);
		g.drawRect(x,  y, SIZE, SIZE); 
	}

}
