package jrJava.GUI_actionListener2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MyGUI implements ActionListener {

	private JFrame frame;
	private JPanel panel, smallPanel;
	private JButton button1, button2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lab1, imgLab1, imgLab2, imgLab3;
	private JTextField textField;

	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem item1A, item1B, item1C, item1D, item1E, item2A, item2B;


	public MyGUI() {

		frame = new JFrame();
		frame.setTitle("My First GUI");
		frame.setBounds(300, 100, 500, 400);
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
		item1E = new JMenuItem("Center");
		item2A = new JMenuItem("Search");
		item2B = new JMenuItem("About");

		menu1.add(item1A);
		menu1.add(item1B);
		menu1.add(item1C);
		menu1.add(item1D);
		menu1.add(item1E);
		menu2.add(item2A);
		menu2.add(item2B);

		item1A.addActionListener(this);
		item1B.addActionListener(this);
		item1C.addActionListener(this);
		item1D.addActionListener(this);
		item1E.addActionListener(this);

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
		textField.addActionListener(this); 
		panel.add(textField);

		smallPanel = new JPanel();
		smallPanel.setBounds(340, 40, 100, 200);
		smallPanel.setBackground(Color.WHITE);
		smallPanel.setLayout(null); 
		panel.add(smallPanel);

		imgLab1 = new JLabel("GUI Demo", 
				new ImageIcon("jrJava/GUI_1/orangeAlien_1.png"), 
				JLabel.CENTER); 
		imgLab1.setVerticalTextPosition(JLabel.TOP); 
		imgLab1.setHorizontalTextPosition(JLabel.CENTER);
		imgLab1.setBounds(10, 0, 80, 80);
		smallPanel.add(imgLab1);

		imgLab2 = new JLabel("", 
				new ImageIcon("jrJava/GUI_1/torpedo.png"), 
				JLabel.CENTER); 
		imgLab2.setVerticalTextPosition(JLabel.TOP); 
		imgLab2.setHorizontalTextPosition(JLabel.CENTER);
		imgLab2.setBounds(10, 90, 80, 80);
		smallPanel.add(imgLab2);

		imgLab3 = new JLabel("", 
				new ImageIcon("jrJava/GUI_1/ship.png"), 
				JLabel.CENTER); 
		imgLab3.setVerticalTextPosition(JLabel.TOP); 
		imgLab3.setHorizontalTextPosition(JLabel.CENTER);
		imgLab3.setBounds(10, 130, 80, 80);
		smallPanel.add(imgLab3);

		button1 = new JButton("Shoot"); 
		button1.setBounds(350, 255, 80, 20);
		button1.addActionListener(this); 
		panel.add(button1); 

		button2 = new JButton("Abort"); 
		button2.setBounds(350, 285, 80, 20);
		button2.addActionListener(this); 
		panel.add(button2); 

		frame.setVisible(true); 
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) { }
		
		//textField.requestFocus();
		button1.requestFocus();
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==button1) {
			//textField.setText("A Torpedo got shot!");
			//textArea.setText("Attention, world citizens! \nA torpedo has been launched!"); 
			//imgLab2.setBounds(10, 40, 80, 80); 
			textField.requestFocus();
		}
		else if(e.getSource()==button2) {
			//textField.setText("A Torpedo got cancelled!");
			//textArea.setText("False alert! Torpedo did not get launched!"); 
			//imgLab2.setBounds(10, 90, 80, 80);
			textArea.requestFocus();
		}
		
		else if(e.getSource()==item1A) {
			smallPanel.setBounds(340, 20, 100, 200);
		}
		else if(e.getSource()==item1B) {
			smallPanel.setBounds(340, 60, 100, 200);
		}
		else if(e.getSource()==item1C) {
			smallPanel.setBounds(320, 40, 100, 200);
		}
		else if(e.getSource()==item1D) {
			smallPanel.setBounds(360, 40, 100, 200);
		}
		else if(e.getSource()==item1E) {
			smallPanel.setBounds(340, 40, 100, 200);
		}
		
		else if(e.getSource()==textField) {
			String text = textField.getText();
			textArea.setText(textArea.getText() + "\n" + text + "\n" + text + "\n" + text); 
		}
	}


	public static void main(String[] args) {
		new MyGUI();
	}

}
