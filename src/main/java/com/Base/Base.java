package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.Assert;

public class Base {
	public WebDriver driver;
	public static Properties prop;
	public static String configPath = "/Users/khosruzzaman/JAVA-WORKS/FrameWorksWithOOPS/resources/config.properties";
	String chromepath = "/Users/khosruzzaman/JAVA-WORKS/FrameWorksWithOOPS/Drivers/chromedriver";
	String ffpath = "/Users/khosruzzaman/JAVA-WORKS/FrameWorksWithOOPS/Drivers/geckodriver";

	// TODO: Constractor
	public Base() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO: Initializing webdriver for multiple browser
	public void initialization() {
		try {
			String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.gecko.driver", ffpath);
				driver = new FirefoxDriver();
			} else {
				driver = new SafariDriver();
			}

			driver.get(prop.getProperty("url"));

			// TODO: handle exception if Browser loading is failed
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Webdriver Initialization failed");
		}
	}

}
