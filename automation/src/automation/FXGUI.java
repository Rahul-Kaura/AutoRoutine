package automation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXGUI extends Application {
	private Stage primaryStage;
	private LoginController logincontroller;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage= primaryStage;
		this.primaryStage.setTitle("Auto Routine");
		initLoginGUI();
	}
	
	public void initLoginGUI() throws IOException {
	        // Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(FXGUI.class.getResource("FxGUIlogin.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
