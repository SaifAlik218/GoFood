package com.gofood.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gofood.Factory.*;


public class BasePage 
{
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(DriverFactory.getDriver(),this);
	}

}
