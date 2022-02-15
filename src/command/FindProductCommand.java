package command;

import main.Product;

public class FindProductCommand {

	private ListOfProducts allProducts;

	public FindProductCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public Product findProductByserialNum(String serialNumber) {
		return allProducts.find(serialNumber);

	}

}
