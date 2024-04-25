package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import utilities.ExtentReporter;

public class MyListerners extends Base implements ITestListener {
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		System.out.println("On Test Start  :" + result);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed");
		System.out.println("on Test Success :" + Status.PASS);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.fail(result.getThrowable());

		WebDriver driver = null;

		String testName = result.getName();
		System.out.println("The name of the testcase failed is :" + testName);

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			String screenshotPath = takeScreenshot(testName, driver);
			extentTest.addScreenCaptureFromPath(screenshotPath, testName);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("The name of the testcase Skipped is :" + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The name of the test failed is :" + result.getName());

	}

	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("The name of the testcase failed with timeout is :" + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

	}

	

}
