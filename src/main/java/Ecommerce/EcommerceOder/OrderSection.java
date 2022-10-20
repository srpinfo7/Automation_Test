package Ecommerce.EcommerceOder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class OrderSection extends AbstractComponents {

	WebDriver driver;
	public OrderSection(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orders;
	@FindBy(css="tr td:nth-child(3)")
	WebElement ordersItem;		
	
	
	public boolean order(String prodname)
	{

		return orders.stream().anyMatch(item ->
		item.getText().equalsIgnoreCase(prodname));
	}
	
}
