package main;

import java.util.Comparator;

public class SortByKeyDescending implements Comparator<String> {

	@Override
	public int compare(String serialNum1, String serialNum2) {

		return (serialNum1.compareTo(serialNum2)) * (-1);
	}

}
