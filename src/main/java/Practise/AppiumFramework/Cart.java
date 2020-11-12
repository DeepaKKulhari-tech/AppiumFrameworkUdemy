package Practise.AppiumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart {
	
	public Cart(AppiumDriver driver)

	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//Total Purchase Amount
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	WebElement TotalPrice;
	

//Sum of all individual Product	
	public String SumProducts(AndroidDriver<AndroidElement> driver)
	{
		String Price; double Dollar; double TotalSum=0;
		int count=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		for(int i=0; i<count;i++)
		{
			 Price=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			 String modify=Price.replace("\"","");
			 Dollar=Double.parseDouble(modify.replace("$",""));
			 System.out.println("Product="+Dollar);
			 TotalSum=TotalSum+Dollar;
			 System.out.println("TotalSum="+TotalSum);
		}
		
		String PriceinDollars=String.valueOf(TotalSum);
		return PriceinDollars;
	}
	
}
