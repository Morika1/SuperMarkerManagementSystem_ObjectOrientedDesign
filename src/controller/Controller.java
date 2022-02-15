package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import main.Store;
import command.ListOfProducts;
import command.MenuCommands;
import view.ShowProductByCatalogNumber;
import view.View;
import view.ShowAllProducts;
import view.ShowAllProfits;
import view.RemoveProductByCatalogNumber;
import view.ShowAllSalesCustomers;

public class Controller {
	private Store theModel;
	private View theView;
	private ShowProductByCatalogNumber showProductByCatalogNumber;
	private ShowAllProfits showAllProfits;
	private ShowAllSalesCustomers showAllSalesCustomers;
	private ShowAllProducts showAllProducts;
	private RemoveProductByCatalogNumber removeProductByCatalogNumber;

	public Controller(Store store, View view) {
		theModel = store;
		theView = view;
		ListOfProducts allProducts = theModel.getListOfProducts();
		int sortOption = theModel.getListOfProducts().getSortOption();
		MenuCommands menu = new MenuCommands(allProducts, sortOption);

		if (!(menu.getAllProducts().isSortExists())) {
			theView.saveWithOptions();
			theView.clearView();

		} else {
			theView.saveWithoutSorting();

		}

		EventHandler<ActionEvent> saveASCPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					theView.saveASCOrder(menu);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		theView.addEventToSaveASCOrder(saveASCPressed);

		EventHandler<ActionEvent> saveDESCPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					theView.saveDESCOrder(menu);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		theView.addEventTosaveDESCOrder(saveDESCPressed);

		EventHandler<ActionEvent> saveByOrderPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					theView.saveByOrder(menu);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		theView.addEventTosaveByOrder(saveByOrderPressed);

		EventHandler<ActionEvent> saveChangesPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					theView.saveChanges(menu);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if ((menu.getAllProducts().isEmpty()))
					theView.saveWithNoOptions();
				else
					theView.saveWithAllOptions();
			}
		};

		theView.addEventTosaveChanges(saveChangesPressed);

		EventHandler<ActionEvent> findProductByNumPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Stage secondStage = new Stage();
				showProductByCatalogNumber = new ShowProductByCatalogNumber(secondStage);

				EventHandler<ActionEvent> mainMenuPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						showProductByCatalogNumber.mainMenu();
					}
				};
				showProductByCatalogNumber.addEventToMainMenu(mainMenuPressed);

				EventHandler<ActionEvent> printPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						showProductByCatalogNumber.print(menu);
					}
				};
				showProductByCatalogNumber.addEventToPrint(printPressed);
			}
		};

		theView.addEventToFindProductByNumber(findProductByNumPressed);

		EventHandler<ActionEvent> PrintAllPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Stage secondStage = new Stage();
				String res = menu.printAllProducts();
				showAllProducts = new ShowAllProducts(secondStage, res);

				EventHandler<ActionEvent> mainMenuPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						showAllProducts.mainMenu();
					}
				};
				showAllProducts.addEventToMainMenu(mainMenuPressed);

			}
		};

		theView.addEventToPrintAll(PrintAllPressed);

		EventHandler<ActionEvent> undoPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				try {
					theView.undo(menu);
				} catch (Exception e) {

					if (menu.getAllProducts().isEmpty())
						theView.saveWithNoOptions();
					else
						theView.saveWithAllOptions();

					e.printStackTrace();
				}

			}

		};
		theView.addEventToUndo(undoPressed);

		EventHandler<ActionEvent> removeFromFilePressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Stage secondStage = new Stage();
				removeProductByCatalogNumber = new RemoveProductByCatalogNumber(secondStage);

				EventHandler<ActionEvent> mainMenuPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						removeProductByCatalogNumber.mainMenu();
					}
				};
				removeProductByCatalogNumber.addEventToMainMenu(mainMenuPressed);

				EventHandler<ActionEvent> removePressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						try {
							removeProductByCatalogNumber.remove(menu);
							if (menu.getAllProducts().isEmpty())
								theView.saveWithNoOptions();
							else
								theView.saveWithAllOptions();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				};
				removeProductByCatalogNumber.addEventToRemove(removePressed);
			}
		};
		theView.addEventToremoveByCatalogNumber(removeFromFilePressed);

		EventHandler<ActionEvent> removeAllPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					theView.removeAll(menu);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		theView.addEventToRemoveAll(removeAllPressed);

		EventHandler<ActionEvent> showProfitsPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Stage secondStage = new Stage();
				String res = menu.printAllProfits();
				showAllProfits = new ShowAllProfits(secondStage, res);

				EventHandler<ActionEvent> mainMenuPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						showAllProfits.mainMenu();
					}
				};
				showAllProfits.addEventToMainMenu(mainMenuPressed);

			}
		};

		theView.addEventToshowProfits(showProfitsPressed);

		EventHandler<ActionEvent> sendUpdatesPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				theView.sendUpdates(menu);

			}
		};

		theView.addEventToSendUpdates(sendUpdatesPressed);

		EventHandler<ActionEvent> showNamesPressed = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Stage secondStage = new Stage();
				ArrayList<String> names = menu.getCustomersNames();
				showAllSalesCustomers = new ShowAllSalesCustomers(secondStage);
				showAllSalesCustomers.addCustomersNames(names);

				EventHandler<ActionEvent> mainMenuPressed = new EventHandler<ActionEvent>() {

					public void handle(ActionEvent arg0) {
						showAllSalesCustomers.disableCustomersNames();
						showAllSalesCustomers.mainMenu();
					}
				};
				showAllSalesCustomers.addEventToMainMenu(mainMenuPressed);

			}
		};
		theView.addEventToshowNames(showNamesPressed);

		EventHandler<ActionEvent> exitPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theView.clearView();
				System.exit(0);
			}
		};
		theView.addEventToExit(exitPressed);

	}
}
