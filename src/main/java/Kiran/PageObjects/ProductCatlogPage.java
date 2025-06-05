package Kiran.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Kiran.AbstarctDetails.Abstract;

public class ProductCatlogPage extends Abstract {

	WebDriver driver;
	public ProductCatlogPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")
	WebElement w1;
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".toast-message")
	WebElement w2;
	
	
	
	@FindBy(css = ".ng-animating")
	WebElement w3;
	
	public List<WebElement> GetProducts()
	{ 
		VisibilityofWebElement(w1);
		return products;	
	}
	public WebElement GetProduct(String item)
	{
		WebElement prod=GetProducts().stream().filter(s->s.findElement(By.tagName("b")).getText().equalsIgnoreCase(item)).findFirst().orElse(null);
		return prod;
	}
	public CartPage AddProductToCart(String item) throws InterruptedException
	{
		WebElement prod=GetProduct(item).findElement(By.cssSelector(".card-body button:last-of-type"));
		prod.click();
		VisibilityofWebElement(w2);
		InvisibilityofWebElement(w3);
		ClickOnCartbutton();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	
	
}
