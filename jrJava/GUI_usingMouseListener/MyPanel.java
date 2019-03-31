package jrJava.GUI_usingMouseListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


public class MyPanel extends JPanel {

	private int[] x, y, vx, vy, radius;
	private Color[] colors;
	
	private boolean shouldUseSingleColor;
	private Color singleColor;
	
	
	public MyPanel() {
		x = new int[] {300, 300, 300, 300, 300, 300, 300, 300, 300, 300};
		y = new int[] {200, 200, 200, 200, 200, 200, 200, 200, 200, 200 };
		vx = new int[] {10, 10, 11, 11, 12, 12, 13, 13, 14, 14 };
		vy = new int[] {11, -11, 12, -12, 13, -13, 14, -14, 15, -15};
		radius = new int[] {10, 15, 20, 25, 30, 35, 30, 25, 20, 15 };
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
			
			if(x[i]-radius[i]<0 || x[i]+radius[i]>getWidth()) vx[i] = -vx[i];
			if(y[i]-radius[i]<0 || y[i]+radius[i]>getHeight()) vy[i] = -vy[i];
		}
	}
	
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for(int i=0; i<radius.length; i++) {
			if(shouldUseSingleColor) g.setColor(singleColor);
			else g.setColor(colors[i]);
			g.fillOval(x[i]-radius[i], y[i]-radius[i], 2*radius[i], 2*radius[i]);
		}
	}
	
}




