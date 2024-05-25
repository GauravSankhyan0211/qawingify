package qawingifyassignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginclass {
	
	 WebDriver driver;
    @FindBy(id = "username")
     WebElement userName;
    
    @FindBy(id = "password")    
     WebElement passwordField;
    
    @FindBy(id = "log-in")
     WebElement loginButton;
    
    @FindBy(id = "amount")
    WebElement clickAmount;
    
    public loginclass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterUserName(String userField) {
        userName.sendKeys(userField);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    } 
    public void clickAmountButton(){
    	clickAmount.click();
    	
    }
}
