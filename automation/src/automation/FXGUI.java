package automation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXGUI extends Application {
	@FXML
	private Button loginButton;
	@FXML
	private Button newUserButton;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	private Stage primaryStage;
	private AnchorPane rootLayout;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage= primaryStage;
		this.primaryStage.setTitle("Auto Routine");
		initGUI();
	}
	public void initGUI() {
		try {
	        // Load root layout from fxml file.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(FXGUI.class.getResource("FxGUIrecord.fxml"));
	        rootLayout = (AnchorPane) loader.load();
	        
	        // Show the scene containing the root layout.
	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		}
		

	public static void main(String[] args) {
		launch(args);
	}
}
