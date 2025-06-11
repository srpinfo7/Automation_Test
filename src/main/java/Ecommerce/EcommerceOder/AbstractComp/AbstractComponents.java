package Ecommerce.EcommerceOder.AbstractComp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecommerce.EcommerceOder.OrderSection;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void waitElementToApear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(5000));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitElementToApear(WebElement findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(5000));
		w.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitElementToDisapear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(5000));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public void waitElementToDisapear(WebElement findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(10000));
		w.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	public void clickOnCart()
	{
		cart.click();
	}
	@FindBy(css="button[routerlink*='myorders']")
	WebElement order;
	
	public OrderSection clickOnOrder()
	{
		order.click();
		OrderSection ord=new OrderSection(driver);
		return ord;
	}
}
