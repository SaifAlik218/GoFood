package com.gofood.TestCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.CuisineSection;
import com.gofood.PageUtility.FoodCheckoutPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.RestaurantPageUtility.Bakmie_Bakso17RestroPage;
import com.gofood.TestData.Bakmie_Bakso17DishesTestData;
import com.gofood.TestData.ChooseCuisineTestData;
import com.gofood.TestData.TestDataUtils;
import com.gofood.Utility.CommonActions;
import com.gofood.Utility.CommonFlowUtils;

public class AddMoreDishFromCheckoutPageTest extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(AddMoreDishFromCheckoutPageTest.class);
	private SearchRestroPage restroPage;
	private Bakmie_Bakso17RestroPage menu;
	private FoodCheckoutPage page;
	private CommonActions action;
	private CuisineSection section;

	@Test
	public void verifyAddMoreDishFromCheckoutPage() {
		section = new CuisineSection();
		section.selectCuisine(ChooseCuisineTestData.getBaksoSoto());
		restroPage = new SearchRestroPage();
		restroPage.clickBakmieBaksoRestro();
		menu = new Bakmie_Bakso17RestroPage();
//		restroPage = new SearchRestroPage();
		menu.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKMIE_AYAN.getDish());
		restroPage.addToCart().loginToPurchaseButton();
		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(), TestDataUtils.getOTP());
		page = new FoodCheckoutPage();
		page.clickAddMoreButton();
		menu.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKSO_KOMPLIT.getDish())
				.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKSO_POLOS.getDish());
//		restroPage = new SearchRestroPage();
		restroPage.addToCart();
//		page = new FoodCheckoutPage();
		page.clickCheckexcitingpromosLink();
		action = new CommonActions();
		action.clickCloseicon();
		page.clickGofoodButton().clickDoubleCheckGoFoodbutton();
	}
//	@Test(priority = 1)
//	public void verifySelectCuisine() {
//		new CuisineSection().selectCuisine(ChooseCuisineTestData.getBaksoSoto());
//	}
//
//	@Test(priority = 2)
//	public void verifySelectBaksoSotoRestro() {
//		restroPage = new SearchRestroPage();
//		restroPage.clickBakmieBaksoRestro();
//	}
////
//	@Test(priority = 3)
//	public void verifyAddDishFromMenu() {
//		menu = new Bakmie_Bakso17RestroPage();
//		restroPage = new SearchRestroPage();
//		menu.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKMIE_AYAN.getDish());
//		restroPage.addToCart().loginToPurchaseButton();
//	}
////
//	@Test(priority = 4)
//	public void verifyLoginToAccount() {
//		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(), TestDataUtils.getOTP());
//	}
//
//	@Test(priority = 5)
//	public void verifyScrollToAddMoreButton() {
//		page = new FoodCheckoutPage();
//		page.clickAddMoreButton();
//	}
////
//	@Test(priority = 6)
//	public void verifyAddMoreDishes() {
//		menu = new Bakmie_Bakso17RestroPage();
//		menu.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKSO_KOMPLIT.getDish())
//				.clickDishAddButton(Bakmie_Bakso17DishesTestData.BAKSO_POLOS.getDish());
//		restroPage = new SearchRestroPage();
//		restroPage.addToCart();
//	}
////
//	@Test(priority = 7)
//	public void verifySelectVoucher() {
//		page = new FoodCheckoutPage();
//		page.clickCheckexcitingpromosLink();
//		action = new CommonActions();
//		action.clickCloseicon();
//	}
////
//	@Test(priority = 8)
//	public void verifyOrderFood() {
//		page = new FoodCheckoutPage();
//		page.clickGofoodButton().clickDoubleCheckGoFoodbutton();
//	}
}
