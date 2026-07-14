package com.gofood.PageUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.WaitUtils;

public class UserProfilePage extends BasePage {
	public UserProfilePage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//div[@data-testid='profile-button']")
	private WebElement userProfile;

	@FindBy(xpath = "//a[@data-testid='logout-button']")
	private WebElement logoutButton;

	public String getUserProfile() {
		WaitUtils.waitForText(userProfile, 15);
		return userProfile.getDomProperty("textContent").trim();
	}

	public UserProfilePage clickProfileButton() {
		WaitUtils.waitForVisibility(userProfile, 10);
		WaitUtils.waitForClickable(userProfile, 10).click();
		return this;
	}

	public UserProfilePage clickLogoutButton() {
		WaitUtils.waitForVisibility(logoutButton, 10);
		WaitUtils.waitForClickable(logoutButton, 10).click();
		return this;
	}

}
