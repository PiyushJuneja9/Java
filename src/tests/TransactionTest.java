package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Transaction;
import utilities.ExtentReport;
import utilities.Locators;

public class TransactionTest {
	
	Transaction transaction;
	

	@BeforeClass
	private void setup() {
		transaction = new Transaction();
		
		
	}
	@Test(priority = 1)
	public void order() {
		transaction.Click(Locators.OrderButton);
	}
	
	@Test(priority = 2)
	private void Continue_Button() {
		
		transaction.Click(Locators.ContinueButton);
	}
	
	@Test(priority = 3)
	public void Select_PaymentOpion() {
		transaction.Click(Locators.CaseOnDelivery);
		transaction.Element(Locators.Captacha).sendKeys(transaction.Read_Captcha());
		//transaction.Click(Locators.ConfirmOrderButton);
	}
	
	@AfterClass
	private void teatdown() {
		
		ExtentReport.endTest();
	}
     
}
