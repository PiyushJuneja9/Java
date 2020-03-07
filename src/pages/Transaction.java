package pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.InvokeBrowser;

public class Transaction {

	public void Click(By locator) {
	
		InvokeBrowser.driver.findElement(locator).click();
	}
	
  public String Read_Captcha() {

	  return JOptionPane.showInputDialog("Please enter the captcha value:");	 
}
	
  public WebElement Element(By locator) {
	  
		return InvokeBrowser.driver.findElement(locator);	
	}
}
