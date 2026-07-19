package com.gofood.TestCases;

import com.gofood.TestData.TestDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.FoodCheckoutPage;
import com.gofood.PageUtility.OrderConfirmationPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.Utility.CommonFlowUtils;

public class OrderFoodViaCepaatTest extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(OrderFoodViaCepaatTest.class);
	private FoodCheckoutPage checkOutPage;
	private OrderConfirmationPage confirmationPage;

	@Test
	public void verifyOrderFoodViaCepaat()
	{
		CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
		CommonFlowUtils.selectRestroAndDish();
		new SelectDishPage().addToCart();
		new SearchRestroPage().loginToPurchaseButton();
		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(), TestDataUtils.getOTP());
		checkOutPage = new FoodCheckoutPage();
		checkOutPage.selectCepaatService();
		String totalPrice = checkOutPage.getTotalPrice();
		log.info("Captured total price: {}", totalPrice);
		softAssert.assertTrue(totalPrice != null && !totalPrice.trim().isEmpty(),
				"Total price element returned empty/null text");
		softAssert.assertTrue(totalPrice.matches("\\d{1,3}(\\.\\d{3})*"),
				"Total price format unexpected, found: " + totalPrice);
		checkOutPage.clickGofoodButton().clickDoubleCheckGoFoodbutton();
		softAssert.assertAll();
		confirmationPage = new OrderConfirmationPage();
		String purchaseConfirmed = confirmationPage.getYourPurchaseConfirmationText();
//		String restroConfirmed = confirmationPage.getRestroConfirmedText();
		String restroName = confirmationPage.getRestroName();
		String orderId = confirmationPage.getOrderId();
		log.info("Restaurant name: {}", restroName);
		log.info("Purchase Confirmation: {}", purchaseConfirmed);
//		log.info("Status: {}", gettingYourReadyText);
//		log.info("Confirmation: {}", restroConfirmed);
		log.info("Order ID: {}", orderId);
//		String gettingYourReadyText = confirmationPage.getGettingYourFoodReadyText();
		softAssert.assertNotNull(purchaseConfirmed, "Failed to load purchase confirmation text");
//		softAssert.assertNotNull(restroConfirmed, "Failed to load restro confirmation text");
		softAssert.assertTrue(restroName!=null && !restroName.isBlank(), "Failed to load restro name");
//		softAssert.assertNotNull(gettingYourReadyText, "Failed to load 'Getting your food ready'");
		softAssert.assertTrue(orderId != null && !orderId.trim().isEmpty() && orderId.contains("F-"),
				"Failed to load order id but found: " + orderId);
		log.info("Attempting to click on need help button: {}", confirmationPage.clickNeedHelpButton());
		confirmationPage.clickNeedHelpButton().clickTrackButton();
		log.info("Successfully clicked on need help button: {}", confirmationPage.clickNeedHelpButton());
		softAssert.assertAll();
	}
//	@Test(priority = 1)
//	public void selectRestroAndDish() {
//		CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
//		CommonFlowUtils.selectRestroAndDish();
//		new SelectDishPage().addToCart();
//		new SearchRestroPage().loginToPurchaseButton();
//	}
//
//	@Test(priority = 2)
//	public void loginToAccount() {
//		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(), TestDataUtils.getOTP());
//	}
//	@Test(priority = 3)
//	public void setDeliveryService() {
//		checkOutPage =new FoodCheckoutPage();
//		checkOutPage.selectCepaatService();
//	}
//
//	@Test(priority = 4)
//	public void verifyPaymentViaGoPay() {
//		checkOutPage = new FoodCheckoutPage();
////		log.info("Attempting to select cepaat service,enter location details, enter delivery note: {}");
//		String totalPrice = checkOutPage.getTotalPrice();
//		log.info("Captured total price: {}", totalPrice);
//		softAssert.assertTrue(totalPrice != null && !totalPrice.trim().isEmpty(),
//				"Total price element returned empty/null text");
//		softAssert.assertTrue(totalPrice.matches("\\d{1,3}(\\.\\d{3})*"),
//				"Total price format unexpected, found: " + totalPrice);
//		checkOutPage.clickGofoodButton().clickDoubleCheckGoFoodbutton();
//		softAssert.assertAll();
//	}
//
////
//	@Test(priority = 5, dependsOnMethods = "verifyPaymentViaGoPay")
//	public void verifyOrderConfirmationScreen() {
//		confirmationPage = new OrderConfirmationPage();
//		String purchaseConfirmed = confirmationPage.getYourPurchaseConfirmationText();
////		String restroConfirmed = confirmationPage.getRestroConfirmedText();
//		String restroName = confirmationPage.getRestroName();
//		String orderId = confirmationPage.getOrderId();
//		log.info("Restaurant name: {}", restroName);
//		log.info("Purchase Confirmation: {}", purchaseConfirmed);
////		log.info("Status: {}", gettingYourReadyText);
////		log.info("Confirmation: {}", restroConfirmed);
//		log.info("Order ID: {}", orderId);
////		String gettingYourReadyText = confirmationPage.getGettingYourFoodReadyText();
//		softAssert.assertNotNull(purchaseConfirmed, "Failed to load purchase confirmation text");
////		softAssert.assertNotNull(restroConfirmed, "Failed to load restro confirmation text");
//		softAssert.assertTrue(restroName!=null && restroName.isBlank(), "Failed to load restro name");
////		softAssert.assertNotNull(gettingYourReadyText, "Failed to load 'Getting your food ready'");
//		softAssert.assertTrue(orderId != null && !orderId.trim().isEmpty() && orderId.contains("F-"),
//				"Failed to load order id but found: " + orderId);
//		log.info("Attempting to click on need help button: {}", confirmationPage.clickNeedHelpButton());
//		confirmationPage.clickNeedHelpButton().clickTrackButton();
//		log.info("Successfully clicked on need help button: {}", confirmationPage.clickNeedHelpButton());
//		softAssert.assertAll();
//	}
}
