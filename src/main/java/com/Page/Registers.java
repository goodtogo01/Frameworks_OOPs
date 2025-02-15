package com.Page;

import java.io.IOException;

import org.codehaus.groovy.control.messages.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.dom.model.BackendNode;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.Base;
import com.Utils.Utilities;

public class Registers extends Base {
	WebDriver driver;
	Utilities util;

// TODO: Capture locators
	@FindBy(xpath = "//*[@id='reg-username']" )
	WebElement userName;
	
	@FindBy(xpath="//*[@id='reg-email']")
	WebElement userEmail;
	
	@FindBy(xpath = "//*[@id='reg-password']")
	WebElement passwords;
	
	@FindBy(xpath = "//*[@id='reg-confirm-password']")
	WebElement cPasswords;
	
	@FindBy(xpath = "//*[@id='register-form']/button")
	WebElement buttons;
	
	@FindBy(xpath = "//*[@id='message']")
	WebElement messages;
	
	public Registers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new Utilities(driver);
		 
	}
	
	
	
	//TODO : Cosmatics validation
	public void getPageTitles(String expTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("Page Title is : "+actualTitle);
		Assert.assertEquals(actualTitle, expTitle,  "Title didnt match");
	}
	
	//TODO: Set Texts elements
	public void setUserName(String text) {
		userName.sendKeys(text);
	}
	
	public void setEmail(String text) {
		userEmail.sendKeys(text);
	}
	public void setPassword(String text) {
		passwords.sendKeys(text);
	}
	public void setConfirmPassword(String text) {
		cPasswords.sendKeys(text);
	}
	
	//TODO: Click elements
	public void clicButton() {
		buttons.click();
	}
	
	public void captureImage() throws IOException {
		util.takeScreenShoot();
	}
	
	public void getMessage(String expectedText) {
		String message = messages.getText();
		if(message.contentEquals(prop.getProperty("errorMessage"))) {
			
			System.out.println("Error message found as : "+message);
			Assert.assertEquals(message, expectedText, "Message didnt Match!!");
		}else if(message.contentEquals(prop.getProperty("successMessage"))){
			System.out.println("Success message found as : "+message);
			Assert.assertEquals(message, expectedText, "Message didnt Match!!");
		}
		
	}	
}

