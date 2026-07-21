package com.gofood.TestCases;

import com.gofood.TestData.Bakso_SotoRestaurantsListTestData;
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
    private SelectDishPage dishPage;
    private SearchRestroPage restroPage;

    @Test
    public void verifyOrderFoodViaCepaat() {
        CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
        CommonFlowUtils.selectRestroAndDish(Bakso_SotoRestaurantsListTestData.BAKMIE_BAKSO_17.getRestaurant());
        dishPage = new SelectDishPage().clickAddToCartButton();
        restroPage = new SearchRestroPage().loginToPurchaseButton();
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
        softAssert.assertTrue(restroName != null && !restroName.isBlank(), "Failed to load restro name");
//		softAssert.assertNotNull(gettingYourReadyText, "Failed to load 'Getting your food ready'");
        softAssert.assertTrue(orderId != null && !orderId.trim().isEmpty() && orderId.contains("F-"),
                "Failed to load order id but found: " + orderId);
        log.info("Attempting to click on need help button: {}", confirmationPage.clickNeedHelpButton());
        confirmationPage.clickNeedHelpButton().clickTrackButton();
        log.info("Successfully clicked on need help button: {}", confirmationPage.clickNeedHelpButton());
        softAssert.assertAll();
    }
}
