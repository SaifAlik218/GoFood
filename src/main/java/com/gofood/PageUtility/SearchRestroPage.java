package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.WaitUtils;

public class SearchRestroPage extends BasePage {
	public SearchRestroPage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//a[contains(@data-testid,'outlet-card-9a1b6e46')]")
	private WebElement Bakmie_Bakso17Restro;

	@FindBy(xpath = "(//button[@data-testid='add-qty-button'])[1]")
	private WebElement BakmieAyamAddButton;

	@FindBy(xpath = "//div[@data-testid='cart-button']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//a[@type='button' and contains(@href,'/en/login?')]")
	private WebElement loginToPurchase;

	@FindBy(xpath = "//button[@data-testid='stepper-add']")
	private WebElement increaseCountButton;

	private By productCount(int num) {
		return By.xpath("//div[text()='" + num + "']");
	}

	public SearchRestroPage clickBakmieBaksoRestro() {
		WaitUtils.waitForClickable(Bakmie_Bakso17Restro, 5);
		Bakmie_Bakso17Restro.click();
		return this;
	}

	public SearchRestroPage addBakmieAyan() {
		WaitUtils.waitForClickable(BakmieAyamAddButton, 5);
//		ActionUtils.scrollToElement(BakmieAyamAddButton);
		BakmieAyamAddButton.click();
		return this;
	}

	public SearchRestroPage addToCart() {
		WaitUtils.waitForClickable(addToCartButton, 5);
		addToCartButton.click();
		return this;
	}

	public SearchRestroPage loginToPurchaseButton() {
		WaitUtils.waitForClickable(loginToPurchase, 5);
		loginToPurchase.click();
		return this;
	}

	public SearchRestroPage clickIncreaseCountButton() {
		WaitUtils.waitForClickable(increaseCountButton, 5);
		increaseCountButton.click();
		return this;
	}

	public boolean getProductCount(int count) {
		WaitUtils.waitForVisibility(DriverFactory.getDriver().findElement(productCount(count)), 5);
		return DriverFactory.getDriver().findElement(productCount(count)).isDisplayed();
	}
}
