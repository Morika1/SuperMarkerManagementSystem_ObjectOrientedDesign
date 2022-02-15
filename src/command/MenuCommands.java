package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import main.Product;
import main.Store;

public class MenuCommands implements Command {

	private GetListOfProductsCommand getCommand;
	private SortListOfProductsCommand sortCommand;
	private AddProductToListCommand addCommand;
	private RemoveProductFromListCommand removeCommand;
	private PrintAllProductsCommand printProductsCommad;
	private FindProductCommand findCommand;
	private RemoveAllProductsCommad removeAllCommand;
	private PrintAllProfitsCommand printProfitsCommand;
	private UndoCommand undoCommand;
	private SendSaleMsgCommand sendMSGCommand;
	private GetAllProductsCommand getListCommand;

	public MenuCommands(ListOfProducts allProducts, int sortOption) {
		this.getCommand = new GetListOfProductsCommand(allProducts);
		this.sortCommand = new SortListOfProductsCommand(sortOption, allProducts);
		this.addCommand = new AddProductToListCommand(allProducts);
		this.removeCommand = new RemoveProductFromListCommand(allProducts);
		this.printProductsCommad = new PrintAllProductsCommand(allProducts);
		this.findCommand = new FindProductCommand(allProducts);
		this.removeAllCommand = new RemoveAllProductsCommad(allProducts);
		this.printProfitsCommand = new PrintAllProfitsCommand(allProducts);
		this.undoCommand = new UndoCommand(allProducts);
		this.sendMSGCommand = new SendSaleMsgCommand(allProducts);
		this.getListCommand = new GetAllProductsCommand(allProducts);
	}

	@Override
	public Map<String, Product> getListOfProducts() {
		return getCommand.getListOfProducts();
	}

	public ListOfProducts getAllProducts() {
		return getListCommand.getAllProducts();
	}

	@Override
	public void addProductToList(String serialNumber, Product product) throws Exception {
		addCommand.addProductToList(serialNumber, product);
	}

	@Override
	public void setSort(int sortOption) throws Exception {
		sortCommand.setSort(sortOption);

	}

	@Override
	public boolean removeProductBySerialNum(String serialNumber) throws IOException {
		return removeCommand.removeProductBySerialNum(serialNumber);

	}

	@Override
	public String printAllProducts() {
		return printProductsCommad.printAllProducts();
	}

	@Override
	public String findProductByserialNum(String serialNumber) {
		if (findCommand.findProductByserialNum(serialNumber) == null)
			return "no such product";
		return findCommand.findProductByserialNum(serialNumber).toString();

	}

	@Override
	public void removeAllProducts() throws IOException {
		removeAllCommand.removeAllProducts();

	}

	@Override
	public String printAllProfits() {
		return printProfitsCommand.printAllProfits();

	}

	@Override
	public void undo() {
		try {
			undoCommand.undo();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendMSG(Store sender) {
		sendMSGCommand.sendMSG(sender);
	}

	public ArrayList<String> getCustomersNames() {
		return sendMSGCommand.getNames();
	}

}
