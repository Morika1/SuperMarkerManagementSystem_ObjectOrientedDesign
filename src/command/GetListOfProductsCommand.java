package command;

import java.util.Map;

import main.Product;

public class GetListOfProductsCommand {

	private ListOfProducts allProducts;

	public GetListOfProductsCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public Map<String, Product> getListOfProducts() {
		return allProducts.getMap();
	}

	public ListOfProducts getAllProducts() {
		return allProducts;
	}

}
