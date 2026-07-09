package com.gofood.TestCases;

import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.UserProfilePage;
import com.gofood.Utility.CommonFlowUtils;
import com.gofood.Utility.TestDataUtils;

public class UserLoginTest extends BaseTest {
	LoginPage page;
	String username = "S2";

	@Test(priority = 1)
	public void landingPage() {
		page = new LoginPage().headerLoginButton();
	}

	@Test(priority = 2, dependsOnMethods = "landingPage")
	public void loginPage() {
		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber(),
				TestDataUtils.getOTP());

	}

	@Test(priority = 3, dependsOnMethods = "loginPage")
	public void validateUserProfile() {
		UserProfilePage profile = new UserProfilePage();
		String actual = profile.getUserProfile();
		softAssert.assertEquals(actual, username, "Expected to be user profile name as :" + username);
		softAssert.assertAll();
	}

}
