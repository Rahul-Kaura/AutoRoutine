package automation;

import java.awt.AWTException;
import java.io.IOException;

public class Coordinator {
	public static void main(String[] args) throws AWTException, IOException {
		Auto robo = new Auto();
		GUI gui = new GUI();
		gui.authenticate();
	}
}
