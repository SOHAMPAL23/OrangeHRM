package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By profileDropdown = By.cssSelector("span.oxd-userdropdown-tab");
    By logoutLink = By.xpath("//a[text()='Logout']");
    By usernameField = By.name("username");

    public LogoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();

        // Validate back to login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }
}
