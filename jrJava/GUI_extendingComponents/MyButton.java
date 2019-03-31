package jrJava.GUI_extendingComponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;


public class MyButton extends JButton {

	
	protected void paintComponent(Graphics g) {
		System.out.println("paintComponent:" + Thread.currentThread().getId());
		g.setColor(Color.WHITE);
		if(getModel().isRollover()) g.setColor(Color.GREEN);
		if(getModel().isPressed()) g.setColor(Color.CYAN);
		//This is making the background color of the jbutton turn blue when it is pressed
		//This is the mouse listener in work, listening to our keyboard/trackpad press the button
		g.fillRect(0, 0, getWidth(), getHeight());	
		g.setColor(Color.BLUE);
		g.drawString("Hello!", 30, 20);
		
		g.setColor(Color.BLACK);
		g.drawString("Hello!", 30,35);
		
		g.setColor(Color.RED);
		g.drawString("Hi.", 30,50);
	}
	
	protected void paintBorder(Graphics g) {
		System.out.println("paintBorder:" + Thread.currentThread().getId());
		int grayScale = 50;
		for(int i=0; i<10; i++) {
			g.setColor(new Color(grayScale+20*i,grayScale+20*i,grayScale+20*i));
			g.drawRect(i, i,getWidth()-2*i ,getHeight()-2*i );
		}
	}
	
}
