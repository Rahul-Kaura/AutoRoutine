package automation;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import listener.KeyListener;
import listener.MouseListener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
public class Auto {
	// Incomplete Auto class that should be able to automate tasks
	// Currently working on implementing Key and Mouse Listeners using jnativehook
	private int screenHeight;
	private int screenWidth;
	private boolean startCapture = false;
	public Auto() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
	}
	public void roboAuto(String routinename) throws AWTException, FileNotFoundException {
		//This is supposed to open up a txt containing the preprogrammed routines and do it
		Robot rb = new Robot();
		FileReader file = new FileReader("src/automation/routines.txt");
		
		
	}
	public void learnRoutine() {
		//This tracks the mouse and keyboard actions and writes to a txt file 
		addListeners();
		
		
	}
	private static void addListeners() {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			e.printStackTrace();
		}
		KeyListener keylistener = new KeyListener();
		MouseListener mouselistener = new MouseListener();
		GlobalScreen.addNativeKeyListener(keylistener);
		GlobalScreen.addNativeMouseListener(mouselistener);
	}
	private void takeScreenshot(Rectangle screenRect) {
		try {
			Robot rb = new Robot();
			rb.createScreenCapture(screenRect);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
