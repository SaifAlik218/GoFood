package com.gofood.MenuPageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;

public class Bakmie_Bakso17MenuPage extends BasePage {
    private static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(Bakmie_Bakso17MenuPage.class);

    public Bakmie_Bakso17MenuPage() {
        super(DriverFactory.getDriver());
        this.driver = DriverFactory.getDriver();
    }

    @FindBy(xpath = "//div[@data-testid='cart-item-count']")
    private WebElement cartCount;

    private By bakmieBaksoRestro =
            By.xpath("//a[contains(@data-testid,'outlet-card-9a1b6e46')]");

    public Bakmie_Bakso17MenuPage clickDishAddButton(String foodName) {
        log.info("Attempting to select dish: {}", foodName);
        By addButtonLocator = By.xpath("//h3[normalize-space()='" + foodName + "']"
                + "/ancestor::div[contains(@class,'border-gf-background-border-secondary')]"
                + "//button[@data-testid='add-qty-button']");
        WebElement addButton = WaitUtils.waitForVisibility(addButtonLocator, 10);
        ActionUtils.scrollToElement(addButton);
        WaitUtils.waitForClickable(addButton, 10);
        addButton.click();
        log.info("Successfully selected dish: {}", foodName);
        return this;
    }

    public String getbakmieBaksoRestro() {
        return WaitUtils.waitForVisibility(bakmieBaksoRestro, 10).getText();
    }

    public boolean isDishPresent(String dish) {
        By food = By.xpath("//h3[normalize-space()='" + dish + "']");
        return WaitUtils.waitForVisibility(food, 10).isDisplayed();
    }

    public int getCartQuantityCount() {
        String quantityCount = WaitUtils.waitForVisibility(cartCount, 10).getText();
        try {
            String count = quantityCount.replaceAll("\\D+", "");
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new RuntimeException(
                    "Unable to parse cart quantity. Cart text is not in expected format.",
                    e);
        }
    }
}
