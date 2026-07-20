package com.gofood.PageUtility;

import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.ScreenShotUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.WaitUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

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

    private By cookiesPopup1 = By.id("onetrust-accept-btn-handler");
//    @FindBy(id = "onetrust-accept-btn-handler")
//    private WebElement cookiesPopup;

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
        log.info("Attempting to accept cookies");
        // Take screenshot before doing anything
        ScreenShotUtils.onFailure("BeforeAcceptCookies");
        // Debugging
        List<WebElement> buttons = DriverFactory.getDriver().findElements(cookiesPopup1);
        System.out.println("Buttons found: " + buttons.size());

        if (!buttons.isEmpty()) {
            System.out.println(buttons.get(0).getAttribute("outerHTML"));
        }
        try {
          WebElement cookiesPopup = WaitUtils.waitForClickable(cookiesPopup1, 15);
            new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(2))
                    .until(driver -> cookiesPopup.isDisplayed());

            if (cookiesPopup.isDisplayed()) {
                ActionUtils.click(cookiesPopup);
//                cookiesPopup.click();
                log.info("Successfully accepted cookies");
            }
        } catch (TimeoutException e) {

            log.info("Cookie popup not present.");

        } catch (ElementClickInterceptedException e) {

            log.error("Cookie popup found but click intercepted.", e);

        } catch (StaleElementReferenceException e) {

            log.error("Cookie popup became stale.", e);
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
