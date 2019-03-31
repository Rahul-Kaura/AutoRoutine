package jrJava.GUI_actionListener3;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Using2JFrames implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private JPanel page1;
	private JScrollPane page2, page3;
	private CardLayout cardLayout;
	private String[] pageNames = {"Hawaii Trip", "Glacier National", "Miscellaneous"};
	
	private JFrame buttonsFrame;
	private JPanel buttonsPanel;
	private JButton[] buttons;
	
	//cosmic suer class has 0 fields
	public Using2JFrames() {
		//Java split into three different things for our convenience so that we can overload
		//Container is more specialized component
		//Somethings are so heavy duty and complex that they cannot be containee
		//It is normally called a containee relationship tree
		//Focus today will be repaint method Today is Februaru 23
		//THey all do overriding of paint method, and will have own method of paint in sir's image
		//Components use special AWT thread
		//One of the two will get executed because of polymorphism
		//it will always call what the object really is
		//References are stored in the data structures inside each component/containee
		//If you get hold of AWT thread, don't make it do serious work because then it can't do it's own work
		//Paint requires graphics g or graphics card while repaint doesn't
		//Only AWT thread can access the graphic card
		//Any thread can call repaint os it doesn't require a parameter
		frame = new JFrame("Content Frame");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(cardLayout);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); 
		frame.add(panel);
		
		preparePage1();
		preparePage2();
		preparePage3();
		
		frame.setVisible(true);
		
		
		buttonsFrame = new JFrame("Control Frame");
		buttonsFrame.setBounds(750, 100, 400, 100);
		buttonsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.WHITE);
		buttonsFrame.add(buttonsPanel);
		
		buttons = new JButton[3];
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton(pageNames[i]); 
			buttonsPanel.add(buttons[i]);
			buttons[i].addActionListener(this); 
		}
		
		buttonsFrame.pack();
		buttonsFrame.setVisible(true);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) { }
		
		buttons[1].requestFocus();
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==buttons[0]) {
			cardLayout.show(panel, pageNames[0]);
			buttons[1].requestFocus();
		}
		else if(e.getSource()==buttons[1]) {
			cardLayout.show(panel, pageNames[1]);
			buttons[2].requestFocus();
		}
		else if(e.getSource()==buttons[2]) { 
			cardLayout.show(panel, pageNames[2]);
			buttons[0].requestFocus();
		}
		
	}
	
	
	
	
	private void preparePage1() {
		page1 = new JPanel();
		page1.setBackground(Color.WHITE);
		page1.setLayout(new GridLayout(2, 2));
		
		String[] imagePaths = {"kauai3.jpg", "kauai1.jpg", "kauai4.jpg", "kauai2.jpg"};
		for(int i=0; i<imagePaths.length; i++) {
			page1.add(new JLabel(new ImageIcon("jrJava/GUI_tabbedPane/" + imagePaths[i])));
		}
		
		panel.add(page1, pageNames[0]); 
	}
	
	private void preparePage2() {
		page2 = new JScrollPane();
		JLabel label = new JLabel(new ImageIcon("jrJava/GUI_tabbedPane/glacier_big.png"));
		page2.setViewportView(label);
		
		panel.add(page2, pageNames[1]); 
	}
	
	private void preparePage3() { 
		page3 = new JScrollPane();
		JPanel sPanel = new JPanel();
		sPanel.setBackground(Color.WHITE);
		sPanel.setLayout(new GridLayout(4, 4)); 
		
		String[] filePaths = { "banff1.jpg", "bryce1.jpg", "glacier1.jpg", "kauai5.jpg",
				               "maui1.jpg", "maui2.jpg", "maui3.jpg", "rocky1.jpg",
				               "rocky2.jpg", "yellow1.jpg", "yosemite1.jpg", "zion1.jpg",
				               "zion2.jpg", "zion3.jpg", "kauai2.jpg", "kauai3.jpg" };
		
		for(int i=0; i<filePaths.length; i++) {
			sPanel.add(new JLabel(new ImageIcon("jrJava/GUI_tabbedPane/" + filePaths[i])));
		}
		
		page3.setViewportView(sPanel); 
		
		panel.add(page3, pageNames[2]); 
	}
	
	
	
	public static void main(String[] args) {
		new Using2JFrames();
	}

}



