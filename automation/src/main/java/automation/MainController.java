package main.java.automation;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController {
	@FXML
	private Button newRoutine;
	@FXML
	private Button executeRoutine;
	@FXML
	private void createNewRoutine() {
		Auto auto = new Auto();
		auto.learnRoutine();
	}
	@FXML
	private void findExecRoutine() {
		
	}
}
