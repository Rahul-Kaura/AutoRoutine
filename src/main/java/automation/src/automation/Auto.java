package automation;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;
public class Auto {
	// Incomplete Auto class that should be able to automate tasks
	// Currently working on implementing Key and Mouse Listeners using System Hook
	
	public void roboAuto(String routinename) throws AWTException, FileNotFoundException {
		//This is supposed to open up a txt containing the preprogrammed routines and do it
		Robot rb = new Robot();
		FileReader file = new FileReader("src/automation/routines.txt");
		
		
	}
//	public void learnRoutine() {
		//This tracks the mouse and keyboard actions and writes to a txt file 
	//}
	private static void getMouseLocation() {
		//mouse tracker
		GlobalMouseHook mouseHook = new GlobalMouseHook();
		GlobalMouseAdapter adapter = new GlobalMouseAdapter() {
			public ArrayList<GlobalMouseEvent> coordslist;
			private boolean run=true;
			@Override 
			public void mousePressed(GlobalMouseEvent event)  {
				coordslist.add(event);
			}
			
			@Override 
			public void mouseReleased(GlobalMouseEvent event)  {
				coordslist.add(event); 
			}
			
			@Override 
			public void mouseMoved(GlobalMouseEvent event) {
				coordslist.add(event); 
			}
			
			@Override 
			public void mouseWheel(GlobalMouseEvent event) {
				coordslist.add(event); 
			}
			public ArrayList getContent() {
				return coordslist;
			}
		};
		mouseHook.addMouseListener(adapter);
		//TODO Fix stupid bug here
		//return adapter.coordslist;
	}
	private static void getkeyPressed() {
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			private boolean run=true;
			private ArrayList<GlobalKeyEvent> keylist;
			@Override 
			public void keyPressed(GlobalKeyEvent event) {
				if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
					run = false;
				}
				keylist.add(event);
			}
			
			@Override 
			public void keyReleased(GlobalKeyEvent event) {
				keylist.add(event);
			}
		});
		
	}
}
