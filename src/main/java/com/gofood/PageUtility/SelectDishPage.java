package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;

public class SelectDishPage extends BasePage {
	public SelectDishPage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "(//button[@data-testid='add-qty-button'])[1]")
	private WebElement BakmieAyamAddButton;

	@FindBy(xpath = "//div[@data-testid='cart-item-count']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//a[@type='button' and contains(@href,'/en/login?')]")
	private WebElement loginToPurchase;

	@FindBy(xpath = "//*[@data-testid='stepper-add']")
	private WebElement increaseCountButton;

	private By productCount(int num) {
		return By.xpath("//div[text()='" + num + "']");
	}

	public SelectDishPage addBakmieAyanDish() {
		WaitUtils.waitForClickable(BakmieAyamAddButton, 5);
//		ActionUtils.scrollToElement(BakmieAyamAddButton);
		BakmieAyamAddButton.click();
		return this;
	}

	public SelectDishPage addToCart() {
		WaitUtils.waitForClickable(addToCartButton, 5);
		addToCartButton.click();
		return this;
	}

	public SelectDishPage loginToButton() {
		WaitUtils.waitForClickable(loginToPurchase, 5);
		loginToPurchase.click();
		return this;
	}

	public SelectDishPage clickIncreaseCountButton(int clickCount) {
		WaitUtils.waitForClickable(increaseCountButton, 5);
		ActionUtils.scrollToElement(increaseCountButton);
		for(int i = 0; i < clickCount;i++)
		{	
			increaseCountButton.click();
		}
		return this;
	}

	public boolean getProductCount(int count) {
		WaitUtils.waitForVisibility(DriverFactory.getDriver().findElement(productCount(count)), 5);
		return DriverFactory.getDriver().findElement(productCount(count)).isDisplayed();
	}
}