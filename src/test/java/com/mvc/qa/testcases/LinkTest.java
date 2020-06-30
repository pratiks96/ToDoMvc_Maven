package com.mvc.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvc.qa.base.TestBase;
import com.mvc.qa.pages.HomePage;

public class LinkTest extends TestBase {
	
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
	}
	
	@Test //Test Case-3--Verification of Petehunt & ToDoMvc Link
	public void Addition() throws InterruptedException{
		homePage.login();
		driver.findElement(By.xpath("//a[text()='petehunt']")).click();
		String pet=driver.getTitle();
		System.out.println("Pethunt page title="+pet);
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='TodoMVC']")).click();
		String toDo=driver.getTitle();
		System.out.println("ToDoMvc page title="+toDo);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
