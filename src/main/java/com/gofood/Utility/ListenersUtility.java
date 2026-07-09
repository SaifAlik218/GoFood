package com.gofood.Utility;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersUtility implements ITestListener, ISuiteListener {
	private static volatile ExtentReports report;
	private final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static final Object LOCK = new Object();

	public void onStart(ITestContext context) {
		if (report == null) {
			synchronized (LOCK) {
				if (report == null) {
					Date d = new Date();
					String date = d.toString().replace(":", "_");
					File reportsDir = new File("/Users/testuser/Desktop/Selenium/com.gofood/reports");
					if (!reportsDir.exists()) {
						reportsDir.mkdirs();
					}
					// to generate report and configuring the report
					ExtentSparkReporter sparkreport = new ExtentSparkReporter("./reports/GoFood+" + date + ".html");
					sparkreport.config().setTheme(Theme.DARK);
					sparkreport.config().setReportName("Testing");
					sparkreport.config().setDocumentTitle("GoFood Report");
					report = new ExtentReports();
					// to update report info
					report.attachReporter(sparkreport);
					report.setSystemInfo("Application", "Gofood web");
					report.setSystemInfo("OS", System.getProperty("os.name"));
					report.setSystemInfo("Reporter", System.getProperty("user.name"));
					String browser = context.getCurrentXmlTest().getAllParameters().get("browser");
					report.setSystemInfo("Browser", browser);
					List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
					if (!includedGroups.isEmpty()) {
						report.setSystemInfo("Groups", includedGroups.toString());
					}
				}
			}
		}

	}

	public void onTestSuccess(ITestResult result) {
		test.set(report.createTest(result.getClass().getName()));
		test.get().assignCategory(result.getMethod().getGroups());
		test.get().log(Status.PASS, "Test case passed" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.set(report.createTest(result.getClass().getName()));
		test.get().assignCategory(result.getMethod().getGroups());
		String screenshot = ScreenShotUtils.onFailure(result.getName());
		test.get().addScreenCaptureFromPath(screenshot);
		test.get().log(Status.FAIL, "Test case failed" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		test.set(report.createTest(result.getClass().getName()));
		test.get().assignCategory(result.getMethod().getGroups());
		test.get().log(Status.SKIP, "Test case skipped" + result.getName());
	}

	public void onFinish(ISuite suite) {
		if (report != null) {
			report.flush();
		}
	}

}
