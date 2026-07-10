package com.gofood.TestData;

import java.util.HashMap;
import java.util.Map;

public class ChooseCuisineTestData {

	private static Map<String, String> Cuisine() {
		Map<String, String> cuisine = new HashMap<String, String>();
		cuisine.put("Bakso & soto", "Bakso & soto");
		cuisine.put("Martabak", "Martabak");
		cuisine.put("Bakery", "Bakery");
		cuisine.put("Chinese", "Chinese");
		cuisine.put("Western", "Western");
		cuisine.put("Fast food", "Fast food");
		cuisine.put("Japanese", "Japanese");
		cuisine.put("Snacks", "Snacks");
		cuisine.put("Sate", "Sate");
		cuisine.put("Pizza & pasta", "Pizza & pasta");
		cuisine.put("Noodles", "Noodles");
		cuisine.put("Beverages", "Beverages");
		cuisine.put("Korean", "Korean");
		cuisine.put("Seafood", "Seafood");
		cuisine.put("Coffee", "Coffee");
		cuisine.put("Indian", "Indian");
		cuisine.put("Middle Eastern", "Middle Eastern");
		return cuisine;
	}

	public static String getBaksoSoto() {
		return Cuisine().get("Bakso & soto");
	}

	public static String getMartabak() {
		return Cuisine().get("Martabak");
	}

	public static String getBakery() {
		return Cuisine().get("Bakery");
	}

	public static String getWestern() {
		return Cuisine().get("Western");
	}

	public static String getFastFood() {
		return Cuisine().get("Fast food");
	}

	public static String getJapanese() {
		return Cuisine().get("Japanese");
	}

	public static String getSnacks() {
		return Cuisine().get("Snacks");
	}

	public static String getSate() {
		return Cuisine().get("Sate");
	}

	public static String getPizzaPasta() {
		return Cuisine().get("Pizza & pasta");
	}

	public static String getNoodles() {
		return Cuisine().get("Noodles");
	}

	public static String getBeverages() {
		return Cuisine().get("Beverages");
	}

	public static String getSeafood() {
		return Cuisine().get("Seafood");
	}

	public static String getCoffee() {
		return Cuisine().get("Coffee");
	}

	public static String getIndian() {
		return Cuisine().get("Indian");
	}

	public static String getMiddleEastern() {
		return Cuisine().get("Middle Eastern");
	}
}
