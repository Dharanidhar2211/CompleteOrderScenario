package Kiran.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Kiran.AbstarctDetails.Abstract;

public class PaymentPage extends Abstract {

WebDriver driver;
	
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = ".payment__title")
	WebElement w5;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement con;
	
	@FindBy(css = ".ta-results button:last-of-type")
	WebElement actcon;
	
	@FindBy(css = ".action__submit")
	WebElement PlaceOrder;
	
	
	@FindBy(css = ".hero-primary")
	WebElement w6;
	
	
	
	@FindBy(css = ".hero-primary")
	WebElement confmsg;
	public void SelectCountry()
	{
		VisibilityofWebElement(w5);
		Actions a=new Actions(driver);
		a.click().sendKeys(con,"India").build().perform();
		actcon.click();
	}
	public String PlaceOrder()
	{
		PlaceOrder.click();
		VisibilityofWebElement(w6);
		String confirmMsg=confmsg.getText();
		return confirmMsg;
	}
}
