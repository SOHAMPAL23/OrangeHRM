package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By pimModule = By.xpath("//span[text()='PIM']");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void verifyDashboard() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed(),
                "Dashboard header not displayed!");
    }

    public void goToPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pimModule)).click();
    }
}
