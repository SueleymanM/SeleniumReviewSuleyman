package com.neotech.review02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.utils.BaseClass;

public class HarryPotterSearch extends BaseClass {
	// Go to https://amazon.com
	// select Books from the search drop-down
	// Type Harry potter
	// And click on Search
	// Check "Kindle Unlimited Eligible" checkbox on the left

	public static void main(String[] args) throws InterruptedException {
		setUp();

		Thread.sleep(20000);

		WebElement selectDDElement = driver.findElement(By.id("searchDropdownBox"));
		Select selectDD = new Select(selectDDElement);

		// Print all the options of the drop-down
//		List<WebElement> optionList = selectDD.getOptions();
//		for (WebElement option : optionList) {
//			System.out.println(option.getText());
//		}

		// 3 different ways to select one drop-down option
		// selectDD.selectByIndex(4);
		// selectDD.selectByValue("search-alias=appliances");
		selectDD.selectByVisibleText("Bücher"); //books bei elions code
		Thread.sleep(1000);

		WebElement searchTxt = driver.findElement(By.id("twotabsearchtextbox"));

		searchTxt.sendKeys("Messi");
		Thread.sleep(1000);
		searchTxt.clear();
		Thread.sleep(1000);
		searchTxt.sendKeys("Harry Potter");

		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		searchBtn.submit();
		Thread.sleep(1000);

		List<WebElement> elementList = driver.findElements(By.xpath("//li[@class='a-spacing-micro']"));
		System.out.println("There are -> " + elementList.size() + " <- elements with that xPath");

		// This exception is nightmare -> StaleElementReferenceException
		// Happens when you click, and don't break the loop
		for (WebElement el : elementList) {
			String elementText = el.getText();

			if (elementText.equals("In Kindle Unlimited enthalten")) { //Kindle Unlimited Eligible bei Elions code
				el.click();
				break;
			}
		}

		Thread.sleep(2000);

		tearDown();
	}

}
