package com.gofood.TestCases;

import com.gofood.TestData.TestDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.CuisineSection;

public class ChooseCuisineTest extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(ChooseCuisineTest.class);
    private CuisineSection cuisine;

	@Test
	public void selectCuisine() throws Exception {
        cuisine = new CuisineSection();
		cuisine.selectCuisine(TestDataUtils.getBaksoSoto()).clickHomeButton();
		cuisine.selectCuisine(TestDataUtils.getBakery()).clickHomeButton();
		cuisine.clickShowMoreCuisineButton();
	}

}
