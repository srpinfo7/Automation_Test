package Ecommerce.EcommerceOder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By confirm=By.tagName("h1");
	@FindBy(tagName = "h1")
	WebElement cmsg;
	
	public String getConfirmationMsg()
	{
		waitElementToApear(confirm);
		return cmsg.getText();
		
	}

}
