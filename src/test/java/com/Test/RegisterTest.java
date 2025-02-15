package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.Base;
import com.Page.HandlePopUp;
import com.Page.Registers;
import com.Utils.Utilities;

public class RegisterTest extends Base {
	
	
	Utilities util;
	Registers register;
	Base base;
	HandlePopUp handlePopUp;
	
	@BeforeMethod
	public void tearUp() {
		initialization();
		base = new Base();
		util = new Utilities(driver);
		handlePopUp = new HandlePopUp(driver);
		register = new Registers(driver);
	}
	@Test(priority = 0)
	public void validatePageTitle() {
		register.getPageTitles(base.prop.getProperty("title"));
	}
	@Test(priority = 1)
	public void registerWithValidData() throws IOException, InterruptedException {
		
		register.setUserName("khsoruz");
		register.setEmail("zsolution@email.com");
		register.setPassword("123456");
		register.setConfirmPassword("123456");
	    register.clicButton();
	    register.getMessage(base.prop.getProperty("successMessage"));
	 //   util.takeScreenShoot();
	    handlePopUp.acceptAlerts();
	}
	@Test(priority = 2)
	public void registerWithInValidData() throws IOException {
		
		register.setUserName("khsoruz");
		register.setEmail("zsolution@email.com");
		register.setPassword("123456");
	//	register.setConfirmPassword("123456"); //Missing this part
	    register.clicButton();
	    register.getMessage(base.prop.getProperty("errorMessage"));
	    util.takeScreenShoot();
	   
	}
	
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
            driver.quit(); // Close the browser
        }
	}
	

}
