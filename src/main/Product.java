package main;

public class Product {

	private String name;
	private int storePrice;
	private int customerPrice;
	private Customer customer;

	public Product(String name, int storePrice, int customerPrice, Customer customer) {
		this.name = name;
		this.storePrice = storePrice;
		this.customerPrice = customerPrice;
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public int getStorePrice() {
		return storePrice;

	}

	public int getCustomerPrice() {
		return customerPrice;

	}

	public Customer getCustomer() {
		return customer;
	}

	public int getProfit() {
		return customerPrice - storePrice;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", storePrice=" + storePrice + ", customerPrice=" + customerPrice
				+ ", Customer=" + customer.toString() + "]";
	}

	public String stringToFile() {
		return this.name + "," + this.storePrice + "," + this.customerPrice + "," + this.customer.stringToFile();
	}

}
