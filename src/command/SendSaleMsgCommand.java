package command;

import java.util.ArrayList;

import main.Store;
import observer.Observable;
import observer.Observer;

public class SendSaleMsgCommand {

	private ListOfProducts allProducts;
	ArrayList<Observer> customersApplied;
	ArrayList<String> names;

	public SendSaleMsgCommand(ListOfProducts allProducts) {
		this.allProducts = allProducts;
		this.customersApplied = new ArrayList<Observer>();
		this.names = new ArrayList<String>();
	}

	private void update() {
		customersApplied = allProducts.getAllUpdateCustomers();

	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void sendMSG(Observable o) {
		if (o instanceof Store) {
			names.clear();
			update();
			for (Observer customer : customersApplied) {
				names.add(customer.updateCustomerName(o));
			}
		}

	}

}
