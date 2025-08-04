package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By schoolField = By.id(":r2:");
    By schoolDropdown = By.id(":r2:-listbox");
    By usernameField = By.id(":r4:");
    By passwordField = By.id(":r5:");
    By loginButton = By.xpath("//*[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void inputSchool(String school) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(schoolField));
        driver.findElement(schoolField).sendKeys(school);
        Thread.sleep(2000);
        driver.findElement(schoolDropdown).click();
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}
