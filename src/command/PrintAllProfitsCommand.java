package command;

public class PrintAllProfitsCommand {

	private ListOfProducts allProducts;

	public PrintAllProfitsCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public String printAllProfits() {
		return allProducts.printAllProfits();

	}

}
