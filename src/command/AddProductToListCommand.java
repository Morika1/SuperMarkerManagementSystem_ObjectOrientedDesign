package command;

import main.Product;

public class AddProductToListCommand {

	private ListOfProducts allProducts;

	public AddProductToListCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public void addProductToList(String serialNumber, Product product) throws Exception {
		allProducts.add(serialNumber, product);

	}
}
