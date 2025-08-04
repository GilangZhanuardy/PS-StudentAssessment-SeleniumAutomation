package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class PositiveOnlineAssessmentTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://portalsekolah.com/login");
    }

    @Test
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputSchool("SMA Ahmad Yani (Demo)");
        loginPage.inputUsername("studentgilang1");
        loginPage.inputPassword("password123*");
        loginPage.clickLoginButton();
    }

    @Test
    public void redirectToAssessmentPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.clickAssessmentSidebar();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
