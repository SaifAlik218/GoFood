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
	public void selectCuisine() throws Exception {
		CuisineSection cuisine = new CuisineSection();
		cuisine.selectCuisine(TestDataUtils.getBaksoSoto()).clickHomeButton();
		cuisine.selectCuisine(TestDataUtils.getBakery()).clickHomeButton();
		cuisine.clickShowMoreCuisineButton();
	}

}
