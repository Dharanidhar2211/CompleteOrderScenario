package kiran.stepdefinations;

import java.io.IOException;

import org.testng.Assert;

import Kiran.PageObjects.LoginPage;
import Kiran.PageObjects.ProductCatlogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import kiran.testcomponents.BaseTest;


public class stepdefinations extends BaseTest 
{	
	
	public LoginPage loginpage;
	public ProductCatlogPage productcatlog;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		loginpage =InitinilizeDriver();
	}
	@And("^Logged in with valid username(.+) and password (.+)$")
	public void Logged_In_with_Valid_UserName_And_Password(String email,String password)
	{
		 productcatlog=loginpage.LoginDetails(email, email);
	}
	@Then("{string} message is  Displayed")
	public void ErrorMsg_Is_Displayed(String error)
	{
		String errormsg=loginpage.ErrorPopup();
		Assert.assertEquals(errormsg, error);
		driver.close();
	}
	
	
		
		
	

}
