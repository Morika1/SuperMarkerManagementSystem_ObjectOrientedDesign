package command;

import java.io.IOException;

public class UndoCommand {

	private ListOfProducts allProducts;

	public UndoCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
	}

	public void undo() throws IOException {
		allProducts.undo();
	}

}
