package Ecommerce.EcommerceOder;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;
import GlobalProp.GlobalProp;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MakeOrder extends GlobalProp {
	String prodname = "zara coat 3";
	@Test(dataProvider = "orderData")
	public void makeOrder(String username,String password,String prodname) throws IOException, InterruptedException {

		
		String country = "India";
		ProdCat pro = login.loginApplication(username, password);
		CartSection cs = pro.addToCart(prodname);
		CheckOut ck = cs.placeOrder(prodname);
		ConfirmationPage cm = ck.checkOut(country);
		String cmsg = cm.getConfirmationMsg();
		Assert.assertEquals(cmsg, "THANKYOU FOR THE ORDER.");
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "makeOrder")
	public void checkOrder() throws IOException, InterruptedException
	{
		ProdCat pro = login.loginApplication("sameer@gmail.com", "Sameer@123");
		OrderSection ord=pro.clickOnOrder();
		Assert.assertTrue(ord.order(prodname));
	}
	
	
	@DataProvider
	public Object[][] orderData()
	{
		return new Object[][] {{"sameer@gmail.com", "Sameer@123","zara coat 3"},{"sameer@gmail.com", "Sameer@123","ADIDAS ORIGINAL"}};
	}
}
