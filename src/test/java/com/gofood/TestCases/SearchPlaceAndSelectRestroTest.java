package com.gofood.TestCases;

import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.SearchLocationPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.Utility.CommonActions;
import com.gofood.Utility.CommonFlowUtils;
import com.gofood.Utility.TestDataUtils;

public class SearchPlaceAndSelectRestroTest extends BaseTest {
	
	@Test
	public void verifySearchPlaceAndSelectRestro()
	{
		CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
		CommonFlowUtils.selectRestroAndDish();
		CommonActions action = new CommonActions();
		action.clickRestroTimingChevron(1);
		action.clickCloseModal();
//		new LoginPage().clickAcceptCookies();
		new SelectDishPage().addToCart().loginToButton();
		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(),
				TestDataUtils.getOTP());
	}

//	@Test(priority = 1)
//	public void searchPlace() {
//		
//	}
//
//	@Test(priority = 2)
//	public void selectRestro() {
//		
//		
//	}
//
//	@Test(priority = 3)
//	public void loginToAccount() {
//		
//	}
}
