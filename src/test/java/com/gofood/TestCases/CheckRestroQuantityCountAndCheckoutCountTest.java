package com.gofood.TestCases;

import com.gofood.BaseTest.BaseTest;
import com.gofood.MenuPageUtility.Bakmie_Bakso17MenuPage;
import com.gofood.PageUtility.CuisineSection;
import com.gofood.PageUtility.FoodCheckoutPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.TestData.Bakmie_Bakso17Restro.Bakmie_Bakso17DishesTestData;
import com.gofood.TestData.Bakso_SotoRestaurantsListTestData;
import com.gofood.TestData.ChooseCuisineTestData;
import com.gofood.TestData.TestDataUtils;
import com.gofood.Utility.CommonFlowUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckRestroQuantityCountAndCheckoutCountTest extends BaseTest {
    private CuisineSection cuisine;
    private SearchRestroPage restroPage;
    private SelectDishPage dishPage;
    private Bakmie_Bakso17MenuPage bakmieBakso17MenuPage;
    private FoodCheckoutPage foodCheckoutPage;

    @Test
    public void verifyRestroQuantityCountAndCheckoutCount() {
        cuisine = new CuisineSection();
        cuisine.selectCuisine(ChooseCuisineTestData.getBaksoSoto());
        restroPage = CommonFlowUtils.selectRestroAndDish(Bakso_SotoRestaurantsListTestData.BAKMIE_BAKSO_17.getRestaurant(), Bakmie_Bakso17DishesTestData.BAKMIE_AYAN.getDish());
        dishPage = new SelectDishPage();
        int clickCount = 3;
        dishPage.clickIncreaseCountButton(clickCount);
        bakmieBakso17MenuPage = new Bakmie_Bakso17MenuPage();
        int cartQuantitycount = bakmieBakso17MenuPage.getCartQuantityCount();
        Assert.assertEquals(clickCount, cartQuantitycount, "Mismatch between item clicked count and cart count");
        System.out.println("Cart count: " + cartQuantitycount);
        dishPage.clickAddToCartButton().loginToButton();
        CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber1(), TestDataUtils.getOTP());
        foodCheckoutPage = new FoodCheckoutPage();
        int totalCount = foodCheckoutPage.getCheckoutQuantityCount();
        Assert.assertEquals(totalCount,cartQuantitycount, "Mismatch count between cart Quantity count and totalCount in checkout page");
    }
}
