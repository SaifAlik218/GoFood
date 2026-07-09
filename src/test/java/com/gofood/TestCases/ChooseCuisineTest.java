package com.gofood.TestCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.CuisineSection;
import com.gofood.Utility.TestDataUtils;

public class ChooseCuisineTest extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(ChooseCuisineTest.class);

	@Test
	public void selectCuisine()throws Exception {
		CuisineSection cuisine = new CuisineSection();
		log.info("Attempting to click on Bakso and Soto cuisine");
		cuisine.selectCuisine(TestDataUtils.getBaksoSoto());
		log.info("Successfully clicked on Bakso and Soto cuisine");
		log.info("Attempting to click on home button");
		Thread.sleep(2000);
		cuisine.clickHomeButton();
		Thread.sleep(1000);
		log.info("Successfully clicked on home button");
		log.info("Attempting to click on Bakery cuisine");
		Thread.sleep(2000);
		cuisine.selectCuisine(TestDataUtils.getBakery());
		log.info("Successfully clicked on Bakery cuisine");
		log.info("Attempting to click on home button");
		Thread.sleep(2000);
		cuisine.clickHomeButton();
		log.info("Successfully clicked on home button");
	}

}
