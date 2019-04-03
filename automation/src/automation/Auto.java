package automation;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.*;
public class Auto {
	// Incomplete Auto class that is able to automate tasks
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	public void roboAuto() throws AWTException {
		//This is supposed to open up a txt containing the preprogrammed routines and do it
		Robot rb = new Robot();
		rb.mouseMove(screenWidth/2, screenHeight/2); //moves the mouse to the middle of the screen
	}
	public void learnRoutine() {
		//This tracks the mouse and keyboard actions and writes to a txt file 
	}
}
