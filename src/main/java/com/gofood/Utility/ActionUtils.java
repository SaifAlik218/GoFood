package com.gofood.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gofood.Factory.DriverFactory;

public class ActionUtils {
	private ActionUtils() {
		Actions action;
		throw new UnsupportedOperationException("Utility class");
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
//		jse.executeScript("arguments[0].scrollIntoView(true)", element);
		try {
			Thread.sleep(300); // only acceptable here — waiting for JS animation, not page load
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void scrollToElement(By locator) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", locator);
//		jse.executeScript("arguments[0].scrollIntoView(true)", element);
		try {
			Thread.sleep(300); // only acceptable here — waiting for JS animation, not page load
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void doubleClick(WebElement element) {
		new Actions(DriverFactory.getDriver()).doubleClick(element).perform();
	}

	public static void click(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(300); // only acceptable here — waiting for JS animation, not page load
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void retryClick(WebElement element, int retries) {
		for (int attempt = 1; attempt <= retries; attempt++) {
			try {
				WaitUtils.waitForClickable(element, 10);
				element.click();
				return;
			} catch (StaleElementReferenceException e) {
				if (attempt == retries) {
					throw e;
				}
			}
		}
	}

	public static void retryClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		Long centerX = (long) element.getRect().getX() + element.getRect().getWidth() / 2;
		Long centerY = (long) element.getRect().getY() + element.getRect().getHeight() / 2;

		Object obj = js.executeScript("return document.elementFromPoint(arguments[0], arguments[1]);", centerX,
				centerY);

		System.out.println(obj);
	}

	public static void retryClick(By locator, int retries) {
		for (int attempt = 1; attempt <= retries; attempt++) {

			try {

				WebElement element = WaitUtils.waitForClickable(locator, 10);

				((JavascriptExecutor) DriverFactory.getDriver())
						.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				// Find which element is intercepting the click
				JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

				int centerX = element.getRect().getX() + element.getRect().getWidth() / 2;
				int centerY = element.getRect().getY() + element.getRect().getHeight() / 2;

				String html = (String) js.executeScript(
					    "var e = document.elementFromPoint(arguments[0], arguments[1]);" +
					    "return e ? e.outerHTML : 'No element';",
					    centerX,
					    centerY);

					System.out.println("Intercepting element:");
					System.out.println(html);

				element.click();
				return;

			} catch (StaleElementReferenceException e) {

				if (attempt == retries) {
					throw e;
				}
			}
		}
	}

	public static void clickStaleElement(WebElement element, int retries) {
		for (int attempt = 1; attempt <= retries; attempt++) {
			try {
				WaitUtils.waitForClickable(element, 10);
				((JavascriptExecutor) DriverFactory.getDriver())
						.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
				element.click();
				return;
			} catch (StaleElementReferenceException e) {
				if (attempt == retries) {
					throw e;
				}
			}
		}

	}

	public static void clickStaleElement(By locator, int retries) {
		for (int attempt = 1; attempt <= retries; attempt++) {
			try {
				WebElement element = DriverFactory.getDriver().findElement(locator);
				WaitUtils.waitForClickable(element, 10);
				((JavascriptExecutor) DriverFactory.getDriver())
						.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
				element.click();
				return;
			} catch (StaleElementReferenceException e) {
				if (attempt == retries) {
					throw e;
				}
			}
		}
	}

	public static WebElement getVisibleElement(By locator) {
		List<WebElement> elements = DriverFactory.getDriver().findElements(locator);
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				return element;
			}
		}
		return null;
	}
}
