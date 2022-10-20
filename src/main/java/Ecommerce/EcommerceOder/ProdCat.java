package Ecommerce.EcommerceOder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class ProdCat extends AbstractComponents {

	WebDriver driver;
	
	public ProdCat(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;	
	By productsBy=By.cssSelector(".mb-3");	
	By addCart=By.cssSelector(".card-body button:last-of-type");
	By toastContainer=By.id("toast-container");
	@FindBy(css=".ng-animating")
	WebElement animation;
    @FindBy(css=".ta-results")
    WebElement cartProds;
    
	
	public CartSection addToCart(String name)
	{
		waitElementToApear(productsBy);
		this.products=products;
		WebElement prod=products.stream().filter(product->
		product.findElement(By.tagName("b")).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
		prod.findElement(addCart).click();
		waitElementToApear(toastContainer);
		waitElementToDisapear(animation);
		clickOnCart();
		CartSection cs= new CartSection(driver);
		return cs;
		
	}
	
	
	
	
	
	
}

