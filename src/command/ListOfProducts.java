package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import main.Customer;
import main.Memento;
import main.Product;
import main.SortByKeyDescending;
import observer.Observer;

public class ListOfProducts {

	private Map<String, Product> allProducts;
	private Memento memento;
	private RandomAccessFile raf;
	private final String FILE_NAME = "products.txt";
	private int sortOption;

	public ListOfProducts(int sortOption) throws Exception {

		File file = new File(FILE_NAME);
		try {
			raf = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		if (readFromFile()) {
			return;
		}
		setSort(sortOption);

	}

	public int getSortOption() {
		return sortOption;
	}

	public boolean isSortExists() {
		return sortOption != 0;
	}

	public boolean isEmpty() {
		if (allProducts.size() == 0)
			return true;

		return false;
	}

	private boolean readFromFile() throws IOException {
		FileIterator it = new FileIterator();
		raf.seek(0);
		if (!it.hasNext()) {
			return false;
		} else {
			sortOption = raf.readInt();
			setSort(sortOption);
			while (it.hasNext()) {
				String allInformation = (String) it.next();
				String[] splitInfo = allInformation.split(",");
				String serialNum = splitInfo[0];
				Customer customer = new Customer(splitInfo[4], splitInfo[5], Boolean.parseBoolean(splitInfo[6]));
				Product product = new Product(splitInfo[1], Integer.parseInt(splitInfo[2]),
						Integer.parseInt(splitInfo[3]), customer);

				allProducts.put(serialNum, product);

			}
		}
		return true;
	}

	private class FileIterator implements Iterator<String> {

		long writePos;

		public boolean hasNext() {

			try {
				return raf.getFilePointer() < raf.length();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		public String next() {

			try {
				writePos = raf.getFilePointer();
				return raf.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		public void remove() {

			try {
				byte[] data = new byte[(int) (raf.length() - raf.getFilePointer())];
				long size;
				size = (raf.getFilePointer() - writePos);
				raf.read(data);
				raf.seek(writePos);
				raf.write(data);
				raf.setLength(raf.length() - size);
				raf.seek(writePos);

			} catch (IOException e) {
				e.printStackTrace();

			}
		}

	}

	public void setSort(int sortOption) {
		this.sortOption = sortOption;
		switch (this.sortOption)

		{
		case 1:
			this.allProducts = new TreeMap<String, Product>();
			break;
		case 2:
			this.allProducts = new TreeMap<String, Product>(new SortByKeyDescending());
			break;
		case 3:
			this.allProducts = new LinkedHashMap<String, Product>();
			break;
		default:
			System.out.println("This option is not allowed.");
			break;
		}
	}

	public void saveToFile() throws IOException {
		raf.setLength(0);
		raf.seek(0);
		try {

			raf.writeInt(sortOption);
			String str = "";
			for (Map.Entry<String, Product> e : allProducts.entrySet()) {
				str = e.getKey() + "," + e.getValue().stringToFile();
				raf.writeUTF(str);
			}

		} catch (

		Exception e) {

		}
	}

	public ArrayList<Observer> getAllUpdateCustomers() {
		ArrayList<Observer> listOfUpdateCustomers = new ArrayList<Observer>();
		for (Map.Entry<String, Product> product : allProducts.entrySet()) {
			if (product.getValue().getCustomer().getUpdateStatus()) {
				listOfUpdateCustomers.add(product.getValue().getCustomer());
			}
		}
		return listOfUpdateCustomers;
	}

	public Map<String, Product> getMap() {
		return allProducts;
	}

	public void add(String serialNumber, Product product) throws Exception {
		memento = getMemento();
		if (!(allProducts.containsKey(serialNumber))) {
			allProducts.put(serialNumber, product);
		} else {

			Product oldProduct = allProducts.get(serialNumber);
			allProducts.replace(serialNumber, oldProduct, product);
		}
		saveToFile();
	}

	public boolean remove(String serialNumber) throws IOException {
		FileIterator it = new FileIterator();
		raf.seek(0);
		if (it.hasNext()) {
			raf.readInt();
		} else
			return false;
		while (it.hasNext()) {
			String str = (String) it.next();
			String[] info = str.split(",");
			String catalog = info[0];
			if (catalog.compareTo(serialNumber) == 0) {
				it.remove();
				readFromFile();
				return true;
			}
		}
		return false;
	}

	public String printAllProducts() {

		StringBuffer str = new StringBuffer("All Products:\n");

		for (Map.Entry<String, Product> currentProduct : allProducts.entrySet()) {
			Product product = currentProduct.getValue();
			str.append(currentProduct.getKey() + ": " + product.toString() + "\n");

		}
		return str.toString();
	}

	public Product find(String serialNumber) {
		if (!(allProducts.containsKey(serialNumber)))
			return null;

		return allProducts.get(serialNumber);
	}

	public boolean removeAll() throws IOException {

		FileIterator it = new FileIterator();
		raf.seek(0);
		if (it.hasNext()) {
			raf.readInt();
		} else
			return false;
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		allProducts.clear();

		raf.setLength(0);
		return true;
	}

	public String printAllProfits() {

		int totalProfit = 0;

		StringBuffer str = new StringBuffer("The Profits of the store:\n");

		for (Map.Entry<String, Product> currentProduct : allProducts.entrySet()) {
			Product product = currentProduct.getValue();
			str.append(currentProduct.getKey() + " " + product.getName() + " ,Store price: " + product.getStorePrice()
					+ " , Customer price: " + product.getCustomerPrice() + " ,Profit: " + product.getProfit() + "\n");

			totalProfit += product.getProfit();
		}

		str.append("Total Profit Is: " + totalProfit);
		return str.toString();

	}

	public void undo() throws IOException {
		this.allProducts.clear();
		this.allProducts.putAll(memento.getMap());
		saveToFile();

	}

	public Memento getMemento() {
		return new Memento(allProducts, getSortOption());
	}

}