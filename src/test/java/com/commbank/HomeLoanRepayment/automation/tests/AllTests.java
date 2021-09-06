package com.commbank.HomeLoanRepayment.automation.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.commbank.HomeLoanRepayment.automation.factory.TestInitilizer;
import com.commbank.HomeLoanRepayment.automation.pages.HomeLoanRepaymentsCalculatorPage;
import com.commbank.HomeLoanRepayment.automation.pages.HomePage;
import com.commbank.HomeLoanRepayment.automation.utils.Utility;

@Listeners(com.commbank.HomeLoanRepayment.automation.factory.TestListeners.class)
public class AllTests extends TestInitilizer {

	@BeforeMethod
	public void extentLoggerInitializer(Method method) {
		TestInitilizer.extentTest = report.createTest(method.getName());
	}

	@Test(enabled = true, priority = 0)
	public void HomePageScenarios() throws IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnRepaymentsCalculatorLink();
		
	}

	
	
	
	
	@Test(dataProvider="test-data",enabled = true, priority = 1)
	public void HomeLoanRepaymentsScenarios(String principal) throws IOException {
		HomeLoanRepaymentsCalculatorPage homeLoanRepaymentsCalculatorPage = new HomeLoanRepaymentsCalculatorPage(driver);
		homeLoanRepaymentsCalculatorPage.RepaymentCalculatorValidation(principal);

	}

	
	@DataProvider(name = "test-data")
	
	    public Object[][] dataProvFunc(){
	
	        return new Object[][]{
	
	                {"900000"},{"800000"},{"700000"},{"600000"},{"500000"}
	
	        };
	
	    }
	
	

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestInitilizer.extentTest.log(Status.FAIL, "Test " + result.getName() + " has been failed");
			TestInitilizer.extentTest.log(Status.DEBUG, result.getThrowable());
			TestInitilizer.extentTest.addScreenCaptureFromPath(Utility.takeScreenshot(driver));

		}

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
