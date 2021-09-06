package com.commbank.HomeLoanRepayment.automation.factory;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.commbank.HomeLoanRepayment.automation.utils.Utility;

public class TestListeners extends TestBase implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart -->> " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart -->> " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess -->> " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {

			TestInitilizer.extentTest.fail("Screenshot of failure"
					+ MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.takeScreenshot(driver)).build());

		} catch (IOException e) {

			TestInitilizer.extentTest.fail("Test Failed, cannot attach screenshot");
		}

		System.out.println("onTestFailure -->> " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -->> " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage -->> " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish -->> " + context.getName());
	}

}
