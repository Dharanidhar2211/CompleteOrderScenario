package Kiran.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kiran.AbstarctDetails.Abstract;

public class OrderPage extends Abstract{

WebDriver driver;
	
	public OrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".ng-star-inserted td:nth-child(3)")
	List<WebElement> Orderitem;
	
	public String OrderPageDetails()
	{
		ClickOnOrderPage();
		String OrderItem=Orderitem.get(0).getText();
		return OrderItem;
	}
	
}
