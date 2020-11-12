package Practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	AppiumDriverLocalService service;
	static AndroidDriver<AndroidElement> driver;

	/*
	 * public AppiumDriverLocalService AppiumStart() { service =
	 * AppiumDriverLocalService.buildDefaultService(); service.start(); return
	 * service; }
	 */

	/*
	 * public AppiumDriverLocalService AppiumStart() {
	 * 
	 * boolean flag = checkIfServerIsRunnning(4723); if (!flag) {
	 * 
	 * service = AppiumDriverLocalService.buildDefaultService(); service.start(); }
	 * return service;
	 * 
	 * }
	 * 
	 * public static boolean checkIfServerIsRunnning(int port) {
	 * 
	 * boolean isServerRunning = false; ServerSocket serverSocket; try {
	 * serverSocket = new ServerSocket(port);
	 * 
	 * serverSocket.close(); } catch (IOException e) { // If control comes here,
	 * then it means that the port is in use isServerRunning = true; } finally {
	 * serverSocket = null; } return isServerRunning; }
	 */
	// to start the emulator from code
	public static void StartEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\emulator.bat");
		Thread.sleep(10000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String AppName) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Practise\\AppiumFramework\\Global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(AppName));
		String device = (String) prop.get("deviceName");
		// String device = System.getProperty("deviceName");
		// OR
		// File app = new File(appDir, device);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (device.equals("DKPixel")) {
			StartEmulator();
			// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
			// prop.get(device));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		} else
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

	/*
	 * public static void TakeScreenshot(String s) throws IOException { File srcfile
	 * = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * System.out.println(srcfile); FileUtils.copyFile(srcfile,new
	 * File(System.getProperty("user.dir")+"\\"+s+".png")); }
	 */

}
