package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PIMPage {
    WebDriver driver;
    WebDriverWait wait;

    By pimHeader = By.xpath("//h6[text()='PIM']");
    By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit']");
    By searchResults = By.xpath("//div[@class='oxd-table-body']");

    public PIMPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void verifyPIMHeader() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeader)).isDisplayed(),
                "PIM header not displayed!");
    }

    public void searchEmployee(String employeeName) {
        driver.findElement(employeeNameField).sendKeys(employeeName);
        driver.findElement(searchButton).click();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults)).isDisplayed(),
                "Search results not displayed!");
    }
}
