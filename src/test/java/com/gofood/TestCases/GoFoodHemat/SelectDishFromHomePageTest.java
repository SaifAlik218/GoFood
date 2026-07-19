package com.gofood.TestCases.GoFoodHemat;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.GoFoodHemat.HomePage;
import com.gofood.PageUtility.Login.LoginPage;
import com.gofood.PageUtility.SearchLocationPage;
import com.gofood.TestData.GoFoodHomePageTestData;
import com.gofood.TestData.TestDataUtils;
import com.gofood.Utility.CommonFlowUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDishFromHomePageTest extends BaseTest {
    private LoginPage page;
    private HomePage home;
    @Test
    public void VerifySelectDishFromHomePage() {
        page = new LoginPage();
        home = new HomePage();
        CommonFlowUtils.searchAndSelectLocation(TestDataUtils.getJakartaArea());
        page.clickGoFoodHemat();
        String actualDish = GoFoodHomePageTestData.AYAM_GEPREK_BENERAN.getDish();
        home.selectDish(actualDish);
        String expectedDish = home.getSelectDish(GoFoodHomePageTestData.AYAM_GEPREK_BENERAN.getDish());
        Assert.assertEquals(actualDish, expectedDish, "Failed to load the dish ");
    }
}
