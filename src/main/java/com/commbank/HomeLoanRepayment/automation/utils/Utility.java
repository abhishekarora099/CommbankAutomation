package com.commbank.HomeLoanRepayment.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Utility {

	static WebElement element;

	public static String takeScreenshot(WebDriver driver) throws IOException {
		String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		// return scrFile;
		return "data:image/jpg;base64," + scrFile;

	}

	public static String getScreenshot(WebDriver driver, String ScreenShotName) throws IOException {
		String dateName = new SimpleDateFormat("YYYYMMDDHHMMSS").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedScreenshots/" + ScreenShotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		String Imagepath = "file://Machinename/FailedScreenshots/" + ScreenShotName + dateName + ".png";
		return Imagepath;
	}

	public static void sleep(int tSeconds) {
		try {
			Thread.sleep(tSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static WebElement checkElement(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public static void clickAction(WebDriver driver, WebElement element) {
		checkElement(driver, element).click();
	}

	public static void sendKeysAction(WebDriver driver, WebElement element, String stringToSend) {
		checkElement(driver, element).sendKeys(stringToSend);
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		ActionActivities.moveToElement(driver, checkElement(driver, element));
	}

	public static void moveToElementAndClickAction(WebDriver driver, WebElement element) {
		ActionActivities.moveToElementAndClick(driver, checkElement(driver, element));
	}

	public static void moveToElementAndPageDownAction(WebDriver driver, WebElement element) {
		ActionActivities.moveToElementAndPageDown(driver, checkElement(driver, element));

	}

	public static void moveToElementAndInputTextAction(WebDriver driver, WebElement element, String text) {
		ActionActivities.moveToElementAndInputText(driver, checkElement(driver, element), text);
	}

	public static void openNewTabInBrowserAction(WebDriver driver) {
		ActionActivities.openNewTabInBrowser(driver);
	}

	public static void pressTabKeyAction(WebDriver driver) {
		ActionActivities.presstabKey(driver);
	}

	public static void pressSpaceKeyAction(WebDriver driver) {
		ActionActivities.pressspaceKey(driver);
	}

	public static void pressEnterKeyAction(WebDriver driver) {
		ActionActivities.pressEnterKey(driver);
	}

	public static void pressEscKeyAction(WebDriver driver) {
		ActionActivities.pressEscKey(driver);
	}

	public static void pressUpArrowKeyAction(WebDriver driver) {
		ActionActivities.pressUpArrowKey(driver);
	}

	public static void pressDownArrowKeyAction(WebDriver driver) {
		ActionActivities.pressDownArrowKey(driver);
	}

	public static void pressRightArrowKeyAction(WebDriver driver) {
		ActionActivities.pressRightArrowKey(driver);
	}

	public static void pressLeftArrowKeyAction(WebDriver driver) {
		ActionActivities.pressLeftArrowKey(driver);
	}

	public static void pressPageDownKeyAction(WebDriver driver) {
		ActionActivities.pressPageDownKey(driver);
	}

	public static void pressPageUpKeyAction(WebDriver driver) {
		ActionActivities.pressPageUpKey(driver);
	}

}
