package com.Page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.Utilities;

public class HandlePopUp {
	WebDriver driver;
	Utilities util;
	private WebDriverWait wait;

	@FindBy(xpath = " //*[@id='popup']/button")
	WebElement okButton;

	public HandlePopUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		util = new Utilities(driver);
	}

	public void acceptAlerts() {
		if(util.isAlertPresent()) {
			util.acceptAlert();
			
		}
	}
	

}
