package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.AddToCompare;
import utilities.ExtentReport;
import utilities.InvokeBrowser;
import utilities.Locators;

public class AddToCompareTest {

	AddToCompare addtocompare;

	@BeforeClass
	public void setup() throws InterruptedException {

			addtocompare = new AddToCompare();
			Thread.sleep(5000);
			InvokeBrowser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	private void Dropdown() throws InterruptedException {
		try {
			Assert.assertTrue(addtocompare.Element(Locators.Dropdown_TVs_Appliances).contains("TVs & Appliances"));
			addtocompare.MouseHover(Locators.Dropdown_TVs_Appliances);
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 1)
	private void Select_SubOption() throws InterruptedException {
		try {
			Assert.assertTrue(addtocompare.Element(Locators.CoffeeMaker).contains("Coffee Maker"));
			addtocompare.Click(Locators.CoffeeMaker);
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 2)
	private void Select_Filter() throws InterruptedException {
		try {
			Thread.sleep(3000);
	        Assert.assertTrue(addtocompare.Element(Locators.PriceLowtoHigh).contains("Price -- Low to High"));
			addtocompare.Click(Locators.PriceLowtoHigh);
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 3)
	private void Select_ItemsToCompare() throws InterruptedException {	
		try {
			addtocompare.MouseHover(Locators.CartItem1);
			addtocompare.Click(Locators.AddtoCompare1);

			addtocompare.MouseHover(Locators.CartItem2);
			addtocompare.Click(Locators.AddtoCompare2);

			addtocompare.MouseHover(Locators.CartItem3);
			addtocompare.Click(Locators.AddtoCompare3);

			addtocompare.MouseHover(Locators.CartItem4);
			addtocompare.Click(Locators.AddtoCompare4);

			Assert.assertEquals(addtocompare.Element(Locators.Total_item), "4");
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	@Test(priority = 4)
	private void OpenPage_CompareToOtherItems() throws InterruptedException {
		try {
			Thread.sleep(3000);
			Assert.assertEquals(addtocompare.Element(Locators.CompareButton), "COMPARE");
			addtocompare.Click(Locators.CompareButton);
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");;
		}

	}

	@Test(priority = 5)
	private void Click_AddToCart() throws InterruptedException {
		try {
			Thread.sleep(3000);
			Assert.assertTrue(addtocompare.Element(Locators.AddtoCart).contains("GO TO CART"));
			addtocompare.Click(Locators.AddtoCart);
			ExtentReport.test.log(LogStatus.PASS, "");
		} catch (Exception e) {
			ExtentReport.test.log(LogStatus.FAIL, "");
		}

	}

	/*
	 * @Test(priority = 6) private void test7() throws InterruptedException {
	 * 
	 * addtocompare.Click(Locators.OrderButton); }
	 */
}
