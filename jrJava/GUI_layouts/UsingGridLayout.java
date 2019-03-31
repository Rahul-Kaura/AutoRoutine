package jrJava.GUI_layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class UsingGridLayout {

	private JFrame frame;
	private JPanel panel;
	private JButton[] buttons;
	
	
	public UsingGridLayout() {
	
		frame = new JFrame("Border Layout");
		frame.setBounds(200, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridLayout(5, 4));
		frame.add(panel);
		 
		buttons = new JButton[20];
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton("Button" + (i + 1)); 
			panel.add(buttons[i]);
		}
		
		frame.pack();
		frame.setVisible(true); 
	}
	
	
	public static void main(String[] args) {
		new UsingGridLayout();

	}

}
