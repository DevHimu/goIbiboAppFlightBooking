package com.goibibo.flightbooking.mozrakTest.base;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {
	 @SuppressWarnings("rawtypes")
	public  void scrollDown(){
		    
	        Dimension dimension = BaseFactory.getDriver().manage().window().getSize();
	        int scrollStart = (int) (dimension.getHeight() * 0.5);
	        int scrollEnd = (int) (dimension.getHeight() * 0.2);

	        new TouchAction((PerformsTouchActions) BaseFactory.getDriver())
	                .press(PointOption.point(0, scrollStart))
	                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                .moveTo(PointOption.point(0, scrollEnd))
	                .release().perform();
	    }

}
