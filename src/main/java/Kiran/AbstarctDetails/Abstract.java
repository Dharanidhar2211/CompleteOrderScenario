package Kiran.AbstarctDetails;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Kiran.PageObjects.OrderPage;

public class Abstract {
	WebDriver driver;
	public Abstract(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	public void VisibilityofWebElement(WebElement wait1)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(wait1));
	}
	public void InvisibilityofWebElement(WebElement wait11) throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(wait11));
		Thread.sleep(2000);
	}
	@FindBy(css = "[routerlink*='myorders']")
	WebElement order ;
	
	public OrderPage ClickOnOrderPage()
	{
		order.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
	
	public void ClickOnCartbutton() 
	{
		cart.click();
	}
	public void Close()
	{
		driver.close();
	}
	
}
