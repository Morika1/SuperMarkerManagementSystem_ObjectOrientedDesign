package view;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ShowAllSalesCustomers {
	private Stage stage;
	private BorderPane bp;
	private ScrollPane printPane;
	private ArrayList<Label> customerNamesApplied;
	private Button mainMenu;
	private VBox customerAppliedBox;

	private int count;

	public ShowAllSalesCustomers(Stage primaryStage) {

		mainMenu = new Button("Return To Main Menu");
		printPane = new ScrollPane();
		customerNamesApplied = new ArrayList<Label>();
		printPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		printPane.setStyle("-fx-background-color:transparent;");
		customerAppliedBox = new VBox();
		printPane.setContent(customerAppliedBox);
		bp = new BorderPane();
		bp.setLeft(mainMenu);
		bp.setCenter(printPane);
		BorderPane.setMargin(mainMenu, new Insets(200, 0, 0, 50));
		BorderPane.setMargin(printPane, new Insets(100, 0, 0, 150));

		stage = primaryStage;
		Scene theScene = new Scene(bp, 2000, 1000);
		stage.setScene(theScene);
		stage.show();
	}

	public void mainMenu() {
		stage.close();
	}

	public void showCustomers(boolean toStart) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < customerNamesApplied.size(); i++) {

						Platform.runLater(() -> {
							customerAppliedBox.getChildren().add(customerNamesApplied.get(count));
							customerAppliedBox.setVisible(true);
							count++;
						});

						Thread.sleep(2000);
					}
				} catch (Exception e) {
				}

			}
		});

		if (toStart)
			thread.start();
		else
			thread.interrupt();
	}

	public void disableCustomersNames() {
		showCustomers(false);
	}

	public void addCustomersNames(ArrayList<String> names) {
		for (int i = 0; i < names.size(); i++) {
			customerNamesApplied.add(new Label(names.get(i)));
			customerNamesApplied.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		}
		showCustomers(true);
	}

	public void addEventToMainMenu(EventHandler<ActionEvent> mainMenuPressed) {
		mainMenu.setOnAction(mainMenuPressed);

	}

}
