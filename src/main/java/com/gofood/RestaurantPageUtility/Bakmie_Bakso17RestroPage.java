package com.gofood.RestaurantPageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.WaitUtils;

public class Bakmie_Bakso17RestroPage extends BasePage {
	private static WebDriver driver;
	private static final Logger log = LoggerFactory.getLogger(Bakmie_Bakso17RestroPage.class);

	public Bakmie_Bakso17RestroPage() {
		super(DriverFactory.getDriver());
		this.driver = DriverFactory.getDriver();
	}

//	@FindBy(xpath = "//h3[contains(normalize-space(),'Bakmie Ayam')']/ancestor::div[contains(@class,'h-full')]//button")
//	private WebElement addButton;
//	@FindBy(xpath = "//h3[text()='Bakso Polos']/ancestor::div[contains(@class,'h-full')]//button")
//	private WebElement baksoaddButton;
//
//	public Bakmie_Bakso17RestroPage addBakmieAyanDish() {
//		WaitUtils.waitForClickable(BakmieAyamAddButton, 5);
////		ActionUtils.scrollToElement(BakmieAyamAddButton);
//		BakmieAyamAddButton.click();
//		return this;
//	}

	public Bakmie_Bakso17RestroPage clickDishAddButton(String foodName) {
		log.info("Attempting to select dish: {}", foodName);
		By addButtonLocator = By.xpath("//h3[normalize-space()='" + foodName + "']"
				+ "/ancestor::div[contains(@class,'border-gf-background-border-secondary')]"
				+ "//button[@data-testid='add-qty-button']");

		// h3[normalize-space()='Bakso Komplit']/ancestor::div[contains(@class,'h-full
		// border-gf-background-border-secondary')]
		// button[@data-testid='add-qty-button']

//		for (WebElement add : addButton) {
//			String food = add.getText();
//			if (foodName == food) {
//				ActionUtils.clickStaleElement(add, 3);
//				ActionUtils.scrollToElement(add);
//				WaitUtils.waitForClickable(add, 10);
//				add.click();
//			}
//		}
		WebElement addButton = WaitUtils.waitForVisibility(addButtonLocator, 10);
		ActionUtils.scrollToElement(addButton);
		WaitUtils.waitForClickable(addButton, 10);
		addButton.click();
		log.info("Successfully selected dish: {}", foodName);
		return this;
	}

//	public Bakmie_Bakso17RestroPage clickDishAddButton() {
//		By addButtonLocator = By.xpath("//h3[normalize-space()='Bakmie Ayam']"
//				+ "/ancestor::div[contains(@class,'border-gf-background-border-secondary')]"
//				+ "//button[@data-testid='add-qty-button']");
//		WebElement addButton = WaitUtils.waitForVisibility(addButtonLocator, 10);
//		ActionUtils.scrollToElement(addButton);
//		WaitUtils.waitForClickable(addButton, 10);
//		addButton.click();
//		return this;
//	}
}
