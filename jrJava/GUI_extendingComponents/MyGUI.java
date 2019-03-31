package jrJava.GUI_extendingComponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyGUI implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private MyButton button;
	

	
	public MyGUI() {
		System.out.println("Point 2" + Thread.currentThread().getId());
		
		frame = new JFrame("Extending component");
		frame.setBounds(200, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		frame.add(panel);
		//
		button = new MyButton();
		button.setBounds(250, 100, 120, 60);
		button.addActionListener(this);
		panel.add(button);
		//This means that we are creating a button for the jpanel
		
		System.out.println("Point 3" + Thread.currentThread().getId());
		frame.setVisible(true); 
		System.out.println("Point 4" + Thread.currentThread().getId());
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("The button notified me.");
		System.out.println("actionPerformed:" + Thread.currentThread().getId());
		
	}
	
	public static void main(String[] args) {
		System.out.println("Point 1" + Thread.currentThread().getId());
		new MyGUI();
		System.out.println("Point 5" + Thread.currentThread().getId());
	}

}
//We have made all three classes in this package interact,
//We have made a red circle appear, a button appear that whenever you touch i, the button glows blue, and we have created a border
//using the grayscale affect that Sir taught us







