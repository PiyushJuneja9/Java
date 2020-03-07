package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ExtentReport;
import utilities.LoadProperties;
import utilities.Locators;
import pages.LoginPage;

public class LoginTest {

	LoginPage loginpage;

	@BeforeClass(description = "Configure something before test")
	public void setup() throws Exception {

		loginpage = new LoginPage();
	}

	@BeforeMethod
	private void set() throws Exception {

		loginpage.LoginPageOpen();
	}

	@AfterMethod
	private void TeatDown() throws Exception {

		loginpage.LoginPageClose();
	}

	@Test(priority = 0)
	private void Login_EmptyUser_pass() {

		try {
			loginpage.login("", "");
			Assert.assertTrue(
					loginpage.Element(Locators.message).contains("Please enter valid Email ID/Mobile number"));
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {

			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 2)
	private void Login_EmptyUsername() {

		try {
			loginpage.login("", LoadProperties.config.getProperty("Password"));
			Assert.assertTrue(
					loginpage.Element(Locators.message).contains("Please enter valid Email ID/Mobile number"));
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {

			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 1)
	private void Login_EmptyPass() {
		try {
			loginpage.login(LoadProperties.config.getProperty("Email"), "");
			Assert.assertEquals(loginpage.Element(Locators.message), ("Please enter Password"));
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {

			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 3)
	private void login_ValidUserValidPass() throws Exception {
		try {
			Thread.sleep(3000);
			loginpage.login(LoadProperties.config.getProperty("Email"), LoadProperties.config.getProperty("Password"));
			Thread.sleep(3000);
			Assert.assertEquals(loginpage.Element(Locators.validateuser), ("Piyush"));
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {

			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

}
