package qawingifyassignment;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.List;

public class HomePageTest {
	  WebDriver driver;
	     loginclass loginPage;
	     HomePageClass homePage;

	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://sakshingp.github.io/assignment/login.html");
	        loginPage = new loginclass(driver);
	        homePage = new HomePageClass(driver);
	        
	    }

	    @Test
	    public void testAmountSorting() throws InterruptedException {
	    	
	    	loginPage.enterUserName("gaurav");
		       Thread.sleep(2000);
		       loginPage.enterPassword("gaurav");
		       Thread.sleep(2000);
	       loginPage.clickLoginButton();
	       Thread.sleep(2000);
	    	
	        homePage.clickAmountHeader();
	        List<Double> amounts = homePage.getAmountValues();
	        assertTrue(isSorted(amounts));
	    }

	    private boolean isSorted(List<Double> list) {
	        for (int i = 0; i < list.size() - 1; i++) {
	            if (list.get(i) > list.get(i + 1)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
