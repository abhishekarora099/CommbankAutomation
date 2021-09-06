package com.commbank.HomeLoanRepayment.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.commbank.HomeLoanRepayment.automation.utils.Utility;

public class HomePage {
	
	public WebDriver driver;
	public ExtentTest logger;

	@FindBy(xpath = "//a[normalize-space()='Repayments calculator']")
	private WebElement RepaymentsCalculatorLink;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRepaymentsCalculatorLink() {
		
		Utility.pressPageDownKeyAction(driver);
		
		Utility.sleep(5);

		Utility.moveToElementAndClickAction(driver, RepaymentsCalculatorLink);
		
        Utility.sleep(5);

	}

	

}
