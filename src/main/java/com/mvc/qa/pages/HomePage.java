package com.mvc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mvc.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory -OR (Object Repository):
	@FindBy(xpath="//a[text()='React']")
	WebElement react;
	
	//Initializing the page objects:
	public HomePage() {			//Constructor
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public  HomePage login() {
		react.click();
		
		return new HomePage();
		
	}
	
	

}
