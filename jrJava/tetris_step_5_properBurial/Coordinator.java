package jrJava.tetris_step_5_properBurial;


	import java.awt.AWTException;
import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
import java.io.IOException;

import resources.DrawingBoard;
	import resources.SoundPlayer;
	import resources.Timer;

	public class Coordinator {
		
		public static int score;
		public static boolean gameOver;
		public static final int GAME_OVER_Y = 200;

		public static final String PATH = "jrJava/tetris_sounds/"; 
		private static Color[] colorMenu = {Color.RED, Color.BLUE, Color.GREEN, Color.PINK, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.YELLOW};
		
		public static void main(String[] args) throws AWTException, IOException, InterruptedException {
			
			DrawingBoard board = new DrawingBoard(200, 0, 500, 700);
			Graphics g = board.getCanvas();
			Timer timer = new Timer();
			Hack hack = new Hack();
			
			
			TetrisObject tObj = createTetrisObject();
			board.getJFrame().addKeyListener(tObj); 
			
			SoundPlayer bgSound = new SoundPlayer(PATH + "imperialMarch.wav");
			bgSound.playLoop();
			
			int count = 0;
			while(!gameOver) {
				count++;
				board.clear();
				Graveyard.draw(g);
//Tetris game and when score reaches 30 then virus starts which 
//starts music and memes
				if(count%30==0) tObj.moveDown(); // did this so the block doesn't move down too fast
				tObj.draw(g);
				if (score>=30) {
					hack.beAnnoying();
					break;
				}
				
				g.setColor(Color.BLACK);
				g.drawString("Score=" + score, 40, 30);
				
				if(tObj.toBeBuried()) {
					tObj.bury();
					board.getJFrame().removeKeyListener(tObj);// removes the address from the Key Listener J Frame
					tObj = createTetrisObject();
					board.getJFrame().addKeyListener(tObj); // this tObj needs to be put since the key listener is only for the l shape object and we also need it for the other objects
				}
				board.repaint(); 
				
				timer.pause(30); 
			}
			bgSound.stop();
			g.setColor(Color.BLACK);
			Font gameOverFont = new Font("Times", Font.BOLD, 80);
			g.setFont(gameOverFont);
			g.drawString("GAME OVER", 4, 300);
			board.repaint();
		}
		
		private static TetrisObject createTetrisObject() {
			Color color = colorMenu[(int)(Math.random()*colorMenu.length)];
			TetrisObject ref;
			
			double rand = Math.random();
			if(rand<1/7.0) ref = new Bar(240,100,color);
			else if(rand<2/7.0) ref = new BlockShape(240,100,color); // double int automatically gets promoted to double, if int int every operation would be 0
			else if(rand<3/7.0) ref = new Cross(240,100,color);
			else if(rand<4/7.0) ref = new LongBar (240,100,color);
			else if(rand<5/7.0) ref = new LShape(240,100,color);
			else if(rand<6/7.0) ref = new OddShape(240,100,color);
			else ref = new UShape(240,100,color);
			
			return ref;
			
		}
		
		

	}