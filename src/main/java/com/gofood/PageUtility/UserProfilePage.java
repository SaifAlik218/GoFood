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

	public String getUserProfile() {
		WaitUtils.waitForText(userProfile, 5);
		return userProfile.getDomProperty("textContent").trim();
	}

}
