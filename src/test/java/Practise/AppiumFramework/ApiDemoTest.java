package Practise.AppiumFramework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.Utility;

public class ApiDemoTest extends Base {

	@Test
	public void test() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// It will bring the driver object from the base class
          //service=AppiumStart();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Tag name is TextView which also the class name and @Text is attribute name

		ApiDemoHomePage Hp = new ApiDemoHomePage(driver);
		Hp.Preferences.click();
		driver.navigate().back();

		Hp.getViewMethodName().click();

		Utility u = new Utility(driver);
		u.ScrollToText("ImageView");

		//service.stop();
		System.out.println("finishes");

	}
	
	@BeforeTest
	public void KillALLNodes() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
	
	

}
