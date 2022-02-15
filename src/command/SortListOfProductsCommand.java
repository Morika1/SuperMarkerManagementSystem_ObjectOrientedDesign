package command;

public class SortListOfProductsCommand {

	private ListOfProducts allProducts;

	public SortListOfProductsCommand(int sortOption, ListOfProducts allProducts) {
		this.allProducts = allProducts;

	}

	public void setSort(int sortOption) throws Exception {
		this.allProducts.setSort(sortOption);
	}

}
