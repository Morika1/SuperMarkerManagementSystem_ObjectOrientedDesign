package main;

import java.io.IOException;
import observer.Observable;
import java.util.Map;
import command.ListOfProductsCommand;
import command.ListOfProducts;
import command.MenuCommands;

public class Store implements Observable, StoreFunc {

	private ListOfProductsCommand allProductsCommand;
	private String storePhone;
	private static Store instance = null;

	private Store(String storePhone, int sortOption) throws Exception {
		this.storePhone = storePhone;
		ListOfProducts allProducts = new ListOfProducts(sortOption);
		this.allProductsCommand = new ListOfProductsCommand(new MenuCommands(allProducts, sortOption));

	}

	public int getSortOption() {
		return allProductsCommand.getAllProductsCommand().getSortOption();
	}

	public ListOfProducts getListOfProducts() {
		return allProductsCommand.getAllProductsCommand();
	}

	public void sendUpdatesToCustomers() {
		allProductsCommand.sendMSGCommand(instance);
	}

	public static Store getInstance(String storePhone, int sortOption) throws Exception {
		if (instance == null)
			instance = new Store(storePhone, sortOption);

		return instance;
	}

	public Map<String, Product> getStoreListOfProducts() {
		return allProductsCommand.getListOfProductsCommand();
	}

	public String getStorePhone() {
		return storePhone;
	}

	@Override
	public void addProduct(String serialNum, String cName, String cPhone, boolean wantUpdate, String pName,
			int storeCost, int customerCost) throws Exception {
		Customer customer = new Customer(cName, cPhone, wantUpdate);
		Product product = new Product(pName, storeCost, customerCost, customer);
		allProductsCommand.addProductToListCommand(serialNum, product);
		if (wantUpdate) {

		}

	}

	@Override
	public void removeProduct(String serialNum) throws IOException {
		allProductsCommand.removeProductFromListCommand(serialNum);

	}

	@Override
	public String findProduct(String serialNum) {
		return allProductsCommand.findProductBySerialNumCommand(serialNum);
	}

	@Override
	public void showAllProducts() {
		allProductsCommand.printAllProductsCommand();
	}

	@Override
	public void showAllProfits() {
		allProductsCommand.printAllProfitsCommand();
	}

	@Override
	public void setSort(int sortOption) throws Exception {
		allProductsCommand.setSortCommand(sortOption);
	}

	@Override
	public void undo() {
		allProductsCommand.undoCommand();
	}

	@Override
	public void removeAllProducts() throws IOException {
		allProductsCommand.removeAllProductsFromListCommand();
	}

}
