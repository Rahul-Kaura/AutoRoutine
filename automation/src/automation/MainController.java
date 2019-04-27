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
	private Auto auto;
	public Parent getContent() {
        return root;
    }
}
