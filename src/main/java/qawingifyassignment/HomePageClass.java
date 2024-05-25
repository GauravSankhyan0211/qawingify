package qawingifyassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class HomePageClass {
	
	WebDriver driver;

	By amountHeader = By.id("amount");
    By amountColumn = By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]");

    public HomePageClass(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAmountHeader() {
        driver.findElement(amountHeader).click();
    }

    public List<Double> getAmountValues() {
        List<WebElement> amountElements = driver.findElements(amountColumn);
        List<Double> amounts = new ArrayList<>();
        for (WebElement element : amountElements) {
            // Assuming amounts are in format "$1,234.56"
            String amountText = element.getText().replace("$", "").replace(",", "");
            amounts.add(Double.parseDouble(amountText));
        }
        return amounts;
    }

    public boolean isAmountSorted() {
        List<Double> amounts = getAmountValues();
        List<Double> sortedAmounts = new ArrayList<>(amounts);
        Collections.sort(sortedAmounts);
        return amounts.equals(sortedAmounts);
    }
	
	
}
