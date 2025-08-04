package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InstructionPage {
    WebDriver driver;
    WebDriverWait wait;

    By assessmentTitleInstructionPage = By.xpath("//*[@class='MuiTypography-root MuiTypography-h1 mui-cy62wi']");

    public InstructionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getTextAssessmentTitleInstructionPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(assessmentTitleInstructionPage));
        return driver.findElement(assessmentTitleInstructionPage).getText();
    }
}
