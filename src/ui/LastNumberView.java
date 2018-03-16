package ui;

import java.util.Observable;
import java.util.Observer;


import guessinggame.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the guess number.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class LastNumberView extends Stage implements Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a guess number of NumberGame to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public LastNumberView(NumberGame pGame) {
		this.game = pGame;
		initComponents();
	}
	
	private void initComponents() {
		stage = this;
		// components and containers for our window
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		// make the label big enough
		label.setPrefWidth(144);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		this.setScene(scene);
		this.setTitle("Guess number");
		this.sizeToScene();
	}
	
	/** Show the window and update the guess number. */
	public void run() {
		stage.show();
		displayNumber(0);
	}
	
	public void displayNumber(int number) {
		label.setText( String.format("%2d", number) );
	}

	@Override
	public void update(Observable suject, Object info) {
		int number = (int) info;
		displayNumber(number);
	}	
}