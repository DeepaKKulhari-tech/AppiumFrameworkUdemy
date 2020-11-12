package Practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Cart_Test extends Base {

	@Test
	public void CartFunctionality() throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities("GlobalAppName");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		GeneralStore_Home gsh = new GeneralStore_Home(driver);
		gsh.YourName.sendKeys("Deepak");
		gsh.LetsShop.click();
		
		GeneralStore_Products gsp = new GeneralStore_Products(driver);
		gsp.AddToCart.click();
		gsp.AddToCart.click();
		gsp.OpenCart.click();
		
		Cart c =new Cart(driver);
		
		String SumofAllProducts=c.SumProducts(driver);
		
		Assert.assertEquals("$ "+SumofAllProducts,c.TotalPrice.getText());
		
		
		
		
	}

}
