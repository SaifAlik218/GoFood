package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.ConfigReader;
import com.gofood.Utility.WaitUtils;

public class FoodCheckoutPage extends BasePage {
	public FoodCheckoutPage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "(//input[@data-testid='radio-input']/parent::div)[1]")
	private WebElement cepaatRadioButton;

	@FindBy(xpath = "//input[@placeholder='Flat/Unit number, Floor number']")
	private WebElement locationDetails;

	@FindBy(xpath = "//textarea[@data-testid='textarea-input']")
	private WebElement deliverynote;

	@FindBy(xpath = "//button[@type='button' and contains(@class,'inline-flex cursor-pointer appearance-none')]/../span")
	private WebElement paymentMethodButton;

	@FindBy(xpath = "//span[text()='GoFood now']")
	private WebElement gofoodButton;

	@FindBy(xpath = "(//span[text()='GoFood now'])[2]")
	private WebElement doubleCheckGoFoodbutton;

	@FindBy(xpath = "//span[text()='Check again']/parent::button")
	private WebElement checkAgainButton;

	@FindBy(xpath = "//span[text()='Total payment']/following-sibling::span")
	private WebElement totalPayment;

	@FindBy(xpath = "//span[contains(@class,'absolute') and .//svg]")
	private WebElement tooltipCloseIcon;

	public FoodCheckoutPage selectCepaatService() {
		WaitUtils.waitForClickable(cepaatRadioButton, 5);
		ActionUtils.scrollToElement(cepaatRadioButton);
		if (!cepaatRadioButton.isSelected()) {
			cepaatRadioButton.click();
		}
		return this;
	}

	public FoodCheckoutPage enterLocationDetails(String details) {
		WaitUtils.waitForVisibility(locationDetails, 5);
		ActionUtils.scrollToElement(locationDetails);
		locationDetails.sendKeys(details);
		return this;
	}

	public FoodCheckoutPage enterDeliveryNote(String details) {
		WaitUtils.waitForVisibility(deliverynote, 5);
		ActionUtils.scrollToElement(deliverynote);
		deliverynote.sendKeys(details);
		return this;
	}

	public String getTotalPrice() {
		ActionUtils.scrollToElement(totalPayment);
		WaitUtils.waitForVisibility(totalPayment, 5);
		totalPayment.isDisplayed();
		String totalPrice = totalPayment.getText();
		return totalPrice;
	}

	public FoodCheckoutPage selectPaymentMethod()
	{
		WaitUtils.waitForClickable(paymentMethodButton, 5);
		paymentMethodButton.click();	
		return this;
	}
	public FoodCheckoutPage clickGofoodButton() {
		WaitUtils.waitForClickable(gofoodButton, 20);
//		ActionUtils.click(gofoodButton);
//		ActionUtils.clickStaleElement(gofoodButton, 3);
		ActionUtils.clickStaleElement(By.xpath("//span[text()='GoFood now']"), 3);
		return this;
	}

//	public FoodCheckoutPage closeIcon() {
//		WaitUtils.waitForClickable(tooltipCloseIcon, 5);
//		if (tooltipCloseIcon.isDisplayed()) {
//			ActionUtils.click(tooltipCloseIcon);
//		}
//		return this;
//	}

	public FoodCheckoutPage clickDoubleCheckGoFoodbutton() {

//		WebElement modalButton = ActionUtils.getVisibleElement(By.xpath("//span[text()='GoFood now']"));s
	    WaitUtils.waitForClickable(doubleCheckGoFoodbutton, 5);
	    ActionUtils.click(doubleCheckGoFoodbutton);
	    return this;
//		WebElement visibleButton = ActionUtils.getVisibleElement(By.xpath("//span[text()='GoFood now']"));
//		WaitUtils.waitForClickable(visibleButton, 10);
//		ActionUtils.click(visibleButton);
//		visibleButton.click();
//		return this;
	}
//
}
