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
 * A Controller for a window that shows the value of a count from guess.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class CounterView extends Stage implements Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter of NumberGame to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a count from guess.
	 * @param game the NumberGame to show.
	 */
	public CounterView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	/**
	 * Ui for CounterView.
	 */
	private void initComponents() {
		stage = this;
		// components and containers for our window
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
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
		this.setTitle("Count");
		this.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}
	
	/**
	 * Display count number of guesses.
	 */
	public void displayCount() {
		label.setText( String.format("%2d", game.getCount()) );
	}

	/**
	 * Update count number of guesses.
	 */
	@Override
	public void update(Observable subject, Object info) {
		displayCount();
	}	
}
