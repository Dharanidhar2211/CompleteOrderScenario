package kiran.test;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Kiran.PageObjects.CartPage;
import Kiran.PageObjects.LoginPage;
import Kiran.PageObjects.OrderPage;
import Kiran.PageObjects.PaymentPage;
import Kiran.PageObjects.ProductCatlogPage;
import kiran.testcomponents.BaseTest;
import kiran.testcomponents.ReTry;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ErrorValidation extends BaseTest{

	@Test(retryAnalyzer = ReTry.class)
	public void ErrorMSGTest() throws InterruptedException
	{

		ProductCatlogPage productcatlog=loginpage.LoginDetails("dharanidhar220@gmail.com", "Ilovecricket@12a3");
		String errormsg=loginpage.ErrorPopup();
		Assert.assertEquals(errormsg, "Incorrect email or passworda.");
	}
	@Test
	public void OrderErrorTest() throws InterruptedException
	{
		ProductCatlogPage productcatlog=loginpage.LoginDetails("dharanidhar220@gmail.com", "Ilovecricket@123");
		List<WebElement> products=productcatlog.GetProducts();
		CartPage cartpage=productcatlog.AddProductToCart("ZARA COAT 3");
		boolean Match=cartpage.GetCartProducts("ZARA COAT 33");	
		Assert.assertFalse(Match);
	}

	
}
