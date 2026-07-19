package com.gofood.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.LoginPage;
import com.gofood.PageUtility.UserProfilePage;
import com.gofood.Utility.CommonFlowUtils;
import com.gofood.Utility.TestDataUtils;

public class UserLoginTest extends BaseTest {
	private String username = "A";

	@Parameters({ "phoneNumber", "OTP" })
	@Test
	public void verifyUserLoginAndProfile(String phoneNumber,String OTP) {
		// Navigate to Login Page
		LoginPage page = new LoginPage();
		page.headerLoginButton();
		// enter phoneNumber and OTP
		CommonFlowUtils.loginToAccount(phoneNumber, OTP);
//		CommonFlowUtils.loginToAccount(TestDataUtils.getPhoneNumber1(), TestDataUtils.getOTP());
		UserProfilePage profile = new UserProfilePage();
		String actual = profile.getUserProfile();
		softAssert.assertEquals(actual, username, "Expected to be user profile name as :" + username);
		softAssert.assertAll();
	}
}
