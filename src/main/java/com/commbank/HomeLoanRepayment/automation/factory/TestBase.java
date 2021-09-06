package com.commbank.HomeLoanRepayment.automation.factory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.nio.file.Files;
import java.nio.file.Path;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static File folder;

	@BeforeSuite
	public WebDriver initializeDriver() throws IOException {
		switch (DataProviderFactory.getConfigDataProvider().getValue("browser").toUpperCase()) {
		case "CHROME":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			opt.setExperimentalOption("prefs", prefs);
			opt.addArguments("--disable-infobars");
			opt.setExperimentalOption("useAutomationExtension", false);
			opt.addArguments("--disable-notifications");
			opt.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			
			cap.setCapability(ChromeOptions.CAPABILITY, opt);

			driver = new ChromeDriver(opt);
			driver.manage().window().setSize(new Dimension(1600, 900));
			browserSettings();
			break;

		case "FIREFOX":
			if (System.getProperty("os.name").toLowerCase().contains("win"))
				WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			browserSettings();
			break;

		default:
			System.out.println("Browser name provided is wrong");
			System.exit(0);
		}
		return driver;
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	private void browserSettings() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

}
