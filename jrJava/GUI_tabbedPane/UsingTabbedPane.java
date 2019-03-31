package jrJava.GUI_tabbedPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class UsingTabbedPane {

	private JFrame frame;
	private JPanel panel;
	private JTabbedPane tabbed;
	private JPanel page1;
	private JScrollPane page2, page3;
	
	private String[] pageNames = {"Hawaii Trip", "Glacier National", "Miscellaneous"};
	
	public UsingTabbedPane() {
		
		frame = new JFrame("TabbedPane");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); 
		frame.add(panel);
		
		tabbed = new JTabbedPane();
		tabbed.setBackground(Color.WHITE);
		panel.add(tabbed);
		
		preparePage1();
		preparePage2();
		preparePage3();
		
		frame.setVisible(true);
	}
	
	
	private void preparePage1() {
		page1 = new JPanel();
		page1.setBackground(Color.WHITE);
		page1.setLayout(new GridLayout(2, 2));
		
		String[] imagePaths = {"kauai3.jpg", "kauai1.jpg", "kauai4.jpg", "kauai2.jpg"};
		for(int i=0; i<imagePaths.length; i++) {
			page1.add(new JLabel(new ImageIcon("jrJava/GUI_tabbedPane/" + imagePaths[i])));
		}
		
		tabbed.addTab(pageNames[0], page1);
	}
	
	private void preparePage2() {
		page2 = new JScrollPane();
		JLabel label = new JLabel(new ImageIcon("jrJava/GUI_tabbedPane/glacier_big.png"));
		page2.setViewportView(label);
		
		tabbed.addTab(pageNames[1], page2);
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
		
		tabbed.addTab(pageNames[2], page3);
	}
	
	
	public static void main(String[] args) {
		new UsingTabbedPane();
	}

}



