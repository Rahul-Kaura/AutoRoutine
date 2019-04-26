package automation;

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
    private AnchorPane root;
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==loginButton){
        	MainController maincontroller = new MainController();
            stage = (Stage) loginButton.getScene().getWindow();
            maincontroller.initialize();
            root = maincontroller.getContent();
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
    public Parent getContent() {
        return root;
    }
}
