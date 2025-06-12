package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import Ecommerce.EcommerceOder.CartSection;
import Ecommerce.EcommerceOder.CheckOut;
import Ecommerce.EcommerceOder.ConfirmationPage;
import Ecommerce.EcommerceOder.LoginPage;
import Ecommerce.EcommerceOder.ProdCat;
import GlobalProp.GlobalProp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeOrderStefDefinations extends GlobalProp{
	
	public LoginPage login;
	public ProdCat prod;
	public CartSection cart;
	public CheckOut checkout;
	public ConfirmationPage cmpage;

    @Given("Landed to Loginpage")
    public void landed_to_loginpage() throws IOException {
    	login=lunchApp();
    }

    @Given("^Login to application using (.+) and (.+)$")
    public void login_to_application_using_credentials(String email, String password) {
    	prod=login.loginApplication(email, password);
    }
    

    @When("^add the (.+) to the cart$")
    public void add_the_product_to_the_cart(String productName) {
    	cart= prod.addToCart(productName);
    }

    @When("^Order the (.+) and Checkout the country (.+)$")
    public void order_the_product_and_checkout_country(String productName,String country) {
    	checkout= cart.placeOrder(productName);
    	cmpage=checkout.checkOut(country);
    
    	
    }

    @Then("{string} confirmation message verify.")
    public void confirmation_message_verify(String expectedMessage) {
    	String message=cmpage.getConfirmationMsg();
    	Assert.assertEquals(message, expectedMessage);
        driver.quit();
    }
    
    
    
    @Then("{string} message appeared.")
    public void Incorrect_email_or_password_message_appeared(String expectedMessage)
    {
    	Assert.assertEquals(login.getErrormsg(), expectedMessage);
    	 driver.quit();
    }

}
