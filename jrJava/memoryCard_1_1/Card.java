package jrJava.memoryCard_1_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {

	private int x, y; 
	private int size;
	private Image image;
	 
	
	public Card(int x, int y, Image image) {
		this.x = x;
		this.y = y;
		size = 100;
		this.image = image;
	}
	
	
	public boolean isSelected(int mouseX, int mouseY) {
		return false;
	}
	
	public void show() { }
	public void hide() { }
	
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x+5, y+5, size-10, size-10);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);
	}
}








