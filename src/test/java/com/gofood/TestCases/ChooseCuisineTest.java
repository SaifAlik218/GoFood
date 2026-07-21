package com.gofood.TestCases;

import com.gofood.TestData.TestDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gofood.BaseTest.BaseTest;
import com.gofood.PageUtility.CuisineSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseCuisineTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ChooseCuisineTest.class);
    private CuisineSection cuisine;

    @Test
    public void selectCuisine() throws Exception {
        cuisine = new CuisineSection();
        List<String> cuisines = new ArrayList<>(Arrays.asList(TestDataUtils.getBaksoSoto(), TestDataUtils.getBakery()));

        for (String cuisineName : cuisines) {
            cuisine.selectCuisine(cuisineName);
            Assert.assertEquals(cuisine.isCuisinePresent(cuisineName),cuisineName,"Failed to find title: ");
            cuisine.clickHomeButton();
        }
        cuisine.clickShowMoreCuisineButton();
    }
}
