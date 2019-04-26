package automation;

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
	private AnchorPane root;
	public void initialize() {
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
