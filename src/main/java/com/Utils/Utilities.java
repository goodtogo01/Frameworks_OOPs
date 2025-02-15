package com.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.Base;
public class Utilities extends Base{
 
	private WebDriverWait wait;
	static WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	 // Common actions
	public static void takeScreenShoot() throws IOException  {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"/Screen_Shoot/"+System.currentTimeMillis()+".png"));
	}
	// handle pop-up
	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
	}

	// Method to check if an alert is present
	public boolean isAlertPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Method to close web-based modal pop-ups
	public void closeModalPopup(WebElement closeButton) {
		wait.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
    


}
