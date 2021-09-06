package com.commbank.HomeLoanRepayment.automation.factory;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestInitilizer extends TestBase {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public static ExtentTest extentTest;

	@BeforeTest
	public void testInitialize() throws IOException {

		report = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Report.html");
		report.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("HomeLoanRepayment Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

		driver.get(DataProviderFactory.getConfigDataProvider().getValue("url"));

	}

	@AfterTest
	public void testClosure() {
		report.flush();
	}

}
