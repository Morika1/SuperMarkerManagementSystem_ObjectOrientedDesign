package command;

import java.io.IOException;
import java.util.Map;

import main.Product;
import main.Store;

public class ListOfProductsCommand {

	Command menuCommand;

	public ListOfProductsCommand(Command menuCommand) {
		this.menuCommand = menuCommand;
	}

	public ListOfProducts getAllProductsCommand() {
		return menuCommand.getAllProducts();
	}

	public Map<String, Product> getListOfProductsCommand() {
		return menuCommand.getListOfProducts();
	}

	public void setSortCommand(int sortOption) throws Exception {
		menuCommand.setSort(sortOption);
	}

	public void addProductToListCommand(String serialNumber, Product product) throws Exception {
		menuCommand.addProductToList(serialNumber, product);
	}

	public boolean removeProductFromListCommand(String serialNumber) throws IOException {
		return menuCommand.removeProductBySerialNum(serialNumber);
	}

	public String printAllProductsCommand() {
		return menuCommand.printAllProducts();
	}

	public String findProductBySerialNumCommand(String serialNumber) {
		return menuCommand.findProductByserialNum(serialNumber).toString();
	}

	public void removeAllProductsFromListCommand() throws IOException {
		menuCommand.removeAllProducts();
	}

	public String printAllProfitsCommand() {
		return menuCommand.printAllProfits();
	}

	public void undoCommand() {
		menuCommand.undo();
	}

	public void sendMSGCommand(Store sender) {
		menuCommand.sendMSG(sender);
	}

}
