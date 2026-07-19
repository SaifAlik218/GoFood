package com.gofood.PageUtility.GoFoodHemat;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;
import java.util.List;

public class HomePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage() {
        super(DriverFactory.getDriver());
    }

    @FindBy(xpath = "//h3[@title='GoFood HEMAT']")
    private WebElement goFoodHemat;

    @FindBy(xpath = "//a[contains(@data-testid,'item-card-')]")
    private List<WebElement> dishName;

    public HomePage clickGoFoodHemat() {
        log.info("Attempting to click on GoFoodHemat button");
        WaitUtils.waitForVisibility(goFoodHemat, 10);
        WaitUtils.waitForClickable(goFoodHemat, 10).click();
        log.info("Successfully clicked on GoFoodHemat button");
        return this;
    }

    public HomePage selectDish(String dish) {
        By selectDishLocator = By.xpath("//span[normalize-space()='" + dish + "']");
        WebElement selectDish = WaitUtils.waitForVisibility(selectDishLocator, 10);
        ActionUtils.scrollToElement(selectDish);
        WaitUtils.waitForClickable(selectDish, 10).click();
        return this;
    }

    public String getSelectDish(String dish) {
        By getDishLocator = By.xpath("//span[normalize-space()='" + dish + "']");
        return WaitUtils.waitForVisibility(getDishLocator, 10).getText().trim();
    }
}
