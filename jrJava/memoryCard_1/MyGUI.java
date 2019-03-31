package jrJava.memoryCard_1;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;



public class MyGUI {

	private static JFrame frame;
	private static MyPanel panel;

	
	
	public MyGUI() {
		
		frame = new JFrame("Extending component");
		frame.setBounds(200, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		panel.setBackground(Color.WHITE);
		//panel.addMouseListener(this);
		frame.add(panel);
		//Sir will explain why he puts the thread to sleep because his computer is slow, and to give time for the AWT thread time to load
		
	
		
		frame.setVisible(true);
	}
		
	public static void main(String[] args) {
		new MyGUI();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { }
		
		
		while(true) {
		
		
			
			//frame.repaint();
			panel.repaint();
			//button.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
		}
		
	}

}







