package Practise.AppiumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStore_Products {

	public GeneralStore_Products(AppiumDriver driver)

	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Find the number of product at my screen and add the required one to the cart  
	
	public void FindProduct(AndroidDriver<AndroidElement> driver, String string) {

		int size = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println(size);

		for (int i = 0; i < size; i++) {
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

			if (text.equals("Jordan 6 Rings")) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;

			}

		}
	}
//scroll to the product by using Parent and child locators
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))")
	public WebElement SelectProduct;

	//View the cart
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	WebElement OpenCart;
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	WebElement AddToCart;

}
