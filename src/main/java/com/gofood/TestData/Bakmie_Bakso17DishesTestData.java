package com.gofood.TestData;

public enum Bakmie_Bakso17DishesTestData {

	BAKMIE_AYAN("Bakmie Ayam"), BAKMIE_AYAN_BAKSO("Bakmie Ayam Bakso"), BAKSO_POLOS("Bakso Polos"),
	BAKSO_KOMPLIT("Bakso Komplit"), FRES_TEA("Fres Tea"), ADES("Ades");

	private final String dish;

	private Bakmie_Bakso17DishesTestData(String dish) {
		this.dish = dish;
	}

	public String getDish() {
		return dish;
	}
}
