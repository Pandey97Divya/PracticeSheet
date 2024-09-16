package app.heroku;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;
public class HeroKu {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethodButtonVisible() {
		try {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origin=*");
			driver= new ChromeDriver(co);
			driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void buttonVisible() {
		try {
			ArrayList<WebElement> ele=new ArrayList<WebElement>();
			ele=  (ArrayList<WebElement>) driver.findElements(By.xpath("//button"));
			boolean flag=ele.get(0).isDisplayed();
			if(flag) {	
				System.out.println("Button is Visible");
			}else {
				System.out.println("Button is not Visible");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethodButtonVisible() {
		driver.quit();
	}
	@BeforeMethod
	public void beforeMethodButtonText() {
		try {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origin=*");
			driver= new ChromeDriver(co);
			driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void buttonText() {
		try {
			WebElement button= driver.findElement(By.xpath("//*[text()=\"Add Element\"]"));
			String str= button.getText();
			if(str.equals("Add Element")){
				System.out.println("Testcase pass");
			}else {
				System.out.println("Testcase fail");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethodButtonText() {

		driver.quit();
	}
	@Test(priority=3)
	public void buttonClickable() throws InterruptedException {
		WebElement we= driver.findElement(By.xpath("//*[text()=\"Add Element\"]"));
		we.click();			
		ArrayList<WebElement> ele=new ArrayList<WebElement>();
		ele=  (ArrayList<WebElement>) driver.findElements(By.xpath("//button"));
		if(ele.size()>1) {
			System.out.println("Clikable");
		}else {
			System.out.println("Not clickable");
		}
	}
	@BeforeMethod
	public void beforeMethodButtonClickble() {
		try {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origin=*");
			driver= new ChromeDriver(co);
			driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void afterMethodButtonClickable() {
		driver.quit();
	}
	@Test(priority=4)
	public void multipleClick() {
		WebElement we= driver.findElement(By.xpath("//*[text()=\"Add Element\"]"));
		for(int i=0;i<10;i++) {
			we.click();
		}
		ArrayList<WebElement> ele=new ArrayList<WebElement>();
		ele=  (ArrayList<WebElement>) driver.findElements(By.xpath("//button"));
		if(ele.size()==11) {
			System.out.println("Working fine");
		}else {
			System.out.println("Not Working Fine");
		}
	}
	@BeforeMethod
	public void beforeMethodMultipleClick() {
		try {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origin=*");
			driver= new ChromeDriver(co);
			driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void afterMethodMultipleClick() {
		driver.quit();
	}
}
