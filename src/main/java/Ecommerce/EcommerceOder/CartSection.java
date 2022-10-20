package Ecommerce.EcommerceOder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class CartSection extends AbstractComponents {

	WebDriver driver;
	public CartSection(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".items")
	List<WebElement> items;
	@FindBy(css=".items")
	WebElement cartItem;	
	@FindBy(css="button[type=\"button\"]:nth-child(1)")
	WebElement checkout;	
	
	
	public CheckOut placeOrder(String prodname)
	{
		waitElementToApear(cartItem);
		this.items= items;
		boolean itemPresent=items.stream().anyMatch(item ->
		item.findElement(By.tagName("h3")).getText().equalsIgnoreCase(prodname));
		checkout.click();
		return new CheckOut(driver);	}
	
}
