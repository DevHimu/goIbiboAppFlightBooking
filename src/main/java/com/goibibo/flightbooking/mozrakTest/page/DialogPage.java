package com.goibibo.flightbooking.mozrakTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.goibibo.flightbooking.mozrakTest.base.BaseFactory;

public class DialogPage {
	public DialogPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(BaseFactory.getDriver(), this);
	}
	private static String id_buttonSkip="com.goibibo:id/buttonSkip";
	
	public static void pressSkipButton()
	{
		new WebDriverWait(BaseFactory.getDriver(),20)
		.until(ExpectedConditions.elementToBeClickable(BaseFactory.getDriver().findElement(By.id(id_buttonSkip))));
		BaseFactory.getDriver().findElement(By.id(id_buttonSkip)).click();
	}

}
