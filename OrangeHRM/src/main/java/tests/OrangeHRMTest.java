package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.*;

public class OrangeHRMTest extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        setUp();
    }

    @Test
    public void testOrangeHRMLoginSearchLogout() {
        // Create page objects
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboardPage = new DashboardPage(driver, wait);
        PIMPage pimPage = new PIMPage(driver, wait);
        LogoutPage logoutPage = new LogoutPage(driver, wait);

        // Login
        loginPage.login("Admin", "admin123");

        // Dashboard
        dashboardPage.verifyDashboard();
        dashboardPage.goToPIM();

        // PIM
        pimPage.verifyPIMHeader();
        pimPage.searchEmployee("Linda");

        // Logout
        logoutPage.logout();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
