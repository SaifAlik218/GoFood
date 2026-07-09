package com.gofood.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gofood.Utility.ConfigReader;

public class DriverFactory {
	private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeDriver(String browser) throws Exception {
		log.info("Initializing driver for browser: {}", browser);
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			if (Boolean.parseBoolean(ConfigReader.getInstance().getConfig("headless"))) {
				options.addArguments("--headless=new");
			}
			log.info("Initializing Chrome driver for browser: {}", browser);
			driver.set(new ChromeDriver(options));
		} else if (browser.equalsIgnoreCase("safari")) {
			log.info("Initializing Safari driver for browser: {}", browser);
			driver.set(new SafariDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			log.info("Initializing Firefox driver for browser: {}", browser);
			driver.set(new FirefoxDriver());
		} else {
			log.error("Unsupported browser: {}", browser);
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		return driver.get();
	}

	public static WebDriver getDriver() {
		if (driver.get() == null) {
			log.error("getDriver() called before initDriver() on thread: {}", Thread.currentThread().getId());
			throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
		}
		return driver.get();
	}

	public static void teardown() {
		if (driver != null) {
			log.info("Quitting driver on thread: {}", Thread.currentThread().getId());
			driver.get().quit();
			driver.remove();
		}
	}

}
