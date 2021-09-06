package com.commbank.HomeLoanRepayment.automation.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionActivities {

	public static void moveToElementAndClick(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).pause(1500).click().build().perform();
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).pause(1500).build().perform();
	}

	public static void moveToElementAndPageDown(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).click();
		new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();

	}

	public static void moveToElementAndInputText(WebDriver driver, WebElement element, String text) {
		// new
		// Actions(driver).moveToElement(element).click().sendKeys(text,Keys.ENTER).perform();
		new Actions(driver).moveToElement(element).click().pause(1000).sendKeys(text).pause(1500).sendKeys(Keys.ENTER)
				.build().perform();
	}

	public static void openNewTabInBrowser(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "t")).perform();

	}

	public static void presstabKey(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.TAB).build().perform();
	}

	public static void pressspaceKey(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.SPACE).build().perform();
	}

	public static void pressEnterKey(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
	}

	public static void pressEscKey(WebDriver driver) {
		new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();

	}

	public static void pressUpArrowKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.ARROW_UP).build().perform();
	}

	public static void pressDownArrowKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public static void pressRightArrowKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.ARROW_RIGHT).build().perform();
	}

	public static void pressLeftArrowKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.ARROW_LEFT).build().perform();
	}

	public static void pressPageDownKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public static void pressPageUpKey(WebDriver driver) {

		new Actions(driver).sendKeys(Keys.PAGE_UP).build().perform();
	}

}
