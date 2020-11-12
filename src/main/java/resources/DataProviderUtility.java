package resources;

import org.testng.annotations.Test;


public class DataProviderUtility {

@org.testng.annotations.DataProvider(name="lily test")
	public Object[][] GiveData()
	{
		Object[][] data=new Object[][]
				{{"DK"},{"SK"}
			
				};
				return data;
		
	}
}
