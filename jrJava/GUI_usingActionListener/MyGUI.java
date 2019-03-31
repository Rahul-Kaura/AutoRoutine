package jrJava.GUI_usingActionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyGUI implements ActionListener {

	private static JFrame frame;
	private static MyPanel panel;
	private static MyButton button;
	private JButton redB, greenB, blueB, multiB;
	
	
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
		
		redB = new JButton("Red");
		redB.setBounds(100, 10, 80, 20);
		redB.addActionListener(this);
		panel.add(redB);
		
		greenB = new JButton("Green");
		greenB.setBounds(200, 10, 80, 20);
		greenB.addActionListener(this);
		panel.add(greenB);
		
		blueB = new JButton("Blue");
		blueB.setBounds(300, 10, 80, 20);
		blueB.addActionListener(this);
		panel.add(blueB);
		
		multiB = new JButton("Multi");
		multiB.setBounds(400, 10, 80, 20);
		multiB.addActionListener(this);
		panel.add(multiB);
		
		frame.setVisible(true); 
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==redB) {
			panel.useSingleColor(Color.RED);
			button.useSingleColor(Color.RED);
		}
		else if(e.getSource()==greenB) {
			panel.useSingleColor(Color.GREEN);
			button.useSingleColor(Color.GREEN);
		}
		else if(e.getSource()==blueB) {
			panel.useSingleColor(Color.BLUE);
			button.useSingleColor(Color.BLUE);
		}
		else if(e.getSource()==multiB) {
			panel.useSingleColor(null);
			button.useSingleColor(null);
		}
		
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







