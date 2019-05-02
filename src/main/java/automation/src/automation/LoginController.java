package automation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Button loginButton;
	@FXML
	private Button newUserButton;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Label incorrectUsername;
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;
        
        if(event.getSource()==loginButton){
        	if (authenticate()==false) {
        		incorrectUsername.setText("Incorrect Username or Password");
        	}
        	else {
        	stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FxGUImain.fxml"));
        	}
        }
        else{
            stage = (Stage) newUserButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FxGUInewuser.fxml"));
        }
        if (root!=null) {
        	Scene scene = new Scene(root);
        	stage.setScene(scene);
        	stage.show();
        }
    }
    @FXML
	public String getPass() {
    	return passwordTextField.getText();
	}
    @FXML
    public String getUsername() {
    	return usernameTextField.getText();
    }
    public boolean authenticate() throws IOException {
    	FileReader file = new FileReader("src/automation/data.txt");
    	BufferedReader data = new BufferedReader(file);
    	String salt = data.readLine();
		String username = getUsername();
		String hashed = Auth.hashPassword(getPass(), salt).toString();
		String stuff=username+" "+hashed;
		String line = data.readLine();
		while (line!=null) {
			if (stuff.contentEquals(line)) {
				data.close();
				return true;
			}
			line=data.readLine();
		}
		data.close();
		return false;
	}
}
