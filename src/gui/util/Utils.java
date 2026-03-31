package gui.util;

import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	public static Stage currentsStage(javafx.event.ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}

}
