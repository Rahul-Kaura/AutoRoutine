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
    private AnchorPane root;
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==loginButton){
        	if (authenticate()==false) {
        		incorrectUsername.setText("Incorrect Username or Password");
        	}
        	else {
        	MainController maincontroller = new MainController();
            maincontroller.initialize();
            root = maincontroller.getContent();
        	}
        	stage = (Stage) loginButton.getScene().getWindow();
        	root = getContent();
        }
        else{
            stage = (Stage) newUserButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FxGUInewuser.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
    	try {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXGUI.class.getResource("FxGUIlogin.fxml"));
        root = (AnchorPane) loader.load();
    	} catch (IOException e) {
    		e.printStackTrace();
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
		String salt = Auth.generateSalt(256).toString();
		String username = getUsername();
		String hashed = Auth.hashPassword(getPass(), salt).toString();
		String stuff=username+" "+hashed;
		FileReader file = new FileReader("data.txt");
		BufferedReader data = new BufferedReader(file);
		String line = data.readLine();
		while (line!=null) {
			if (stuff == data.readLine()) {
				data.close();
				return true;
			}
		}
		data.close();
		return false;
	}
    public Parent getContent() {
        return root;
    }
}
