package automation;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class NewUserController {
	private AnchorPane root;
	public void initialize() {
		//TODO Fix bug here where controller class is constructed infinitely
		try {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(FXGUI.class.getResource("FxGUImain.fxml"));
	        root = (AnchorPane) loader.load();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	        }
	}
	public Parent getContent() {
        return root;
    }
}
