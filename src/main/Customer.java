package main;

import observer.Observer;
import observer.Observable;

public class Customer implements Observer {

	private String name;
	private String phoneNumber;
	private boolean wantUpdate;

	public Customer(String name, String phoneNumber, boolean wantUpdate) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.wantUpdate = wantUpdate;

	}

	public String getName() {
		return name;

	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean getUpdateStatus() {
		return wantUpdate;

	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", wantUpdate=" + wantUpdate + "]";
	}

	@Override
	public String updateCustomerName(Observable o) {
		if (wantUpdate)
			return this.name;

		return null;
	}

	public String stringToFile() {
		return this.name + "," + this.phoneNumber + "," + this.wantUpdate + "\n";
	}

}
