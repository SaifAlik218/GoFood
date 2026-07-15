package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;

public class SearchLocationPage extends BasePage {
    public SearchLocationPage() {
        super(DriverFactory.getDriver());
    }

    @FindBy(xpath = "//*[@id='location-picker']")
    private WebElement locationPickupDropdown;

    @FindBy(xpath = "//span[text()='Explore']")
    private WebElement exploreButton;

    @FindBy(xpath = "//ul[@data-headlessui-state='open']//div/p[1]")
    private WebElement firstSuggestion;

    public SearchLocationPage enterLocation(String location) {
        WaitUtils.waitForClickable(locationPickupDropdown, 5);
        locationPickupDropdown.click();
        locationPickupDropdown.sendKeys(location);
        return this;
    }

    public SearchLocationPage selectFirstOption(String option) {
        By selectSuggestionLocator = By.xpath("//ul[@role='listbox']//li[@role='option'][.//p[normalize-space()='" + option + "']]");
        WebElement selectSuggestion = WaitUtils.waitForVisibility(selectSuggestionLocator, 15);
        WaitUtils.waitForClickable(selectSuggestion, 15).click();
        return this;
    }

    public SearchLocationPage clickExploreButton() {
        WaitUtils.waitForClickable(exploreButton, 5);
        ActionUtils.doubleClick(exploreButton);
        return this;
    }

}
