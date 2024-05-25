package qawingifyassignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class logintestclass {
	
	 WebDriver driver;
	 loginclass loginPage;
	 loginclass amount;
	
	
		@BeforeMethod
		 public void setUp() throws IOException {
		    	Properties p = new Properties();
		    	FileInputStream fis = new FileInputStream("/Users/shwetasankyan/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/qawingify/src/test/resources/other.properties"); 
		    	p.load(fis);
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get(p.getProperty("URL"));	
		        loginPage = new loginclass(driver);    
		        amount = new loginclass(driver);
}
		
		@Test(priority = 1)
	    public void testLoginOne() throws InterruptedException {
	    	
	       loginPage.enterUserName("username");
	       Thread.sleep(2000);
	       loginPage.enterPassword("password");
	       Thread.sleep(2000);
	       loginPage.clickLoginButton();
	       Thread.sleep(2000);
		
		String expectedUrl = "https://sakshingp.github.io/assignment/home.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User should be redirected to the home page");
    
	    }
		
		@Test(priority = 2)
	    public void testLoginTwo() throws InterruptedException {
	    	 
			loginPage.enterUserName("");
		       Thread.sleep(2000);
		       loginPage.enterPassword("");
		       Thread.sleep(2000);
	       loginPage.clickLoginButton();
	       Thread.sleep(2000);
		
	       Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
	        
	    }
		
		@Test(priority = 3)
	    public void testLoginThree() throws InterruptedException {
	    	 
			loginPage.enterUserName("");
		       Thread.sleep(2000);
		       loginPage.enterPassword("password");
		       Thread.sleep(2000);
	       loginPage.clickLoginButton();
	       Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
	      
	    }
		
		@Test(priority = 4)
	    public void testLoginFour() throws InterruptedException {
	    	 
			loginPage.enterUserName("");
		       Thread.sleep(2000);
		       loginPage.enterPassword("password");
		       Thread.sleep(2000);
	       loginPage.clickLoginButton();
	       
		
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       Assert.assertTrue(driver.getCurrentUrl().contains("login.html"));
	    }
		
		
		
		
		@AfterMethod
		public void tearDown() {
			 if (driver != null) {
		            driver.quit();
		        }
	    }
		

		
		}


