package Kiran.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Kiran.AbstarctDetails.Abstract;

public class CartPage extends Abstract{

	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement w4;
	
	@FindBy(css =".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement Checkout;
	
	
	public boolean GetCartProducts(String item)
	{
		VisibilityofWebElement(w4);
		boolean Match=cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return Match;
	}
	public PaymentPage ClickOnCheckoutButton()
	{
		Checkout.click();
		PaymentPage paymentpage=new PaymentPage(driver);
		return paymentpage;
	}

}
