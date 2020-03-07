package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AddBySearch;
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.LoadProperties;
import utilities.Locators;

public class AddBySearchTest {

	AddBySearch addbysearch;

	@BeforeClass
	private void setup() {

		addbysearch = new AddBySearch();
	}

	@Test(priority = 0)
	private void SearchProduct() {

		try {
			addbysearch.SearchProduct(LoadProperties.config.getProperty("ProductName"));
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {

		}

	}

	@Test(priority = 1)
	private void Select_Item() {

		addbysearch.click(Locators.SelectItem);
		InvokeBrowser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	private void AddToCart() {

		addbysearch.click(Locators.AddtoCartButton);
	}

}
