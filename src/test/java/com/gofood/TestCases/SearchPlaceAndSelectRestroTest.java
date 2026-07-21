package com.gofood.TestCases;

import com.gofood.PageUtility.CuisineSection;
import com.gofood.TestData.Bakso_SotoRestaurantsListTestData;
import com.gofood.TestData.ChooseCuisineTestData;
import com.gofood.TestData.TestDataUtils;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.Utility.CommonActions;
import com.gofood.Utility.CommonFlowUtils;

public class SearchPlaceAndSelectRestroTest extends BaseTest {
    private CommonActions action;
    private SelectDishPage dishPage;
    private CuisineSection cuisineSection;

    @Test
    public void verifySearchPlaceAndSelectRestro() {
        // 1. Pre-requisite flow: Location & Restaurant selection
        CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
        cuisineSection = new CuisineSection();
        cuisineSection.selectCuisine(ChooseCuisineTestData.getBaksoSoto());
        CommonFlowUtils.selectRestroAndDish(Bakso_SotoRestaurantsListTestData.BAKMIE_BAKSO_17.getRestaurant());
        action = new CommonActions();
        // 2. Handle Restaurant Timing Modal (Fluent Pattern)
        action.clickRestroTimingChevron(1);
        action.clickCloseModal();
//		new LoginPage().clickAcceptCookies();
        // 3. Select Dish & Initiate Login (Fluent Pattern)
        dishPage = new SelectDishPage();
        dishPage.clickAddToCartButton().loginToButton();
        // 4. Complete Login Flow
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
