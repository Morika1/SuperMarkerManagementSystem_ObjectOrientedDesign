package main;

import java.io.IOException;
import java.util.Map;

public interface StoreFunc {

	public Map<String, Product> getStoreListOfProducts();

	public void addProduct(String serialNum, String cName, String cPhone, boolean wantUpdate, String pName,
			int storeCost, int customerCost) throws Exception;

	public void removeProduct(String serialNum) throws IOException;

	public void removeAllProducts() throws IOException;

	public String findProduct(String serialNum);

	public void showAllProducts();

	public void showAllProfits();

	public void setSort(int sortOption) throws Exception;

	public void undo();

}
