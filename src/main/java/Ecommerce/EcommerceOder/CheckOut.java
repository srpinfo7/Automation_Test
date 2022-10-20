package Ecommerce.EcommerceOder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class CheckOut extends AbstractComponents {
	
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(css="input[placeholder='Select Country']")
	WebElement typeIndia;
	@FindBy(xpath="//button[contains(@class,\"ta-item\")] [2]")
	WebElement clickIndia;
	@FindBy(css=".btnn")
	WebElement placeOrder;
	public ConfirmationPage checkOut(String country)
	{
		Actions a=new Actions(driver);
		a.sendKeys(typeIndia, country).build().perform();
		a.moveToElement(clickIndia).click().build().perform();
		placeOrder.click();
		return new ConfirmationPage(driver);
		
	}
	

}
