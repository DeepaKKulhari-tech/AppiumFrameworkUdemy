package Practise.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStore_Home {

	public GeneralStore_Home(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//Enter the name in the textBox
	@AndroidFindBy(xpath="//android.widget.EditText")
	public WebElement YourName;
	
	//Click the Button to shop
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShop;
	
	
}
