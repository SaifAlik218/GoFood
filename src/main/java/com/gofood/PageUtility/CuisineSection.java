package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;

public class CuisineSection extends BasePage {
	private static WebDriver driver;

	public CuisineSection() {
		super(DriverFactory.getDriver());
		this.driver = DriverFactory.getDriver();
	}

	@FindBy(xpath = "//*[@data-testid='gofood-logo']")
	private WebElement home;

	public CuisineSection clickHomeButton() {
		WaitUtils.waitForClickable(home, 10);
		home.click();
		return new CuisineSection();
	}

	public CuisineSection selectCuisine(String cuisine) {
		WebElement cuisineSection = driver.findElement(By.xpath("//h3[@title='" + cuisine + "']"));
		ActionUtils.scrollToElement(cuisineSection);
		WaitUtils.waitForClickable(cuisineSection, 10);
		cuisineSection.click();
		return new CuisineSection();
	}
}
