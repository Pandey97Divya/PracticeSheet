package app.heroku;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver;
	@Test(priority=1)
	public void dropDown() {
		WebElement web= driver.findElement(By.id("dropdown"));
		Select s= new Select(web);
		String s1= s.getFirstSelectedOption().getText();
		Assert.assertEquals(s1, "Please select an option","Not available title");
		
	}
	@Test(priority=2)
	public void dropDown1() {
		WebElement web= driver.findElement(By.id("dropdown"));
		Select s= new Select(web);
		s.selectByValue("1");
	}
	@Test(priority=3)
	public void dropDown2() {
		WebElement web= driver.findElement(By.id("dropdown"));
		Select s= new Select(web);
		s.selectByValue("2");
	}
	@Test(priority=5)
	public void dropDown3() {
		WebElement web= driver.findElement(By.id("dropdown"));
		Select s= new Select(web);
		s.selectByVisibleText("Option 1");
	}
	@Test(priority=4)
	public void dropDown4() {
		WebElement web= driver.findElement(By.id("dropdown"));
		Select s= new Select(web);
		s.selectByVisibleText("Option 2");
	}
	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origin");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
