	package Ecommerce.EcommerceOder;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--incognito");			
		WebDriver driver=new ChromeDriver(option);
		
		String prodname="iphone 13 pro";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage login=new LoginPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("sameer@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sameer@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofMillis(5000));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.tagName("b")).getText().equalsIgnoreCase(prodname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> items=driver.findElements(By.cssSelector(".items"));
		
		boolean itemPresent=items.stream().anyMatch(item ->
		item.findElement(By.tagName("h3")).getText().equalsIgnoreCase(prodname));
		
		Assert.assertTrue(itemPresent);
		driver.findElement(By.cssSelector("button[type=\"button\"]:nth-child(1)")).click();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='Select Country']"))).click().sendKeys("India").build().perform();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		a.moveToElement(driver.findElement(By.xpath("//button[contains(@class,\"ta-item\")] [2]"))).click().build().perform();
		driver.findElement(By.cssSelector(".btnn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		String oderconfirm=driver.findElement(By.tagName("h1")).getText();
		Assert.assertTrue(oderconfirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(5000);
		driver.close();
		
		}


}
