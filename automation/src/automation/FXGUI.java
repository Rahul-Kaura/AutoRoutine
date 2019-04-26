package automation;

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
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage= primaryStage;
		this.primaryStage.setTitle("Auto Routine");
		initLoginGUI();
	}
	public void initLoginGUI() throws IOException {
	        // Load root layout from fxml file.
	        LoginController logincontroller = new LoginController();
	        logincontroller.initialize();
	        Scene scene = new Scene(logincontroller.getContent());
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	//@FXML 
	//private void mainGUI(ActionEvent event) {
	//	try {
	//		//Scene scene = new Scene(mainLayout);
	//		//primaryStage.setScene(scene);
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//}
	//@FXML
	//private void newuserGUI() {
	//	try {
	//		Parent pane = FXMLLoader.load(getClass().getResource("/automation/FxGUInewuser.fxml"));
	//		primaryStage.getScene().setRoot(pane);
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//}

	public static void main(String[] args) {
		launch(args);
	}
}
