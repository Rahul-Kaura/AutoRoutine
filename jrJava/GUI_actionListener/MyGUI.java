package jrJava.GUI_actionListener;


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class MyGUI {

	private JFrame frame;
	private JPanel panel, smallPanel;
	private JButton button1, button2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lab1, imgLab1, imgLab2, imgLab3;
	private JTextField textField;
	
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem item1A, item1B, item1C, item1D, item2A, item2B;
	
	
	public MyGUI() {
		
		frame = new JFrame();
		frame.setBounds(300, 100, 500, 400); 
		frame.setTitle("My First GUI"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 500, 20);
		frame.add(menuBar);
		
		menu1 = new JMenu("Move");
		menu2 = new JMenu("Help");
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		item1A = new JMenuItem("Up");
		item1B = new JMenuItem("Down");
		item1C = new JMenuItem("Left");
		item1D = new JMenuItem("Right");
		item2A = new JMenuItem("Search");
		item2B = new JMenuItem("About");
		menu1.add(item1A);
		menu1.add(item1B);
		menu1.add(item1C);
		menu1.add(item1D);
		menu2.add(item2A);
		menu2.add(item2B); 
		
		panel = new JPanel();
		panel.setBounds(0, 20, 500, 350);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null); 
		frame.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 40, 300, 200);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		 
		lab1 = new JLabel("Type in:");
		lab1.setBounds(20, 250, 100, 20);
		panel.add(lab1);
		
		textField = new JTextField();
		textField.setBounds(20, 270, 300, 20);
		panel.add(textField);
		
		smallPanel = new JPanel();
		smallPanel.setBounds(340, 40, 100, 200);
		smallPanel.setBackground(Color.white);
		smallPanel.setLayout(null);
		panel.add(smallPanel);
		
		imgLab1 = new JLabel(new ImageIcon("jrJava/GUI_1/orangeAlien_1.png"));
		imgLab1.setBounds(10, 0, 80, 80);
		imgLab1.setText("GUI Demo");  
		imgLab1.setHorizontalTextPosition(JLabel.CENTER); 
		imgLab1.setVerticalTextPosition(JLabel.TOP);
		smallPanel.add(imgLab1);
		
		imgLab2 = new JLabel(new ImageIcon("jrJava/GUI_1/torpedo.png"));
		imgLab2.setBounds(10, 90, 80, 80);
		smallPanel.add(imgLab2);
		
		imgLab3 = new JLabel(new ImageIcon("jrJava/GUI_1/ship.png"));
		imgLab3.setBounds(10, 130, 80, 80);
		smallPanel.add(imgLab3);
		
		PQR pqr = new PQR();
		
		ABC abc = new ABC();
		
		button1 = new JButton("Buy");
		button1.setActionCommand("myBuyButton");
		button1.setBounds(350, 255, 80, 20); 
		button1.addActionListener(abc); 
		button1.addActionListener(pqr);
		panel.add(button1);
	
		DEF def = new DEF();
		
		button2 = new JButton("Sell");
		button2.setActionCommand("mySellButton");
		button2.setBounds(350, 285, 80, 20); 
		button2.addActionListener(def);
		button2.addActionListener(pqr); 
		panel.add(button2); 
		
		
		frame.setVisible(true); 
	}
	
	 
	
	public static void main(String[] args) {
		new MyGUI();
	}

}