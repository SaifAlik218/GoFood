package com.gofood.Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gofood.Factory.DriverFactory;

public class WaitUtils {
	protected static WebDriverWait wait;
	protected static JavascriptExecutor jse;

	public static void waitForVisibility(WebElement element, int sec) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForVisibility(List<WebElement> element, int sec) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void waitForClickable(WebElement element, int sec) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForClickable(By by, int sec) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitForText(WebElement element, int seconds) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds));

		wait.until(driver -> !element.getDomProperty("textContent").trim().isEmpty());
	}

	public static void waitForUrl(String URL, int seconds) {
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds));
		try {
			wait.until(ExpectedConditions.urlContains(URL));
		} catch (Exception e) {

			throw new RuntimeException("Failed to find URL :" + URL, e);
		}
	}
}
