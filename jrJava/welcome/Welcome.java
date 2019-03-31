package jrJava.welcome;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import resources.DrawingBoard;

public class Welcome {

	public static void main(String[] args){
		
		DrawingBoard board = new DrawingBoard(0, 0, 1000, 600);
		Graphics2D canvas = board.getCanvas();
		
		Image welcome = new ImageIcon("jrJava/welcome/START.txt").getImage();
		canvas.drawImage(welcome, 0, 0, board);
		
		board.repaint();
		
	}
	
}
