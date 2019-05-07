package main.java.automation;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import main.java.listener.KeyListener;
import main.java.listener.MouseListener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
public class Auto {
	// Incomplete Auto class that should be able to automate tasks
	// Currently working on implementing Key and Mouse Listeners using jnativehook
	private int screenHeight;
	private int screenWidth;
	private boolean startCapture = false;
	private ArrayList<BufferedImage> imgs;
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
	public void learnRoutine() throws AWTException {
		//This tracks the mouse and keyboard actions and writes to a txt file 
		addListeners();
		startCapture=true;
		while (startCapture==true) {
			BufferedImage image = takeScreenshot(new Rectangle(screenWidth, screenHeight));
			imgs.add(image);
		}
		System.out.println("Stopped recording");
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException e) {
			e.printStackTrace();
		}
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
	private BufferedImage takeScreenshot(Rectangle screenRect) throws AWTException {
			Robot rb = new Robot();
			BufferedImage img = rb.createScreenCapture(screenRect);
			return img;
	}
	public void stopRecording() {
		startCapture=false;
	}
}
