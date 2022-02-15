package view;

import java.io.IOException;

import command.MenuCommands;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Store;
import main.Customer;
import main.Product;

public class View {

	// buttons:
	private Stage stage;
	private BorderPane borderPane;
	private Label storeName;
	private Label addAProduct;
	private Button showAllProducts;
	private Button showAllSalesCustomers;
	private Button showProductByCatalogNumber;
	private Button showAllProfits;
	private Button undo;
	private Button removeProductByCatalogNumber;
	private Button removeAllProducts;
	private Button sendMessageOnSales;
	private Button saveProductsByCatalogNumberInMapAscending;
	private Button saveProductsByCatalogNumberInMapDescending;
	private Button saveProductsByInsertOrderInMap;
	private Button saveChanges;
	private Button exit;

	private TextField productName;
	private TextField productsMakat;
	private TextField priceForStore;
	private TextField priceForCustomer;
	private TextField customersName;
	private TextField customersPhone;

	private Text productNameText;
	private Text productsNumberText;
	private Text priceForStoreText;
	private Text priceForCustomerText;
	private Text customerNameText;
	private Text customerPhoneText;
	private Text customerSalesText;

	private CheckBox customerWantSalesUpdate;
	private VBox texts;
	private VBox textFields;
	private HBox textsAndFields;
	private HBox save;
	private VBox addAProductTextAndFields;
	private VBox saveBox;

	public View(Stage primaryStage) {
		// buttons:
		showAllProducts = new Button("Show all products");
		showAllProducts.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllProducts.setPrefSize(400, 30);
		showAllProducts.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllProducts.setTextFill(Color.WHITE);

		showAllSalesCustomers = new Button("Show all customers want sales");
		showAllSalesCustomers.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllSalesCustomers.setPrefSize(400, 30);
		showAllSalesCustomers
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllSalesCustomers.setTextFill(Color.WHITE);

		showProductByCatalogNumber = new Button("Show product by catalog number");
		showProductByCatalogNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showProductByCatalogNumber.setPrefSize(400, 30);
		showProductByCatalogNumber
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showProductByCatalogNumber.setTextFill(Color.WHITE);

		showAllProfits = new Button("Show all profits");
		showAllProfits.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		showAllProfits.setPrefSize(400, 30);
		showAllProfits.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		showAllProfits.setTextFill(Color.WHITE);

		undo = new Button("Undo");
		undo.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		undo.setPrefSize(400, 30);
		undo.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		undo.setTextFill(Color.WHITE);

		removeProductByCatalogNumber = new Button("Remove product by catalog number");
		removeProductByCatalogNumber.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		removeProductByCatalogNumber.setPrefSize(400, 30);
		removeProductByCatalogNumber
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		removeProductByCatalogNumber.setTextFill(Color.WHITE);

		removeAllProducts = new Button("Remove all products");
		removeAllProducts.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		removeAllProducts.setPrefSize(400, 30);
		removeAllProducts.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		removeAllProducts.setTextFill(Color.WHITE);

		sendMessageOnSales = new Button("Send message on sales");
		sendMessageOnSales.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		sendMessageOnSales.setPrefSize(400, 30);
		sendMessageOnSales
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		sendMessageOnSales.setTextFill(Color.WHITE);

		saveProductsByCatalogNumberInMapDescending = new Button("Save products by catalog number in descending order");
		saveProductsByCatalogNumberInMapDescending.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		saveProductsByCatalogNumberInMapDescending.setPrefSize(400, 30);
		saveProductsByCatalogNumberInMapDescending
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		saveProductsByCatalogNumberInMapDescending.setTextFill(Color.WHITE);

		saveProductsByCatalogNumberInMapAscending = new Button("Save products by catalog number in ascending order");
		saveProductsByCatalogNumberInMapAscending.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		saveProductsByCatalogNumberInMapAscending.setPrefSize(400, 30);
		saveProductsByCatalogNumberInMapAscending
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		saveProductsByCatalogNumberInMapAscending.setTextFill(Color.WHITE);

		saveProductsByInsertOrderInMap = new Button("Save products by insert order");
		saveProductsByInsertOrderInMap.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		saveProductsByInsertOrderInMap.setPrefSize(400, 30);
		saveProductsByInsertOrderInMap
				.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		saveProductsByInsertOrderInMap.setTextFill(Color.WHITE);

		saveChanges = new Button("Save changes");
		saveChanges.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		saveChanges.setPrefSize(400, 30);
		saveChanges.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		saveChanges.setTextFill(Color.WHITE);

		exit = new Button("Exit");
		exit.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		exit.setPrefSize(400, 30);
		exit.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		exit.setTextFill(Color.WHITE);

		showAllSalesCustomers.setDisable(true);

		// outputs:
		storeName = new Label();
		storeName.setText("Welcome to our store");
		storeName.setLayoutX(500);
		storeName.setLayoutY(500);
		storeName.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		storeName.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		storeName.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		storeName.setTextFill(Color.WHITE);
		storeName.setWrapText(true);
		storeName.setMaxWidth(375);
		storeName.wrapTextProperty();

		addAProduct = new Label();
		addAProduct.setText("To add a product fill the following:");
		addAProduct.setLayoutX(500);
		addAProduct.setLayoutY(500);
		addAProduct.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		addAProduct.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		addAProduct.setStyle("-fx-background-color: #50a08d;-fx-border-color: #a0a0a0;-fx-border-width: 3 3 3 3");
		addAProduct.setTextFill(Color.WHITE);
		addAProduct.setWrapText(true);
		addAProduct.setMaxWidth(375);
		addAProduct.wrapTextProperty();

		saveBox = new VBox();
		saveBox.getChildren().addAll(saveProductsByCatalogNumberInMapAscending,
				saveProductsByCatalogNumberInMapDescending, saveProductsByInsertOrderInMap, showProductByCatalogNumber,
				showAllProducts, removeProductByCatalogNumber, removeAllProducts, showAllProfits, sendMessageOnSales,
				showAllSalesCustomers, exit);
		saveBox.setSpacing(20);

		addAProductTextAndFields = new VBox();
		addAProductTextAndFields.getChildren().add(addAProduct);

		productName = new TextField();
		productsMakat = new TextField();
		priceForStore = new TextField();
		priceForCustomer = new TextField();
		customersName = new TextField();
		customersPhone = new TextField();
		customerWantSalesUpdate = new CheckBox();

		textFields = new VBox();
		textFields.getChildren().addAll(productsMakat, productName, priceForStore, priceForCustomer, customersName,
				customersPhone, customerWantSalesUpdate);
		textFields.setSpacing(10);

		productNameText = new Text("Product's name");
		productsNumberText = new Text("Product's catalog number");
		priceForStoreText = new Text("Product's price for store");
		priceForCustomerText = new Text("Product's price for customer");
		customerNameText = new Text("Customer's name");
		customerPhoneText = new Text("Customer's phone");
		customerSalesText = new Text("Does customer want sales update?");

		texts = new VBox();
		texts.getChildren().addAll(productsNumberText, productNameText, priceForStoreText, priceForCustomerText,
				customerNameText, customerPhoneText, customerSalesText);
		texts.setSpacing(21);
		HBox.setMargin(productNameText, new Insets(0, 0, 0, 100));
		HBox.setMargin(productsNumberText, new Insets(0, 0, 0, 10));
		HBox.setMargin(priceForStoreText, new Insets(0, 0, 0, 100));
		HBox.setMargin(priceForCustomerText, new Insets(0, 0, 0, 85));
		HBox.setMargin(customerNameText, new Insets(0, 0, 0, 95));
		HBox.setMargin(customerPhoneText, new Insets(0, 0, 0, 120));
		HBox.setMargin(customerSalesText, new Insets(0, 0, 0, 50));

		textsAndFields = new HBox();
		textsAndFields.getChildren().addAll(texts, textFields);
		textsAndFields.setSpacing(20);

		save = new HBox();
		save.getChildren().addAll(saveChanges, undo);
		save.setSpacing(50);

		borderPane = new BorderPane();
		borderPane.setCenter(saveBox);
		borderPane.setRight(textsAndFields);
		borderPane.setTop(storeName);
		borderPane.setBottom(save);

		BorderPane.setMargin(storeName, new Insets(20, 0, 0, 950));
		BorderPane.setMargin(saveBox, new Insets(20, 0, 0, 20));
		BorderPane.setMargin(textsAndFields, new Insets(300, 250, 0, 0));
		BorderPane.setMargin(save, new Insets(0, 0, 200, 900));

		saveWithoutSorting();
		stage = primaryStage;
		Scene theScene = new Scene(borderPane, 2000, 1000);
		stage.setScene(theScene);
		stage.show();
	}

	// show view+connection to the Model
	public void addEventToSaveASCOrder(EventHandler<ActionEvent> saveASCPressed) {
		saveProductsByCatalogNumberInMapAscending.setOnAction(saveASCPressed);
	}

	public void saveASCOrder(MenuCommands menu) throws Exception {
		saveWithNoOptions();
		notAllowSaving();
		showView();
		undo.setDisable(true);
		menu.setSort(1);
	}

	public void addEventTosaveDESCOrder(EventHandler<ActionEvent> saveDESCPressed) {
		saveProductsByCatalogNumberInMapDescending.setOnAction(saveDESCPressed);
	}

	public void saveDESCOrder(MenuCommands menu) throws Exception {
		saveWithNoOptions();
		notAllowSaving();
		showView();
		undo.setDisable(true);
		menu.setSort(2);
	}

	public void addEventTosaveByOrder(EventHandler<ActionEvent> saveByOrderPressed) {
		saveProductsByInsertOrderInMap.setOnAction(saveByOrderPressed);
	}

	public void saveByOrder(MenuCommands menu) throws Exception {
		saveWithNoOptions();
		notAllowSaving();
		showView();
		undo.setDisable(true);
		menu.setSort(3);
	}

	public void addEventToFindProductByNumber(EventHandler<ActionEvent> printOnePressed) {
		showProductByCatalogNumber.setOnAction(printOnePressed);
	}

	public void addEventToPrintAll(EventHandler<ActionEvent> printAllPressed) {
		showAllProducts.setOnAction(printAllPressed);
	}

	public void addEventTosaveChanges(EventHandler<ActionEvent> saveChangesPressed) {
		saveChanges.setOnAction(saveChangesPressed);
	}

	public void saveChanges(MenuCommands menu) throws Exception {
		int storePrice = -1, customerPrice = -1;
		if (productsNumberText.getText().isEmpty()) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must fill Product Serial Number!");
			msg.show();
			return;
		}
		try {

			if (priceForStore.getText().isEmpty()) {
				storePrice = 0;
			}
			if (priceForCustomer.getText().isEmpty()) {
				customerPrice = 0;
			}

			if (Integer.parseInt(priceForStore.getText()) <= 0) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Price must be positive!");
				msg.show();
				return;
			}
		} catch (Exception e) {
			if (!(priceForStore.getText().isEmpty() && priceForCustomer.getText().isEmpty())) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Price Must Be Integer!");
				msg.show();
				return;
			}

		}
		String catalog = productsMakat.getText();
		if (storePrice != 0)
			storePrice = Integer.parseInt(priceForStore.getText());
		if (customerPrice != 0)
			customerPrice = Integer.parseInt(priceForCustomer.getText());
		String proName = productName.getText();
		if (proName == null)
			proName = " ";
		String customerName = customersName.getText();
		if (customerName == null)
			customerName = " ";
		String customerPhone = customersPhone.getText();
		if (customerPhone == null)
			customerPhone = " ";
		boolean wantUpdateSales = false;
		if (!customerWantSalesUpdate.isSelected())
			wantUpdateSales = false;
		else if (customerNameText.getText().isEmpty() || customerPhoneText.getText().isEmpty()) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Must Fill All Customer Details!");
			msg.show();
			return;
		} else
			wantUpdateSales = true;

		Customer customer = new Customer(customerName, customerPhone, wantUpdateSales);
		Product product = new Product(proName, storePrice, customerPrice, customer);
		try {

			menu.addProductToList(catalog, product);
		} catch (

		IOException e) {
			e.printStackTrace();
		}
		clearInsert();
		undo.setDisable(false);
		Alert msg = new Alert(AlertType.CONFIRMATION);
		msg.setContentText("Product Added successfully!");
		msg.show();

	}

	public void addEventToUndo(EventHandler<ActionEvent> undoPressed) {
		undo.setOnAction(undoPressed);
	}

	public void undo(MenuCommands menu) throws Exception {
		menu.undo();
		Alert msg = new Alert(AlertType.CONFIRMATION);
		msg.setContentText("Undo worked successfully!");
		msg.show();
		undo.setDisable(true);
		showProductByCatalogNumber.setVisible(true);
		showAllProducts.setVisible(true);
		removeProductByCatalogNumber.setVisible(true);
		removeAllProducts.setVisible(true);
		showAllProfits.setVisible(true);
		sendMessageOnSales.setVisible(true);
		showAllSalesCustomers.setVisible(true);

	}

	public void addEventToremoveByCatalogNumber(EventHandler<ActionEvent> removeFromFilePressed) {
		removeProductByCatalogNumber.setOnAction(removeFromFilePressed);
	}

	public void addEventToRemoveAll(EventHandler<ActionEvent> removeAllPressed) {
		removeAllProducts.setOnAction(removeAllPressed);
	}

	public void addEventToshowProfits(EventHandler<ActionEvent> showProfitsPressed) {
		showAllProfits.setOnAction(showProfitsPressed);
	}

	public void removeAll(MenuCommands menu) throws IOException {
		try {
			menu.removeAllProducts();
			Alert msg = new Alert(AlertType.INFORMATION);
			msg.setContentText("All products removed successfully!");
			msg.show();
			saveWithOptions();
			clearView();
			showAllSalesCustomers.setDisable(true);
		} catch (Exception e) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Could not delete products!");
			msg.show();
		}
	}

	public void addEventToSendUpdates(EventHandler<ActionEvent> sendUpdatesPressed) {
		sendMessageOnSales.setOnAction(sendUpdatesPressed);
	}

	public void sendUpdates(MenuCommands menu) {
		try {
			menu.sendMSG(Store.getInstance("", 0));
			Alert msg = new Alert(AlertType.CONFIRMATION);
			msg.setContentText("Updates sent successfully!");
			msg.show();
			showAllSalesCustomers.setDisable(false);
			sendMessageOnSales.setDisable(true);
		} catch (Exception e) {
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Non of the customers wants updates");
			msg.show();
			showAllSalesCustomers.setDisable(true);
		}
	}

	private void clearInsert() {
		productsMakat.clear();
		priceForStore.clear();
		priceForCustomer.clear();
		productName.clear();
		customersName.clear();
		customersPhone.clear();
		customerWantSalesUpdate.setSelected(false);
	}

	public void saveWithoutSorting() {
		saveProductsByCatalogNumberInMapAscending.setDisable(true);
		saveProductsByCatalogNumberInMapDescending.setDisable(true);
		saveProductsByInsertOrderInMap.setDisable(true);
		showProductByCatalogNumber.setDisable(false);
		showAllProducts.setDisable(false);
		removeAllProducts.setDisable(false);
		removeProductByCatalogNumber.setDisable(false);
		showAllProfits.setDisable(false);
		sendMessageOnSales.setDisable(false);
	}

	public void notAllowSaving() {
		saveProductsByCatalogNumberInMapAscending.setDisable(true);
		saveProductsByCatalogNumberInMapDescending.setDisable(true);
		saveProductsByInsertOrderInMap.setDisable(true);
	}

	public void allowSaving() {
		saveProductsByCatalogNumberInMapAscending.setDisable(false);
		saveProductsByCatalogNumberInMapDescending.setDisable(false);
		saveProductsByInsertOrderInMap.setDisable(false);
	}

	public void saveWithOptions() {
		saveProductsByCatalogNumberInMapAscending.setDisable(false);
		saveProductsByCatalogNumberInMapDescending.setDisable(false);
		saveProductsByInsertOrderInMap.setDisable(false);
		showProductByCatalogNumber.setDisable(true);
		showAllProducts.setDisable(true);
		removeAllProducts.setDisable(true);
		removeProductByCatalogNumber.setDisable(true);
		showAllProfits.setDisable(true);
		sendMessageOnSales.setDisable(true);
	}

	public void clearView() {
		saveChanges.setVisible(false);
		undo.setVisible(false);
		textsAndFields.setVisible(false);
	}

	public void showView() {
		undo.setVisible(true);
		saveChanges.setVisible(true);
		textsAndFields.setVisible(true);
	}

	public void addEventToshowNames(EventHandler<ActionEvent> showNamesPressed) {
		showAllSalesCustomers.setOnAction(showNamesPressed);
	}

	public void saveWithNoOptions() {
		showProductByCatalogNumber.setDisable(true);
		showAllProducts.setDisable(true);
		removeAllProducts.setDisable(true);
		removeProductByCatalogNumber.setDisable(true);
		showAllProfits.setDisable(true);
		sendMessageOnSales.setDisable(true);
		showAllSalesCustomers.setDisable(true);
	}

	public void saveWithAllOptions() {
		showProductByCatalogNumber.setDisable(false);
		showAllProducts.setDisable(false);
		removeAllProducts.setDisable(false);
		removeProductByCatalogNumber.setDisable(false);
		showAllProfits.setDisable(false);
		sendMessageOnSales.setDisable(false);

	}

	public void addEventToExit(EventHandler<ActionEvent> exitPressed) {
		exit.setOnAction(exitPressed);
	}

}