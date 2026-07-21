package com.gofood.Utility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.gofood.Factory.DriverFactory;

public class ScreenShotUtils {
	public static String onFailure(String filename) {
		Date d = new Date();
		String date = d.toString().replace(":", "_");
		File screenshotfolder;
		try {
			screenshotfolder = new File(ConfigReader.getConfig("screenshot"));
			if (!screenshotfolder.exists()) {
				screenshotfolder.mkdirs();
			}
			TakesScreenshot takeScreenshot = (TakesScreenshot) DriverFactory.getDriver();
			File store = takeScreenshot.getScreenshotAs(OutputType.FILE);
			String screenshotName = ConfigReader.getConfig("screenshot") + "/" + filename + "_" + date + ".png";
			File perm = new File(screenshotName);
			FileHandler.copy(store, perm);
            System.out.println(screenshotName);
            System.out.println(new File(screenshotName).exists());
			return screenshotName;
		} catch (Exception e) {
			throw new RuntimeException("Invalid screenshot path" + e.getMessage());
		}

	}
}
