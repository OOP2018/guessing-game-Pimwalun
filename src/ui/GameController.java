package ui;

import guessinggame.PimwalunGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {
	@FXML
	TextField textField;
	@FXML
	Button ok;
	@FXML
	Button cancle;
	@FXML
	Label label;

	PimwalunGame pGame;

	public void setpGame(PimwalunGame pGame) {
		this.pGame = pGame;
	}
	
	public void handleOk(ActionEvent event) {
		String text = textField.getText().trim();
		try {
			int value = Integer.parseInt(text);
			pGame.guess(value);
			label.setText(pGame.getMessage());
			textField.clear();
			label.setStyle("-fx-text-fill: black");
		} catch (NumberFormatException e) {
			label.setStyle("-fx-text-fill: red");
			label.setText("Invalid value");
			textField.clear();
		}
	}

	public void handleCancel(ActionEvent event) {
		Platform.exit();
	}
}
