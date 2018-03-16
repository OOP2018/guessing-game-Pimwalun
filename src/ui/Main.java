package ui;

import java.net.URL;


import guessinggame.NumberGame;
import guessinggame.PimwalunGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		NumberGame pGame = new PimwalunGame(50);
		try {
			URL url = getClass().getResource("Graphic.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: Graphic.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			
			GameController controller = loader.getController();
			controller.setpGame((PimwalunGame) pGame);
			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		CounterView view = new CounterView(pGame);
		pGame.addObserver(view);
		view.run();
		
		LastNumberView view2 = new LastNumberView(pGame);
		pGame.addObserver(view2);
		view2.run();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}