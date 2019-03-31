package jrJava.GUI_mixedLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class UsingMixedLayout {

	private JFrame frame;
	private JPanel main, opPanel, numPanel;
	private JTextField textField;
	private JLabel label;
	private JButton[] opButtons, numButtons;
	
	
	public UsingMixedLayout() {
		frame = new JFrame("Mixed Layouts");
		frame.setBounds(200, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		main = new JPanel();
		main.setBackground(Color.WHITE);
		main.setLayout(new BorderLayout(10, 10));
		main.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); 
		frame.add(main);
		
		opPanel = new JPanel();
		opPanel.setBackground(Color.WHITE);
		main.add(opPanel, BorderLayout.NORTH);
		
		numPanel = new JPanel();
		numPanel.setBackground(Color.WHITE);
		numPanel.setLayout(new GridLayout(4, 3));
		main.add(numPanel, BorderLayout.CENTER);
		
		textField = new JTextField();
		main.add(textField, BorderLayout.SOUTH);
		
		label = new JLabel(new ImageIcon("jrJava/GUI_mixedLayout/Sir.png"));
		main.add(label, BorderLayout.EAST);
		
		opButtons = new JButton[4];
		Font opFont = new Font("Courier", Font.BOLD, 20);
		String[] opNames = {"+", "-", "*", "/" };
		for(int i=0; i<opButtons.length; i++) {
			opButtons[i] = new JButton(opNames[i]);
			opButtons[i].setFont(opFont); 
			opPanel.add(opButtons[i]);
		}
		
		numButtons = new JButton[12];
		String[] numNames = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "", "0", ""}; 
		for(int i=0; i<numButtons.length; i++) {
			numButtons[i] = new JButton(numNames[i]);
			numPanel.add(numButtons[i]);
		}
		numButtons[9].setEnabled(false);
		numButtons[11].setEnabled(false);
		
		//frame.pack();
		frame.setVisible(true); 
	}
	 
	
	public static void main(String[] args) {
		new UsingMixedLayout();
	}

}






