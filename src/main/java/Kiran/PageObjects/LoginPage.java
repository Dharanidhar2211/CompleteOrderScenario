package Kiran.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kiran.AbstarctDetails.Abstract;

public class LoginPage extends Abstract
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement mail;
	
	
	@FindBy(id = "userPassword")
	WebElement pass;
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = ".toast-message")
	WebElement error;
	
	
	public void GoTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public ProductCatlogPage LoginDetails(String Gmail,String Password)
	{
		mail.sendKeys(Gmail);
		pass.sendKeys(Password);
		login.click();
		ProductCatlogPage productcatlog=new ProductCatlogPage(driver);
		return productcatlog;
	}
	public String ErrorPopup()
	{
		String errormsg=error.getText();
		return errormsg;
	}

}
