package main;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Memento {

	private Map<String, Product> map;

	public Memento(Map<String, Product> allProducts, int sortOption) {
		if (sortOption == 3) {
			this.map = new HashMap<String, Product>();
			map.putAll(allProducts);
		} else {
			this.map = new TreeMap<String, Product>();
			map.putAll(allProducts);
		}
	}

	public Map<String, Product> getMap() {
		return map;

	}
}
