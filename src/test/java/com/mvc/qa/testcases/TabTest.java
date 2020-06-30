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

public class TabTest extends TestBase {
	
	HomePage homePage;
	
	public TabTest(){
		super(); //super keyword use to call super class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
	}
	
	@Test (priority=11)	//Test Case-11--Verification of Clear Completed Tab
	public void clearTab() throws InterruptedException {
		homePage.login();
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("body > section > div > header > input")).sendKeys("ToDo"+i);
			
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		driver.findElement(By.xpath("//input[@class='toggle']")).click();
		driver.findElement(By.xpath("(//input[@class='toggle'])[3]")).click();
		driver.findElement(By.xpath("//button[@class='clear-completed']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=12)	//Test case-12--Delete ToDo's & Verification of ALL Tab
	public void allTab() throws InterruptedException {
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
		Thread.sleep(3000);
		
	}
	
	@Test (priority=13)		//Test Case-13--Delete ToDo's & Verification of Active Tab
	public void activeTab() throws InterruptedException {
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
		driver.findElement(By.xpath("//a[@href='#/active']")).click();
		Thread.sleep(3000);

		
	}
	
	@Test (priority=14)	//Test Case-14--Verification of Completed Tab
	public void completeTab() throws InterruptedException {
		
		homePage.login();
		
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.cssSelector("body > section > div > header > input")).sendKeys("ToDo"+i);
			
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		driver.findElement(By.xpath("//input[@class='toggle']")).click();
		driver.findElement(By.xpath("(//input[@class='toggle'])[3]")).click();
		driver.findElement(By.xpath("//a[@href='#/completed']")).click();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
