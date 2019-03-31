package jrJava.GUI_usingActionListener;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;


public class MyButton extends JButton {
	
	private int[] x, y, vx, vy, radius;
	private Color[] colors;
	
	private boolean shouldUseSingleColor;
	private Color singleColor;
	
	
	public MyButton() {
		x = new int[] {75, 75, 75, 75, 75, 75, 75, 75, 75, 75};
		y = new int[] {75, 75, 75, 75, 75, 75, 75, 75, 75, 75};
		vx = new int[] {4, 4, 5 ,5, 6, 6, 7, 7, 8, 8};
		vy = new int[] {5, -5, 6 ,-6 ,7 ,-7 ,8, -8, 9, -9};
		radius = new int[] {3, 5, 7, 9, 7, 5, 3, 4, 6, 8};
		colors = new Color[] {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.ORANGE,
				              Color.PINK, Color.YELLOW, Color.CYAN, Color.GRAY, Color.DARK_GRAY};
	}
	
	public void useSingleColor(Color singleColor) {
		if(singleColor==null) {
			shouldUseSingleColor = false;
			return;
		}
		shouldUseSingleColor = true;
		this.singleColor = singleColor;
	}
	
	
	
	public void moveCircle() {
		for(int i=0; i<radius.length; i++) {
			x[i] += vx[i];
			y[i] += vy[i];
			
			if(x[i]-radius[i]<10 || x[i]+radius[i]>getWidth()-10) vx[i] = -vx[i];
			if(y[i]-radius[i]<10 || y[i]+radius[i]>getHeight()-10) vy[i] = -vy[i];
		}
	}
	
	
	
	protected void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		if(getModel().isRollover()) g.setColor(Color.GREEN);
		if(getModel().isPressed()) g.setColor(Color.CYAN);
		g.fillRect(0,  0, getWidth(), getHeight()); 
		
		for(int i=0; i<radius.length; i++) {
			if(shouldUseSingleColor) g.setColor(singleColor);
			else g.setColor(colors[i]);
			g.fillOval(x[i]-radius[i], y[i]-radius[i], 2*radius[i], 2*radius[i]);
		}
	}
	
	
	protected void paintBorder(Graphics g) {
		int grayScale = 50;
		for(int i=0; i<10; i++) {
			g.setColor(new Color(grayScale+20*i ,grayScale+20*i ,grayScale+20*i));
			g.drawRect(i, i, getWidth()-2*i, getHeight()-2*i); 
		}
	}
	
}







