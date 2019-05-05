package main.java.automation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		String salt = getHash();
		FileWriter file = new FileWriter("src/main/java/automation/data.txt", true); 
		String hash = Auth.hashPassword(getPass(), salt).toString();
		BufferedWriter printer = new BufferedWriter(file);
		printer.newLine();
		printer.write(getUsername()+" "+hash);
		printer.close();
		loadLogin();
	}
	private void loadLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FXGUI.class.getResource("FxGUIlogin.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) createNewUser.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	private String getHash() throws IOException {
		FileReader file = new FileReader("src/automation/data.txt");
		BufferedReader data = new BufferedReader(file);
		String line=data.readLine();
		data.close();
		return line;
	}
	private String getPass() {
		return newUserPass.getText();
	}
	private String getUsername() {
		return newUserName.getText();
	}
}
