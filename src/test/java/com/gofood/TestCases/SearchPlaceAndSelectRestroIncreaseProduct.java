package com.gofood.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.Utility.CommonFlowUtils;
import com.gofood.Utility.TestDataUtils;

public class SearchPlaceAndSelectRestroIncreaseProduct extends BaseTest {
	SelectDishPage dish;

	@Test(priority = 1)
	public void searchPlaceAndSelectRestro() {
		CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
		CommonFlowUtils.selectRestroAndDish();	
	}

	@Test(priority = 2)
	public void addDish() {
		dish = new SelectDishPage();
		int count = 2;
		dish.clickIncreaseCountButton(count);
		Assert.assertTrue(dish.getProductCount(count + 1), "Expected count to be: " + (count + 1));
		new SearchRestroPage().addToCart().loginToPurchaseButton();
	}
	@Test(priority = 3)
	public void loginToAccount() {
		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(),
				TestDataUtils.getOTP());
	}

}
