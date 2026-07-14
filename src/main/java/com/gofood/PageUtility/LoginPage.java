package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.WaitUtils;

public class LoginPage extends BasePage {
	public LoginPage() {
		super(DriverFactory.getDriver());
	}

//	@FindBy(xpath = "//*[@type='button' and @data-testid='login-signup-button']")
//	private WebElement headerLogin;

//	private final By headerLogin = By.xpath("//*[@type='button' and @data-testid='login-signup-button']");

	@FindBy(xpath = "//button[@type='button' and @data-testid='login-button']")
	private WebElement modalLogin;

	@FindBy(xpath = "//input[@name='phone_number']")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//button[@type='submit' and @data-testid='phone-number-continue-button']")
	private WebElement phoneContinueButton;

	@FindBy(xpath = "//button[.//span[text()='Continue']]")
	private WebElement otpContinueButton;

	@FindBy(id = "otp")
	private WebElement otpField;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement cookiesPopup;

	@FindBy(xpath = "(//*[@clip-rule='evenodd'])[4]")
	private WebElement backButton;

	public LoginPage headerLoginButton() {
		By headerLoginButtonLocator = By.xpath("//*[@type='button' and @data-testid='login-signup-button']");
		WebElement headerLogin = WaitUtils.waitForVisibility(headerLoginButtonLocator, 15);
		WaitUtils.waitForClickable(headerLogin, 15);
		headerLogin.click();
		return new LoginPage();
	}

	public LoginPage modalLoginButton() {
		By modalLoginButtonLocator = By.xpath("//button[@type='button' and @data-testid='login-button']");
		WebElement modalLogin = WaitUtils.waitForVisibility(modalLoginButtonLocator, 15);
		WaitUtils.waitForClickable(modalLogin, 15);
		modalLogin.click();
		return this;
	}

	public LoginPage enterPhoneNumber(String number) {
		WaitUtils.waitForVisibility(phoneNumberField, 10);
		phoneNumberField.sendKeys(number);
		return this;
	}

	public LoginPage clickPhoneContinueButton() {
		WaitUtils.waitForClickable(phoneContinueButton, 10);
		phoneContinueButton.click();
		return this;
	}

	public LoginPage clickOTPContinueButton() {
		WaitUtils.waitForClickable(otpContinueButton, 10);
		otpContinueButton.click();
		return this;
	}

	public LoginPage clickAcceptCookies() {
		try {
			WaitUtils.waitForClickable(cookiesPopup, 15);
			if (cookiesPopup.isDisplayed()) {
				cookiesPopup.click();
				System.out.println("Cookie popup accepted.");
			}
		} catch (Exception e) {
			System.out.println("Cookie popup no displayed.");
		}
		return this;
	}

	public LoginPage enterOTP(String OTP) {
		int maxAttempts = 3;
		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			try {
				WaitUtils.waitForVisibility(otpField, 15);
				otpField.click();
				otpField.sendKeys(OTP);
				if (otpField.getAttribute("value").equals(OTP)) {
					return this;

				}
			} catch (StaleElementReferenceException | TimeoutException e) {
				if (attempt == maxAttempts) {
					throw e;
				}
			}
		}
		throw new RuntimeException("Failed to enter OTP after " + maxAttempts + " attempts");
	}

	public LoginPage clickBackButton() {
		WaitUtils.waitForClickable(backButton, 15);
		backButton.click();
		return this;
	}

}
