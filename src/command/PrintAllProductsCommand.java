package command;

public class PrintAllProductsCommand {

	private ListOfProducts allProducts;

	public PrintAllProductsCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public String printAllProducts() {
		return allProducts.printAllProducts();
	}

}
