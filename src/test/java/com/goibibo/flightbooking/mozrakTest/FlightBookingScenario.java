package com.goibibo.flightbooking.mozrakTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.goibibo.flightbooking.mozrakTest.base.BaseFactory;
import com.goibibo.flightbooking.mozrakTest.page.DialogPage;
import com.goibibo.flightbooking.mozrakTest.page.HomePage;

public class FlightBookingScenario {

	@Test
	public void FlightBookingScenario_001() throws InterruptedException
	{
		BaseFactory.Android_LaunchApp();
		Thread.sleep(2500);
		DialogPage.pressSkipButton();
		Thread.sleep(1000);
		HomePage.verifyfromToFlightBooking("bengaluru","kolkata","1 Oct 2020", "5 Oct 2020");
	}
	
	@AfterTest
	public void End() {
		System.out.println("Stop driver");
		BaseFactory.getDriver().quit();
		System.out.println("Stop appium service");
		BaseFactory.getAppiumService().stop();
	}
}
