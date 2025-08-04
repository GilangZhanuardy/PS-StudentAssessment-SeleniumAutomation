package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    By assessmentSidebar = By.xpath("//*[@class='menu-item icon-ujian']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickAssessmentSidebar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assessmentSidebar));
        driver.findElement(assessmentSidebar).click();
    }
}
