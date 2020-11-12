package Practise.AppiumFramework;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.DataProviderUtility;

public class DataProviderTest extends Base {

	// if data provider is in another pacakge then we use two parameter
	@Test(dataProvider = "lily test", dataProviderClass = DataProviderUtility.class)

	public void datatest(String data) throws IOException, InterruptedException {
		// AndroidDriver<AndroidElement> driver = capabilities("emulator",
		// "GlobalAppName");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(data);
		System.out.println("Finished");
	}
}
