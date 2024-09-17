package app.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicAuthTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origin");
		driver= new ChromeDriver(co);
	}
	@DataProvider(name="credentials")
	public Object[][] getCredentials(){
		return new Object[][] {
			//Positive
			{"admin","admin",true},
			//Negative
			{"","",false},
			{"admin","",false},
			{"","admin",false},
			{"wronguser","wrongpass",false},
			{"admin","wrongpass",false},
			{"wronguser","admin",false},
		};
	}
	@Test(dataProvider="credentials",priority=1)
	public void basicAuthTest(String username, String password, boolean result) throws InterruptedException {
		try {
			String URL= "https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
			driver.get(URL);
			if(result) {
				WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
				Assert.assertTrue(successMessage.isDisplayed(),"with right credential no success message showing");
			}else {
				WebElement errorMessage= driver.findElement(By.tagName("body"));
				Assert.assertTrue(errorMessage.getText().contains("Not authorized"),"Invalid Credentials");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
