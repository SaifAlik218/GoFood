package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;
import org.slf4j.Logger;

import java.util.List;

public class CuisineSection extends BasePage {
	private static WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(CuisineSection.class);

	public CuisineSection() {
		super(DriverFactory.getDriver());
		this.driver = DriverFactory.getDriver();
	}

	@FindBy(xpath = "//*[@data-testid='gofood-logo']")
	private WebElement home;

	@FindBy(xpath = "//button[@data-testid='cuisine-expand-button']")
	private WebElement showMoreCuisineButton;

	// to redirect back to homescreen
	public CuisineSection clickHomeButton() {
		log.info("Attempting to click on home button ");
		WaitUtils.waitForClickable(home, 10);
		home.click();
		log.info("Successfully clicked on home button ");
		return new CuisineSection();
	}

	// to select cuisine
	public CuisineSection selectCuisine(String cuisine) {
		WebElement cuisineSection = driver.findElement(By.xpath("//h3[@title='" + cuisine + "']"));
		log.info("Attempting to select cuisine : {}", cuisine);
		ActionUtils.scrollToElement(cuisineSection);
		WaitUtils.waitForClickable(cuisineSection, 10);
		cuisineSection.click();
		log.info("Successfully select cuisine : {}", cuisine);
		return new CuisineSection();
	}

	// to expand the cuisine
	public CuisineSection clickShowMoreCuisineButton() {
		log.info("Attempting to click on Show More Cuisine Button ");
		WaitUtils.waitForClickable(showMoreCuisineButton, 10);
		showMoreCuisineButton.click();
		log.info("Successfully clicked on Show More Cuisine Button ");
		return this;
	}
    public String isCuisinePresent(String cuisineName)
    {
        By cuisine=By.xpath("//h3[@title='"+cuisineName+"']");
        return WaitUtils.waitForVisibility(cuisine,10).getText();
    }
}
