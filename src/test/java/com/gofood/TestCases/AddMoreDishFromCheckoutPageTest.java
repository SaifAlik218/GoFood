package com.gofood.TestCases;

import com.gofood.TestData.Bakmie_Bakso17Restro.Bakmie_Bakso17DishesTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.CuisineSection;
import com.gofood.PageUtility.FoodCheckoutPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.MenuPageUtility.Bakmie_Bakso17MenuPage;
import com.gofood.TestData.ChooseCuisineTestData;
import com.gofood.TestData.TestDataUtils;
import com.gofood.Utility.CommonActions;
import com.gofood.Utility.CommonFlowUtils;

public class AddMoreDishFromCheckoutPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(AddMoreDishFromCheckoutPageTest.class);
    private SearchRestroPage restroPage;
    private Bakmie_Bakso17MenuPage menu;
    private FoodCheckoutPage page;
    private CommonActions action;
    private CuisineSection section;

    @Test
    public void verifyAddMoreDishFromCheckoutPage() {
        section = new CuisineSection();
        String baksoSoto = ChooseCuisineTestData.getBaksoSoto();
        Assert.assertEquals(baksoSoto, section.isCuisinePresent(baksoSoto), "Failed to load cuisine");
        section.selectCuisine(ChooseCuisineTestData.getBaksoSoto());
        restroPage = new SearchRestroPage();
        String bakmieBakso = TestDataUtils.getBakmieBakso();
        Assert.assertEquals(restroPage.isRestroDisplayed(bakmieBakso), bakmieBakso, "Failed to load Restro: " + bakmieBakso);
        restroPage.clickBakmieBaksoRestro();
        menu = new Bakmie_Bakso17MenuPage();
        String bakmieAyan = Bakmie_Bakso17DishesTestData.BAKMIE_AYAN.getDish();
        Assert.assertTrue(menu.isDishPresent(bakmieAyan), "Failed to display");
        menu.clickDishAddButton(bakmieAyan);
        restroPage.addToCart().loginToPurchaseButton();
        CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(), TestDataUtils.getOTP());
        page = new FoodCheckoutPage();
        page.clickAddMoreButton();
        String baksoKomplit = Bakmie_Bakso17DishesTestData.BAKSO_KOMPLIT.getDish();
        String baksoPolos = Bakmie_Bakso17DishesTestData.BAKSO_POLOS.getDish();
        Assert.assertTrue(menu.isDishPresent(baksoKomplit), "Fail to display:" + baksoKomplit);
        menu.clickDishAddButton(baksoKomplit);
        Assert.assertTrue(menu.isDishPresent(baksoPolos), "Fail to display:" + baksoPolos);
        menu.clickDishAddButton(baksoPolos);
        restroPage.addToCart();
        page.clickCheckexcitingpromosLink();
        action = new CommonActions();
        action.clickCloseicon();
        page.clickGofoodButton().clickDoubleCheckGoFoodbutton();
    }
}
