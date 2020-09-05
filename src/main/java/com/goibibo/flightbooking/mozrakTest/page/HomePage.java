package com.goibibo.flightbooking.mozrakTest.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.goibibo.flightbooking.mozrakTest.base.*;

import io.appium.java_client.pagefactory.AndroidFindBy;


public class HomePage {
	public HomePage(){
        PageFactory.initElements(BaseFactory.getDriver(), this);
    }
	private static String xpathFlights= "//android.widget.TextView[@text='Flights']";
	private static String id_FlightForm = "com.goibibo:id/flightFrom";
	private static String id__Search = "com.goibibo:id/search_edit";
	private static String id_FlightTo = "com.goibibo:id/flightTo";
	private static String xpath_Blr_Airport = "//*[contains(@text, 'BLR, Kempegowda International Airport')]";
    private static String id_FlightFromDate="com.goibibo:id/textFlightOnwDate";
    private static String id_FlightToDate="com.goibibo:id/tapToSelect";
	private static String xpath_btnOk = "//*[contains(@text,'OK')]";
	@AndroidFindBy()
	private static WebElement ok_btn;
	public static void verifyfromToFlightBooking(String FromPlace , String ToPlace,String FromDate,String ToDate) throws InterruptedException
	{
		BaseFactory.getDriver().findElement(By.xpath(xpathFlights)).click();
		
		Thread.sleep(2500);
		BaseFactory.getDriver().findElement(By.id(id_FlightForm)).click();
		
		BaseFactory.getDriver().findElement(By.id(id__Search)).sendKeys(FromPlace);
		BaseFactory.getDriver().findElement(By.xpath(xpath_Blr_Airport)).click();
		
		Thread.sleep(3000);
		BaseFactory.getDriver().findElement(By.id(id_FlightTo)).click();
		BaseFactory.getDriver().findElement(By.id(id__Search)).sendKeys(ToPlace);;
		WebElement selectKolkataAirport = BaseFactory.getDriver().findElement(By.xpath("//*[contains(@text, 'Kolkata')]"));
		selectKolkataAirport.click();
		
		//select fromdate
		Thread.sleep(2000);
		BaseFactory.getDriver().findElement(By.id(id_FlightFromDate)).click();
		//select 1st of OCT
		selectDate("1");
		
		//SelectToDate
		Thread.sleep(2000);
		BaseFactory.getDriver().findElement(By.id(id_FlightToDate)).click();
		//select 2nd of OCT
		selectDate("5");
		
		//press btn oK
		BaseFactory.getDriver().findElement(By.xpath(xpath_btnOk)).click();		
		
		//tap on search
		Thread.sleep(2000);
		BaseFactory.getDriver().findElement(By.xpath("//*[contains(@text,'SEARCH')]")).click();
		
		Thread.sleep(2000);
		String verifyFromTitle = BaseFactory.getDriver().findElement(By.id("com.goibibo:id/toolbar_onw_custom_title")).getText();
		Assert.assertEquals("Bengaluru",verifyFromTitle,"booking title is not matching with expected city");
		Thread.sleep(5000);
	}
	
	private static void selectDate(String expdate) throws InterruptedException {
		// scroll to OCT 1 2020
		//String str = "Oct 2020";
		// Scroll Down to OCT
		Thread.sleep(2500);
		new com.goibibo.flightbooking.mozrakTest.base.Utils().scrollDown();
		List<WebElement> dates = BaseFactory.getDriver().findElements(By.id("com.goibibo:id/date"));
		for (WebElement date : dates) {
			try {
				if (date.getText().equals(expdate)) {
					date.click();
					break;
				}
			} catch (Exception e) {
				System.out.print(e);
			}
		}
	}

}
