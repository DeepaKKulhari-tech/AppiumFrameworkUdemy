package Practise.AppiumFramework;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;


public class LoggingPractise {

	Logger log=(Logger) LogManager.getLogManager().getLogger(LoggingPractise.class.getName());
	
	@Test
	public void Demo()
	{
		log.debug(" Starting with the logging");
		log.info("Printing success");
		log.error("Getting invoked when error");
		log.fatal("application should end at this point");
	}
}
