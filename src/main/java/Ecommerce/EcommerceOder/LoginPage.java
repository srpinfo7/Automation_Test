package Ecommerce.EcommerceOder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Ecommerce.EcommerceOder.AbstractComp.AbstractComponents;

public class LoginPage extends AbstractComponents{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorToast;

	
	public String getErrormsg()
	{
		waitElementToApear(errorToast);
		return errorToast.getText();
		
	}
	
	
	public ProdCat loginApplication(String email,String pass)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		ProdCat pro= new ProdCat(driver);
		return pro;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
