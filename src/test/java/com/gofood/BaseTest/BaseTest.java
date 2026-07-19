package com.gofood.BaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.gofood.Factory.DriverFactory;
import com.gofood.PageUtility.LoginPage;
import com.gofood.Utility.ConfigReader;

public class BaseTest {
	protected SoftAssert softAssert;
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setup(@Optional("chrome")String browser) throws Exception {
		log.info("===Starting test on thread: {}====", Thread.currentThread().getId());
		DriverFactory.initializeDriver(browser);
		DriverFactory.getDriver().get(ConfigReader.getInstance().getConfig("url"));
		DriverFactory.getDriver().manage().window().maximize();
		new LoginPage().clickAcceptCookies();
	}

	@BeforeMethod
	public void initSoftAssert() {
		softAssert = new SoftAssert();
	}
//
	@AfterClass(alwaysRun = true)
	public void teardown() {
		log.info("=== Test finished, quitting driver ===");
		DriverFactory.teardown();
	}
}
