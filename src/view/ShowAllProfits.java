package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ShowAllProfits {

	private Stage stage;
	private BorderPane bp;
	private Label profitText;
	private Button mainMenu;

	public ShowAllProfits(Stage primaryStage, String res) {
		profitText = new Label(res);
		profitText.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		mainMenu = new Button("Return To Main Menu");

		bp = new BorderPane();
		bp.setLeft(mainMenu);
		bp.setCenter(profitText);
		BorderPane.setMargin(mainMenu, new Insets(200, 0, 0, 50));
		BorderPane.setMargin(profitText, new Insets(0, 600, 450, 0));

		stage = primaryStage;
		Scene theScene = new Scene(bp, 2000, 1000);
		stage.setScene(theScene);
		stage.show();
	}

	public void mainMenu() {
		stage.close();
	}

	public void addEventToMainMenu(EventHandler<ActionEvent> mainMenuPressed) {
		mainMenu.setOnAction(mainMenuPressed);

	}
}
