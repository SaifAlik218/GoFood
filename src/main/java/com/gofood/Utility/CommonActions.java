package com.gofood.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.PageUtility.CuisineSection;
import com.gofood.PageUtility.FoodCheckoutPage;
import com.gofood.PageUtility.SearchRestroPage;
import com.gofood.PageUtility.SelectDishPage;

public class CommonActions extends BasePage {
	private static final Logger log = LoggerFactory.getLogger(CommonActions.class);
	public CommonActions() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//div[@data-testid='cart-button']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//button[@data-testid='floating-menu-button']")
	private WebElement menuButton;

	@FindBy(xpath = "//button[@data-testid='modal-close-button']")
	private WebElement closeicon;

	@FindBy(xpath = "//button[@data-testid='modal-customization-submit-button']")
	private WebElement modalAddToCartButton;

	@FindBy(xpath = "//a[@type='button' and contains(@href,'/en/login?')]")
	private WebElement loginToPurchaseButton;

	@FindBy(xpath = "//button[@data-testid='stepper-add']")
	private WebElement increaseCountButton;

	@FindBy(xpath = "//*[@data-testid='stepper-subtract']")
	private WebElement decreaseCountButton;

	@FindBy(xpath = "//*[@data-testid='gofood-logo']")
	private WebElement home;

	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]/parent::div")
	private List<WebElement> restroTimingChevron;

	// to click restro timing chevron
	public SelectDishPage clickRestroTimingChevron(int index) {
		WaitUtils.waitForVisibility(restroTimingChevron, 10);
		restroTimingChevron.get(index).click();
		return new SelectDishPage();
	}

	// to click gofood home icon
	public CuisineSection clickHomeButton() {
		WaitUtils.waitForClickable(home, 10);
		home.click();
		return new CuisineSection();
	}

	// To add dish to cart
	public SelectDishPage addToCart() {
		WaitUtils.waitForClickable(addToCartButton, 5);
		addToCartButton.click();
		return new SelectDishPage();
	}

	// To click on menu button
	public SelectDishPage clickMenuButton() {
		WaitUtils.waitForClickable(menuButton, 5);
		menuButton.click();
		return new SelectDishPage();
	}

	// To increase count in add dish page
	public SelectDishPage clickIncreaseCountButton(int clickCount) {
		WaitUtils.waitForClickable(increaseCountButton, 5);
		ActionUtils.scrollToElement(increaseCountButton);
		for (int i = 0; i < clickCount; i++) {
			increaseCountButton.click();
		}
		return new SelectDishPage();
	}

	// To decrease count in add dish page
	public SelectDishPage clickDecreaseCountButton(int clickCount) {
		WaitUtils.waitForClickable(decreaseCountButton, 5);
		ActionUtils.scrollToElement(decreaseCountButton);
		for (int i = 0; i < clickCount; i++) {
			decreaseCountButton.click();
		}
		return new SelectDishPage();
	}

	// to close modal dish window
	public SelectDishPage clickCloseModal() {
		WaitUtils.waitForClickable(closeicon, 5);
		closeicon.click();
		return new SelectDishPage();
	}

	// to login after clicking add to cart
	public SearchRestroPage loginToPurchaseButton() {
		WaitUtils.waitForClickable(loginToPurchaseButton, 5);
		loginToPurchaseButton.click();
		return new SearchRestroPage();
	}
//
//	public SearchRestroPage clickCloseicon() {
//		WaitUtils.waitForClickable(closeicon, 5);
//		closeicon.click();
//		return new SearchRestroPage();
//	}

	public FoodCheckoutPage clickCloseicon() {
		By closeLocator = By.xpath("//button[@data-testid='modal-close-button']");
		WebElement closeIcon = WaitUtils.waitForClickable(closeLocator, 10);
		closeIcon.click();
		return new FoodCheckoutPage();
	}
}
