package command;

import java.io.IOException;
import java.util.Map;

import main.Product;
import main.Store;

public interface Command {

	public Map<String, Product> getListOfProducts();

	public void addProductToList(String serialNumber, Product product) throws Exception;

	public void setSort(int sortOption) throws Exception;

	public boolean removeProductBySerialNum(String serialNumber) throws IOException;

	public String printAllProducts();

	public String findProductByserialNum(String serialNumber);

	public void removeAllProducts() throws IOException;

	public String printAllProfits();

	public void undo();

	public ListOfProducts getAllProducts();

	public void sendMSG(Store sender);

}
