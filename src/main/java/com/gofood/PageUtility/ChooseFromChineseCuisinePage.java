package com.gofood.PageUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;

public class ChooseFromChineseCuisinePage extends BasePage {
	public ChooseFromChineseCuisinePage() {
		super(DriverFactory.getDriver());
	}

	@FindBy(xpath = "//img[@alt='Chinese']")
	private WebElement chineseCuisine;

	@FindBy(xpath = "//p[@title='Sate Padang Maknyus 01, Jakarta']")
	private WebElement satePandangRestro;

	@FindBy(xpath = "//button[@data-testid='floating-menu-button']")
	private WebElement menuButton;

	@FindBy(xpath = "//img[@data-testid='menu-kopi-image']")
	private WebElement kopiDish;

	@FindBy(xpath = "//button[@data-testid='modal-customization-submit-button']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//button[@data-testid='modal-close-button']")
	private WebElement closeicon;

	@FindBy(xpath = "//img[@data-testid='menu-es-teh-image']")
	private WebElement esTehDish;

	@FindBy(xpath = "//img[@data-testid='menu-teh-manis-image']")
	private WebElement tehManisDish;
	
	

}
