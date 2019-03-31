package jrJava.GUI_usingKeyListener;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;



public class MyGUI implements KeyListener {

	private static JFrame frame;
	private static MyPanel panel;
	private static MyButton button;
	
	
	public MyGUI() {
		
		frame = new JFrame("Extending component");
		frame.setBounds(200, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		//panel.addMouseListener(this);
		frame.add(panel);
		//Sir will explan why he puts the thread to sleep because his computer is slow, and to give time for the AWT thread time to load
		button = new MyButton();
		button.setBounds(250, 100, 150, 150);
		
		panel.add(button);
		
		frame.setVisible(true);
		
		//frame.requestFocus();
		//frame.addKeyListener(this);
		
		//panel.requestFocus();
		//panel.addKeyListener(this);
		
		//button.requestFocus();
		//button.addKeyListener(this);
		
		panel.requestFocus();
		panel.addKeyListener(this);
	} 
	
	public void keyPressed(KeyEvent e) {
		{	
		char c = e.getKeyChar();
	//We are doing these steps so that wan we press a button if we press a button the balls change colors
		if(c=='r') {
			panel.useSingleColor(Color.RED);
			button.useSingleColor(Color.RED);
		}
		else if(c=='g') {
			panel.useSingleColor(Color.GREEN);
			button.useSingleColor(Color.GREEN);
		}
		else if(c=='b') {
			panel.useSingleColor(Color.BLUE);
			button.useSingleColor(Color.BLUE);
		}
		else if(c=='m') {
			panel.useSingleColor(null);
			button.useSingleColor(null);
		}
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	
	public static void main(String[] args) {
		new MyGUI();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { }
		
		
		while(true) {
			panel.moveCircle();
			button.moveCircle();
			
			//frame.repaint();
			panel.repaint();
			//button.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
		}
		
	}

}







