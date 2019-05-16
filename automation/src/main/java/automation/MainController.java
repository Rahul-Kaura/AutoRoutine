package main.java.automation;

import java.awt.AWTException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
	@FXML
	private Button newRoutine;
	@FXML
	private Button executeRoutine;
	private boolean started = false;
	private Auto auto;
	@FXML
	private void newRoutine() {
		if (started==true) {
			auto.stopRecording();
		}
		else {
			auto = new Auto();
			newRoutine.setText("Stop routine");
			started=true;
			try {
				auto.learnRoutine();
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
	@FXML
	private void findExecRoutine() {
		
	}
}
