package kiran.test;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Kiran.PageObjects.CartPage;
import Kiran.PageObjects.LoginPage;
import Kiran.PageObjects.OrderPage;
import Kiran.PageObjects.PaymentPage;
import Kiran.PageObjects.ProductCatlogPage;
import kiran.testcomponents.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SubmitOrder extends BaseTest{

	@Test(groups = "PurchaseOrder",dataProvider = "GetData")
	public void SubmitOrder(HashMap<String, String> input) throws InterruptedException
	{
		//Dharanidhar
 
		ProductCatlogPage productcatlog=loginpage.LoginDetails(input.get("email"), input.get("pass"));
		List<WebElement> products=productcatlog.GetProducts();
		CartPage cartpage=productcatlog.AddProductToCart(input.get("item"));
		boolean Match=cartpage.GetCartProducts(input.get("item"));	
		Assert.assertTrue(Match);
		PaymentPage paymentpage=cartpage.ClickOnCheckoutButton();
		paymentpage.SelectCountry();
		String confirmMsg=paymentpage.PlaceOrder();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	}
	@Test
	public void ValidateOrderPage()
	{
		ProductCatlogPage productcatlog=loginpage.LoginDetails("dharanidhar2211@gmail.com", "Ilovecricket@123");
		OrderPage orderpage=productcatlog.ClickOnOrderPage();
		String OrderItem=orderpage.OrderPageDetails();
		Assert.assertEquals(OrderItem, "ZARA COAT 3");
	}
	@DataProvider
	public Object[][] GetData() throws IOException
	{
		List<HashMap<String, String>> map=GetJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\kiran\\data\\purchaseorder.json");
		return new Object[][] {{map.get(0)},{map.get(1)}};
	}

}
