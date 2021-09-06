package com.commbank.HomeLoanRepayment.automation.pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.commbank.HomeLoanRepayment.automation.factory.DataProviderFactory;
import com.commbank.HomeLoanRepayment.automation.utils.Utility;

public class HomeLoanRepaymentsCalculatorPage {

	public WebDriver driver;
	public ExtentTest logger;


	@FindBy(xpath = "//input[@id='amount']")
	private WebElement Principal;
	
	@FindBy(xpath ="//button[@id='submit']")
	private WebElement CalculateButton;

	@FindBy(xpath = "//span[@data-tid='total-interest']")
	private WebElement TotalInterestCharged;

	@FindBy(xpath = "//span[@data-tid='total-repayment']")
	private WebElement TotalLoanRepayments;
	
	
	

	public HomeLoanRepaymentsCalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void RepaymentCalculatorValidation(String principal) {
		
		Utility.moveToElementAndClickAction(driver, Principal);
		Principal.clear();
        Principal.clear();
		Utility.sleep(5);
		Utility.sendKeysAction(driver, Principal, principal);
		
        Utility.pressEnterKeyAction(driver);
		
		Utility.pressPageDownKeyAction(driver);
        
		Utility.sleep(5);
		
		String TotalInterest= TotalInterestCharged.getText();
		
		StringBuilder str= new StringBuilder(TotalInterest);
		
		StringBuilder afterRemoval= str.deleteCharAt(0);
		
		
		long TotalInterestcharged= Long.valueOf(afterRemoval.toString().replaceAll(",", ""));
		
		System.out.println(TotalInterestcharged);
		
		
		String TotalLoanRepay= TotalLoanRepayments.getText();
		
		StringBuilder str1= new StringBuilder(TotalLoanRepay);
		
		StringBuilder afterRemoval1= str1.deleteCharAt(0);
		
		long TotalLoanrepayment= Long.valueOf(afterRemoval1.toString().replaceAll(",", ""));
		
		System.out.println(TotalLoanrepayment);
		
		Assert.assertEquals(Long.valueOf(principal)+TotalInterestcharged, TotalLoanrepayment);
		
		
		Utility.pressPageUpKeyAction(driver);
			
		}

		
		
	}

	
	

