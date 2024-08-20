package com.neotech.review02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class CheckBoxDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Go to https://demoqa.com/automation-practice-form
		// Check female
		// Select all the Hobbies
		
		setUp();
		Thread.sleep(1000);
		
		
		//Cannot click on the Input, because the label does not allow from the Website
		//driver.findElement(By.id("gender-radio-2")).click();
		
		// We are able to click on the label
		driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
		Thread.sleep(1000);
		
/////////////////////////////////////////////////////////////////////		
		//findElement vs findElements
		// findElement returns the first WebElement with that xPath
		// findElemets returns all the WebElements with that xPath
		// //div[@id='hobbiesWrapper']/div[2]//label
/////////////////////////////////////////////////////////////////////
		
		// It will return the first WebElement with that xPath
		//WebElement element = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]//label"));
		
		// It will return all the WebElemets with that xPath
		//List<WebElement> elements = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]//label"));
	
/////////////////////////////////////////////////////////////////////	
		
		// 1. If xPath is wrong
		// findElement -> will throw an Exception
		//findElemets -> will return an Empty List of WebElements (size = 0)
		
		// 2. If there are multiple WebElements with that xPath
		// findElemet -> will return the first WebElement
		// findElemetns -> will return all the WebElemetns inside a List (size = in this case 3)
		
		// 3. If there is only one WebElement with that xPath
		// findElement -> will return the WebElement
		// findElements -> will return the WebElement inside a List (size = 1)
		
		// Locate all the checkboxes
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]//label"));
		
		// Click all the checkboxes one-by-one
		for (WebElement checkBox: checkBoxList) {
			checkBox.click();
		}
		Thread.sleep(1000);
		
		
		tearDown();
	}

}
