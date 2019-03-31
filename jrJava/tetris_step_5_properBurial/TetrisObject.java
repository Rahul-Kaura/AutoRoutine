package jrJava.tetris_step_5_properBurial;

	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;

	import resources.SoundPlayer;

	public abstract class TetrisObject implements KeyListener {

		protected Block[] blocks;
		protected int x;
		protected int y;
		protected Color color;
		protected boolean toBeBuried;
		
		private SoundPlayer shift, arrow, bubble;
		
		
		public TetrisObject(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
			
			shift = new SoundPlayer(Coordinator.PATH + "shift.wav");
			arrow = new SoundPlayer(Coordinator.PATH + "arrow.wav");
			bubble = new SoundPlayer(Coordinator.PATH + "bubbling.wav");
			
			formShape();
		}
		
		protected abstract void formShape();
		
		protected void updateBlocks() {
			for(int i=0; i<blocks.length; i++) {
				blocks[i].updatePosition(x, y); 
			}
		}
		
		
		public void bury() {
			for(int i=0; i<blocks.length; i++) {
				Graveyard.bury(blocks[i]); 
			}
		}
		public boolean toBeBuried() {
			return toBeBuried;
		}
		
		
		public void moveDown() { 
			y += Block.SIZE;
			updateBlocks();
			
			if(isIllegalMove()) {
				toBeBuried = true;
				y -= Block.SIZE;
				updateBlocks();
				return;
			}
			
			bubble.play();
		}
		
		private void hardDrop() { // hardDrop: method when right arrow is pressed, if toBeBuried is true(means it has gone off the picture then it will stop the moving down of the blocks, if player presses down arrow it will move to bottom directly
			while (!toBeBuried) {
				moveDown();
			}
		}
		
		private void shiftLeft() { 
			x -= Block.SIZE;
			updateBlocks();
			
			if(isIllegalMove()) {
				x += Block.SIZE;
				updateBlocks();
				return;
			}
			
			shift.play();
		}
		
		private void shiftRight() { 
			x += Block.SIZE;
			updateBlocks();
			
			if(isIllegalMove()) {
				x -= Block.SIZE;
				updateBlocks();
				return;
			}
			
			shift.play();
		}
		
		private void rotate() {
			for(int i=0; i<blocks.length; i++) {
				blocks[i].rotate();
			}
			updateBlocks();
			
			if(isIllegalMove()) {
				int i, k;
				for(k=0; k<3; k++) {
					for(i=0; i<blocks.length; i++) {
						blocks[i].rotate();
					}
				}
				updateBlocks();
				return;
			}
			
			arrow.play();
		}
		
		
		private void mirror() {
			for(int i=0; i<blocks.length; i++) {
				blocks[i].mirror();
			}
			updateBlocks();
			
			if(isIllegalMove()) {
				for(int i=0; i<blocks.length; i++) {
					blocks[i].mirror();
				}
				updateBlocks();
				return;
			}
			
			arrow.play();
		}
		
		/*
		 * This method will check if any of the tetrisObject blocks
		 * gets outside the grave yard boundary.
		 * It also will check if it overlaps with already occupied blocks
		 * of the grave yard.
		 */
		private boolean isIllegalMove() {
			for(int i=0; i<blocks.length; i++) {
				if(blocks[i].getX()<Graveyard.X_LEFT ||
				   blocks[i].getX()>=Graveyard.X_RIGHT ||
				   blocks[i].getY()>=Graveyard.Y_BOTTOM ||
				   Graveyard.isOccupied(blocks[i].getX(), blocks[i].getY())) return true;
			}
			return false;
		}
		
		
		public void draw(Graphics g) {
			for(int i=0; i<blocks.length; i++) {
				blocks[i].draw(g); 
			}
		}
		
		
		public void keyPressed(KeyEvent e) { 
			int keyCode = e.getKeyCode();
			
			if(keyCode==KeyEvent.VK_LEFT) shiftLeft();
			else if(keyCode==KeyEvent.VK_RIGHT) shiftRight();
			else if(keyCode==KeyEvent.VK_DOWN) hardDrop();
			else if(keyCode==KeyEvent.VK_R) rotate(); 
			else if(keyCode==KeyEvent.VK_M) mirror(); 
		}
		
		
		public void keyTyped(KeyEvent e) { }
		public void keyReleased(KeyEvent e) { }
		
	}