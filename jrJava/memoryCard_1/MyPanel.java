package jrJava.memoryCard_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MyPanel extends JPanel {
	
	private int x;
	private int y;
	private int size;
	private Image image;
	
	public MyPanel() {
		x=50;
		y=50;
		size = 100;
		image = new ImageIcon("jrJava/memoryCard_1/apple.png").getImage();
	}
	
	
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(image, x, y, null);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x+5, y+5, size-10, size-10);
	
		}
	}
	





