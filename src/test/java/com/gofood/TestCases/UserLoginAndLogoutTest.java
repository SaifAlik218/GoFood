package com.gofood.TestCases;

import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.UserProfilePage;
import com.gofood.TestData.TestDataUtils;
import com.gofood.Utility.CommonFlowUtils;

public class UserLoginAndLogoutTest extends BaseTest {
	@Test
	public void verifyUserLoginAndLogoutTest() {
		// User navigates to login page enters phoneNumber and OTP
		LoginPage page = CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber1(), TestDataUtils.getOTP(), true);
		UserProfilePage profile = new UserProfilePage();
		// User clicks on profile button and clicks on logout button
		profile.clickProfileButton().clickLogoutButton();
	}

}
