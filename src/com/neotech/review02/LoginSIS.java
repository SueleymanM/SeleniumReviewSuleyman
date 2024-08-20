package com.neotech.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class LoginSIS extends BaseClass{

	public static void main(String[] args) throws InterruptedException  {

		//Login to SIS Application
		//https://sis.neotechacademy.com/
		//username -> Admin
		//password -> Neotech$123
		
		
		setUp();
		
		// We are performing our test
		Thread.sleep(1000);
		
		WebElement username = driver.findElement(By.id("tUsername"));
		username.sendKeys(ConfigsReader.getProperty("username"));
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.name("tPassword"));
		password.sendKeys(ConfigsReader.getProperty("password"));
		Thread.sleep(1000);
		
		// The input whose type attribute has a value of submit
		// //input[@type='submit']
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); // Method chaining
		Thread.sleep(3000);
		
		
		tearDown();
		
	}

}
