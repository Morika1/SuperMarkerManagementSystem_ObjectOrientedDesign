package main;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import view.View;

public class Program extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Store store = Store.getInstance("6940956043", 0);
		View theView = new View(primaryStage);
		Controller theController = new Controller(store, theView);
	}

}
