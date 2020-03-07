package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.LoadProperties;
import utilities.Locators;

public class HomePageTest {

	public HomePage homepage;

	@BeforeClass(description = "Configure something before test")
	@Parameters("Browser")
	public void setup(String Browser) throws Throwable {

		LoadProperties.property();

		ExtentReport.startTest();

		homepage = new HomePage();
		homepage.LaunchFlipkart(Browser);
	}

	@Test(priority = 0)
	private void FlipkartTitle() {

		try {
			String title = homepage.Title();
			Assert.assertTrue(title.contains("Online Best Shopping Site"));
			ExtentReport.test.log(LogStatus.FAIL, "Flipkart Title Not Verified");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.PASS, "Flipkart Title Verified");
		}
	}

	@Test(priority = 1)
	private void FlipkartLoginBtn() {
		try {
			Assert.assertTrue(InvokeBrowser.driver.findElement(Locators.LoginButton).isDisplayed());
			ExtentReport.test.log(LogStatus.PASS, "Login Button is Visible");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "Login Button is not visible");
		}
	}

}
