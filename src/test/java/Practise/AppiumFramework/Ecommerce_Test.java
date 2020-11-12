package Practise.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Test extends Base {

	@Test
	public void testCase() throws IOException, InterruptedException

	{

		AndroidDriver<AndroidElement> driver = capabilities("GlobalAppName");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		GeneralStore_Home gsh = new GeneralStore_Home(driver);
		gsh.YourName.sendKeys("Deepak");
		gsh.LetsShop.click();

		GeneralStore_Products gsp = new GeneralStore_Products(driver);
		gsp.SelectProduct.click();

		gsp.FindProduct(driver, "Jordan 6 Rings");

		gsp.OpenCart.click();
		
		String lastPageText=driver.findElementById("com.androidsample.generalstore:id/productName").getText();

		Assert.assertEquals("Jordan 6 Rings", lastPageText);
		System.out.println("Finished");

	}
}
