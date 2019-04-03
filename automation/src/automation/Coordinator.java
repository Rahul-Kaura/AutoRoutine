package automation;

import java.awt.AWTException;
import java.io.IOException;

public class Coordinator {
	//main thing, everything executed here
	public static void main(String[] args) throws AWTException, IOException {
		Auto robo = new Auto();
		GUI gui = new GUI();
		if (gui.authenticate()==false) {
			System.exit(0);
		}
	}
}
