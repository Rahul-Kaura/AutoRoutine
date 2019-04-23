package automation;

import javafx.stage.Stage;
import java.io.IOException;

import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.OpenCVFrameConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
public class FXGUI {
	@FXML
	private Button startRecord;
	@FXML
	private ImageView imagePanel;
	private boolean cameraActive = false;
	public static FFmpegFrameRecorder recorder=null;
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxGUI.fxml"));
		BorderPane root = (BorderPane) loader.load();
	}
	
}
