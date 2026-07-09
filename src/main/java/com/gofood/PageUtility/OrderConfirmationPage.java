package com.gofood.PageUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.ConfigReader;
import com.gofood.Utility.WaitUtils;

public class OrderConfirmationPage extends BasePage {
	
	private static final Logger log = LoggerFactory.getLogger(OrderConfirmationPage.class);
	public OrderConfirmationPage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//p[text()='We got your purchase']")
	private WebElement weGotYourPurchase;

	@FindBy(xpath = "//p[text()='Resto confirmed your purchase']")
	private WebElement restroConfirmed;

	@FindBy(xpath = "//p[text()='Getting your food ready']/parent::div")
	private WebElement gettingYourFoodReady;

	@FindBy(xpath = "//div[text()='Restaurant location']/following-sibling::div")
	private WebElement restroName;

	@FindBy(xpath = "//div[starts-with(normalize-space(),'F-')]")
	private WebElement orderId;

	@FindBy(xpath = "//a[@type='button']/child::span[text()]")
	private WebElement needhelpButton;

	@FindBy(xpath = "//a[@data-testid='ongoing-button']")
	private WebElement trackButton;

	public String getYourPurchaseConfirmationText() {
		try {
			WaitUtils.waitForUrl(ConfigReader.getInstance().getConfig("orderConfirmationPageURL"), 5);
			return weGotYourPurchase.getText();
		} catch (Exception e) {
			
		}
		return null;
	}

	public String getRestroConfirmedText() {

		try {
			WaitUtils.waitForUrl(ConfigReader.getInstance().getConfig("orderConfirmationPageURL"), 5);
			WaitUtils.waitForVisibility(restroConfirmed, 5);
			return restroConfirmed.getText();
		} catch (Exception e) {
			log.error("Unable to fetch purchase confirmation text", e);
			return null;
		}	
	}

	public String getGettingYourFoodReadyText() {
		WaitUtils.waitForVisibility(gettingYourFoodReady, 10);
		return gettingYourFoodReady.getText();
	}

	public String getRestroName() {
//		WaitUtils.waitForText(restroName, 5);
		WaitUtils.waitForVisibility(restroName, 10);
		return restroName.getText();
	}

	public String getOrderId() {
//		WaitUtils.waitForText(orderId, 5);
		WaitUtils.waitForVisibility(orderId, 10);
		ActionUtils.scrollToElement(orderId);
		return orderId.getText();
	}

	public OrderConfirmationPage clickNeedHelpButton() {
		WaitUtils.waitForClickable(needhelpButton, 10);
		needhelpButton.click();
		return this;
	}

	public OrderConfirmationPage clickTrackButton() {
		WaitUtils.waitForClickable(trackButton, 10);
		trackButton.click();
		return this;
	}
}
