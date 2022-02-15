package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import command.MenuCommands;

public class ShowProductByCatalogNumber {
	private Stage stage;
	private BorderPane bp;
	private Button mainMenu;
	private Button print;
	private Label printText;
	private Text serialNumber;
	private TextField serialNumberTextField;
	private VBox serialNumberBox;

	public ShowProductByCatalogNumber(Stage primaryStage) {

		serialNumber = new Text("Product Catalog Number");
		serialNumberTextField = new TextField();
		serialNumberTextField.setMaxSize(200, 20);
		print = new Button("Print Product");
		serialNumberBox = new VBox();
		serialNumberBox.getChildren().addAll(serialNumber, serialNumberTextField, print);
		serialNumberBox.setSpacing(50);
		VBox.setMargin(serialNumber, new Insets(0, 0, 0, 30));
		VBox.setMargin(print, new Insets(0, 0, 0, 60));
		mainMenu = new Button("Return To Main Menu");
		printText = new Label();
		printText.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

		bp = new BorderPane();
		bp.setTop(serialNumberBox);
		bp.setLeft(mainMenu);
		bp.setBottom(printText);
		BorderPane.setMargin(serialNumberBox, new Insets(150, 0, 0, 900));
		BorderPane.setMargin(mainMenu, new Insets(0, 0, 0, 200));
		BorderPane.setMargin(printText, new Insets(0, 0, 400, 300));

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

	public void print(MenuCommands menu) {
		if (serialNumberTextField.getText().isEmpty()) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must fill Product Catalog Number!");
			msg.show();
			return;
		}
		String serialNumber = serialNumberTextField.getText();
		printText.setText(menu.findProductByserialNum(serialNumber));
	}

	public void addEventToPrint(EventHandler<ActionEvent> printPressed) {
		print.setOnAction(printPressed);

	}
}
