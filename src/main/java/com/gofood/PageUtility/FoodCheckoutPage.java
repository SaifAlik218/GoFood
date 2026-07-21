package com.gofood.PageUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gofood.BasePage.BasePage;
import com.gofood.Factory.DriverFactory;
import com.gofood.Utility.ActionUtils;
import com.gofood.Utility.ConfigReader;
import com.gofood.Utility.ScreenShotUtils;
import com.gofood.Utility.WaitUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FoodCheckoutPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(FoodCheckoutPage.class);

    public FoodCheckoutPage() {
        super(DriverFactory.getDriver());
    }

    @FindBy(xpath = "(//input[@data-testid='radio-input']/parent::div)[1]")
    private WebElement cepaatRadioButton;

    @FindBy(xpath = "//input[@placeholder='Flat/Unit number, Floor number']")
    private WebElement locationDetails;

    @FindBy(xpath = "//textarea[@data-testid='textarea-input']")
    private WebElement deliverynote;

    @FindBy(xpath = "//button[@type='button' and contains(@class,'inline-flex cursor-pointer appearance-none')]/../span")
    private WebElement paymentMethodButton;

    @FindBy(xpath = "//button[.//span[text()='GoFood now']]")
    private WebElement gofoodButton;

    @FindBy(xpath = "(//span[text()='GoFood now'])[2]")
    private WebElement doubleCheckGoFoodbutton;

    @FindBy(xpath = "//span[text()='Check again']/parent::button")
    private WebElement checkAgainButton;

    @FindBy(xpath = "//span[text()='Total payment']/following-sibling::span")
    private WebElement totalPayment;

    @FindBy(xpath = "//span[contains(@class,'absolute') and .//svg]")
    private WebElement tooltipCloseIcon;

    @FindBy(xpath = "//a[contains(@class,'inline-flex cursor-pointer appearance-none') and .//span[normalize-space()='Add more']]")
    private WebElement addMoreButton;

    @FindBy(xpath = "//button[contains(@class,'inline-flex cursor-pointer appearance-none') and .//span[normalize-space()='View detailed breakdown']]")
    private WebElement viewDetailBreakdown;

    @FindBy(xpath = "//span[normalize-space()='Ok, got it']")
    private WebElement okGotItButton;

    @FindBy(xpath = "//div[normalize-space()='Check exciting promos here']")
    private WebElement checkexcitingpromosLink;

    @FindBy(xpath = "//div[contains(@class,'gf-label-s md:gf-label-m line-clamp-1 text-gf-content-brand')and normalize-space()='Check more promos']")
    private WebElement checkmorepromosLink;

    @FindBy(xpath = "//div[@data-testid='stepper-step']")
    private List<WebElement> selectItemsCount;

    public FoodCheckoutPage selectCepaatService() {
        WaitUtils.waitForClickable(cepaatRadioButton, 5);
        ActionUtils.scrollToElement(cepaatRadioButton);
        if (!cepaatRadioButton.isSelected()) {
            cepaatRadioButton.click();
        }
        return this;
    }

    public FoodCheckoutPage enterLocationDetails(String details) {
        WaitUtils.waitForVisibility(locationDetails, 5);
        ActionUtils.scrollToElement(locationDetails);
        locationDetails.sendKeys(details);
        return this;
    }

    public FoodCheckoutPage enterDeliveryNote(String details) {
        WaitUtils.waitForVisibility(deliverynote, 5);
        ActionUtils.scrollToElement(deliverynote);
        deliverynote.sendKeys(details);
        return this;
    }

    public String getTotalPrice() {
        ActionUtils.scrollToElement(totalPayment);
        WaitUtils.waitForVisibility(totalPayment, 5);
        totalPayment.isDisplayed();
        String totalPrice = totalPayment.getText();
        return totalPrice;
    }

    public FoodCheckoutPage selectPaymentMethod() {
        WaitUtils.waitForClickable(paymentMethodButton, 5);
        paymentMethodButton.click();
        return this;
    }

    public FoodCheckoutPage clickGofoodButton() {
//		WaitUtils.waitForClickable(gofoodButton, 20);
//		System.out.println("Displayed : " + gofoodButton.isDisplayed());
//		System.out.println("Enabled   : " + gofoodButton.isEnabled());
//		System.out.println("Location  : " + gofoodButton.getLocation());
//		System.out.println("Size      : " + gofoodButton.getSize());
//		ActionUtils.click(gofoodButton);
//		ActionUtils.clickStaleElement(gofoodButton, 3);
        ActionUtils.clickStaleElement(By.xpath("//button[.//span[text()='GoFood now']]"), 5);
//		ActionUtils.retryClick(By.xpath("//button[.//span[text()='GoFood now']]"), 3);
        return this;
    }

    public FoodCheckoutPage clickAddMoreButton() {
        WaitUtils.waitForVisibility(addMoreButton, 10);
        ActionUtils.scrollToElement(addMoreButton);
        WaitUtils.waitForClickable(addMoreButton, 5);
        addMoreButton.click();
        return this;
    }

    public FoodCheckoutPage clickDoubleCheckGoFoodbutton() {

//		WebElement modalButton = ActionUtils.getVisibleElement(By.xpath("//span[text()='GoFood now']"));s
        WaitUtils.waitForClickable(doubleCheckGoFoodbutton, 5);
        ActionUtils.click(doubleCheckGoFoodbutton);
        return this;
//		WebElement visibleButton = ActionUtils.getVisibleElement(By.xpath("//span[text()='GoFood now']"));
//		WaitUtils.waitForClickable(visibleButton, 10);
//		ActionUtils.click(visibleButton);
//		visibleButton.click();
//		return this;
    }

    public FoodCheckoutPage clickViewDetailBreakdown() {
        WaitUtils.waitForClickable(viewDetailBreakdown, 10);
        ActionUtils.scrollToElement(viewDetailBreakdown);
        viewDetailBreakdown.click();
        return this;
    }

    public FoodCheckoutPage clickOkGotItButton() {
        WaitUtils.waitForClickable(okGotItButton, 10);
        ActionUtils.scrollToElement(okGotItButton);
        okGotItButton.click();
        return this;
    }

    public FoodCheckoutPage clickCheckexcitingpromosLink() {
        By checkexcitingpromosLocator = By.xpath("//div[normalize-space()='Check exciting promos here']");
        By checkmorepromosLinkLocator = By.xpath(
                "//div[contains(@class,'gf-label-s md:gf-label-m line-clamp-1 text-gf-content-brand')and normalize-space()='Check more promos']");
        WebElement target = WaitUtils.waitForAnyVisible(10, checkexcitingpromosLocator, checkmorepromosLinkLocator);
        ActionUtils.scrollToElement(target);
        WaitUtils.waitForClickable(target, 10);
        target.click();
        return this;
    }

    public int getCheckoutQuantityCount() {
        int total = 0;
        WaitUtils.waitForVisibility(addMoreButton, 10);
        ActionUtils.scrollToElement(addMoreButton);
        for (WebElement selectItem : selectItemsCount) {
            WaitUtils.waitForVisibility(selectItem, 10);
            String quantity = selectItem.getText().trim();
            try {
                total += Integer.parseInt(quantity);
            } catch (Exception e) {
                log.error("Unable to parse checkout quantity: {}", quantity, e);
                throw new RuntimeException("Invalid checkout item quantity: '" + selectItem.getText() + "'", e);
            }
        }
        return total;
    }
}
