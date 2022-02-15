package command;

import java.io.IOException;

public class RemoveAllProductsCommad {

	private ListOfProducts allProducts;

	public RemoveAllProductsCommad(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public void removeAllProducts() throws IOException {
		allProducts.removeAll();

	}

}
