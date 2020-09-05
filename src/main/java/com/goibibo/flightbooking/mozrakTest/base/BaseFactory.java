package com.goibibo.flightbooking.mozrakTest.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseFactory {
	private static AndroidDriver<WebElement> driver;
	private static AppiumDriverLocalService appiumService;
	public static AppiumDriverLocalService getAppiumService() {
		return appiumService;
	}
	public static void setAppiumService(AppiumDriverLocalService appiumService) {
		BaseFactory.appiumService = appiumService;
	}
	public static AndroidDriver<WebElement> getDriver() {
		return driver;
	}
	public static void setDriver(AndroidDriver<WebElement> driver) {
		BaseFactory.driver = driver;
	}
	private static String appiumServiceUrl;
	public static void Android_LaunchApp() throws InterruptedException
	{
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
		System.out.println("Appium Service Address : - " + appiumServiceUrl);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZY322P28WF");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "com.goibibo");
		capabilities.setCapability("appActivity", "com.goibibo.common.HomeActivity");

		try {
			driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
	}

	
	

}
