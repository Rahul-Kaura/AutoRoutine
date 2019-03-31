package jrJava.GUI_usingRepaint.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyGUI {

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
		frame.add(panel);
		
		button = new MyButton();
		button.setBounds(250, 100, 150, 150);
		panel.add(button);
		
		frame.setVisible(true); 
	}
	
	
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







