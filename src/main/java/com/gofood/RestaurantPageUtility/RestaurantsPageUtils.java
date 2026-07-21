package com.gofood.RestaurantPageUtility;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RestaurantsPageUtils extends BasePage {
    public RestaurantsPageUtils() {
        super(DriverFactory.getDriver());
    }

    public RestaurantsPageUtils chooseRestro(String restro) {
        By selectRestroLocator = By.xpath("//p[contains(@title,'" + restro + "')]");
        WebElement selectResto = WaitUtils.waitForVisibility(selectRestroLocator, 15);
        ActionUtils.scrollToElement(selectResto);
        WaitUtils.waitForClickable(selectResto, 15).click();
        return this;
    }
}
