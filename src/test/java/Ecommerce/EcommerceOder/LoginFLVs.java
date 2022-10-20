package Ecommerce.EcommerceOder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GlobalProp.GlobalProp;
import GlobalProp.Retry;

public class LoginFLVs extends GlobalProp{
	
	@Test(dataProvider="data",groups="FLVs",retryAnalyzer=Retry.class)
	public void logInFLV(HashMap<String,String> map) throws IOException, InterruptedException
	{
	
		login.loginApplication(map.get("email"),map.get("password"));
		Assert.assertEquals(login.getErrormsg(), "Incorrect email or password.");
	
	}
	@DataProvider
	public Object[][] data() throws IOException
	{
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
//		HashMap<String,String> data=new HashMap<String,String>();
//		data.put("email","Samee@gmail.com");
//		data.put("password","Sameer@123");
//		
//		HashMap<String,String> data1=new HashMap<String,String>();
//		data1.put("email","Sameer@gmail.com");
//		data1.put("password","Sameer");
//		
//		return new Object[][] {{data},{data1}};
		
		//return new Object[][]{{"Samee@gmail.com","Sameer@123"},{"sameer@gmail.com","Sameer"}};
		
	}

}
