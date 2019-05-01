package automation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewUserController {
	private AnchorPane root;
	@FXML
	private Button createNewUser;
	@FXML
	private TextField newUserName;
	@FXML
	private PasswordField newUserPass;
	@FXML
	private void createNewUser() throws IOException {
		FileWriter file = new FileWriter("src/automation/data.txt", true); 
		String salt = Auth.generateSalt(256).toString();
		String hash = Auth.hashPassword(getPass(), salt).toString();
		BufferedWriter printer = new BufferedWriter(file);
		printer.write(salt);
		printer.newLine();
		printer.write(getUsername()+" "+hash);
		printer.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FXGUI.class.getResource("FxGUIlogin.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) createNewUser.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	private String getPass() {
		return newUserPass.getText();
	}
	private String getUsername() {
		return newUserName.getText();
	}
}
