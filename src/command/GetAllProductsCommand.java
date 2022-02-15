package command;

public class GetAllProductsCommand {

	private ListOfProducts allListOfProducts;

	public GetAllProductsCommand(ListOfProducts allListOfProducts) {
		this.allListOfProducts = allListOfProducts;
	}

	public ListOfProducts getAllProducts() {
		return allListOfProducts;
	}
}
