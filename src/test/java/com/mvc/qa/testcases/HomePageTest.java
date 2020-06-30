package com.mvc.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvc.qa.base.TestBase;
import com.mvc.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	
	public HomePageTest(){
		super(); //super keyword use to call super class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
	}
	@Test(priority=1)
	public void addEdit() throws InterruptedException{
		homePage.login(); //Test Case-2--Click on React
		
		
		for(int i=1;i<5;i++) //Test Case-4--Verification of Addition of ToDo's
		{
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("ToDo"+i);
			
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
		}
		
		//Test Case-6--Verification of Edition of ToDo's
		
		WebElement Edit=driver.findElement(By.xpath("//label[text()='ToDo1']"));
		Actions act=new Actions(driver);
		act.doubleClick(Edit).build().perform();
		driver.findElement(By.cssSelector("body > section > div > section > ul > li:nth-child(1) > input")).sendKeys("_Check_Completed"+Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)	//Test Case-7--Verification of Addition of Special Character & Combination of char
	public void addSpecialChar() throws InterruptedException {
		
		 
			homePage.login();
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("I am Text"+Keys.ENTER+"12345"+Keys.ENTER+"@#$%"+Keys.ENTER+"I am 57#%"+Keys.ENTER);
			Thread.sleep(3000);
		
		
	}
	
	@Test (priority=3)  //Test Case-8--Verification of Addition of ToDo's as a Space Bar
	public void spaceBar() throws InterruptedException {
		
		homePage.login();
		driver.findElement(By.xpath("//input[@class='new-todo']")).sendKeys("  "+Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@Test (priority=4)	//Test Case-9--Verification of duplicate entries in ToDo List
	public void duplicate() throws InterruptedException {
		
		homePage.login();
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("ToDo");
			
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
		}
		
	}
	
	@Test (priority=5)	//Test Case-10--Verify TextField allow infinite(2000)character for adding ToDo's
	public void infiniteChar() throws InterruptedException {
		
		homePage.login();
		
		for(int i=1;i<21;i++)
		{
			driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']")).sendKeys("abcdefghijklmnopqrstuvwxyz"+i);
			
			
		}
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}
	
	@Test (priority=6)  //Test Case-15--verification of deletion
	
	public void deleteToDo() throws InterruptedException {
		homePage.login();
		Actions act=new Actions(driver);
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("body > section > div > header > input")).sendKeys("ToDo"+i);
			act.sendKeys(Keys.ENTER).perform();
		}
		
		WebElement aa=driver.findElement(By.xpath("(//label)[2]"));
		act.moveToElement(aa).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button)[1]")).click();
		
		WebElement aa1=driver.findElement(By.xpath("(//label)[3]"));
		act.moveToElement(aa1).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button)[2]")).click();
		
	}
	
	@Test (priority=7)
	
	public void downwardArrowCompleteTab() {
		homePage.login();
		
Actions act=new Actions(driver);
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("body > section > div > header > input")).sendKeys("ToDo"+i);
			act.sendKeys(Keys.ENTER).perform();
		}
		driver.findElement(By.cssSelector("body > section > div > section > label")).click();
		driver.findElement(By.xpath("//a[@href='#/completed']")).click();
		
	}
	
@Test (priority=8)
	
	public void downwardArrowActiveTab() {
		homePage.login();
Actions act=new Actions(driver);
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("body > section > div > header > input")).sendKeys("ToDo"+i);
			act.sendKeys(Keys.ENTER).perform();
		}
		
		driver.findElement(By.cssSelector("body > section > div > section > label")).click();
		driver.findElement(By.xpath("//a[@href='#/active']")).click();
		driver.findElement(By.cssSelector("body > section > div > section > label")).click();
		driver.findElement(By.xpath("//a[@href='#/active']")).click();
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
