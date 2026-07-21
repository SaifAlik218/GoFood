package com.gofood.TestCases;

import com.gofood.PageUtility.CuisineSection;
import com.gofood.TestData.Bakmie_Bakso17Restro.Bakmie_Bakso17DishesTestData;
import com.gofood.TestData.Bakso_SotoRestaurantsListTestData;
import com.gofood.TestData.ChooseCuisineTestData;
import com.gofood.TestData.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;
import com.gofood.Utility.CommonFlowUtils;

public class SearchPlaceAndSelectRestroIncreaseProductTest extends BaseTest {
    private SelectDishPage dish;
    private SearchRestroPage restroPage;
    private CuisineSection cuisineSection;
    @Test
    public void verifySearchPlaceAndSelectRestroIncreaseProduct() {
        CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
        cuisineSection = new CuisineSection();
        cuisineSection.selectCuisine(ChooseCuisineTestData.getBaksoSoto());
        CommonFlowUtils.selectRestroAndDish(Bakso_SotoRestaurantsListTestData.BAKMIE_BAKSO_17.getRestaurant());
        dish = new SelectDishPage();
        restroPage = new SearchRestroPage();
        int count = 1;
        dish.clickIncreaseCountButton(count);
        Assert.assertTrue(dish.getProductCount(count + 1), "Expected count to be: " + (count + 1));
        restroPage.addToCart().loginToPurchaseButton();
        CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(),
                TestDataUtils.getOTP());
    }
}
