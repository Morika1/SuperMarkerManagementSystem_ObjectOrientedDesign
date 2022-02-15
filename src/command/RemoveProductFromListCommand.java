package command;

import java.io.IOException;

public class RemoveProductFromListCommand {

	private ListOfProducts allProducts;

	public RemoveProductFromListCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public boolean removeProductBySerialNum(String serialNumber) throws IOException {
		return allProducts.remove(serialNumber);

	}
}