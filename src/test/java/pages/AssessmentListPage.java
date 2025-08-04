package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssessmentListPage {
    WebDriver driver;
    WebDriverWait wait;

    By subject = By.xpath("//p[@class='MuiTypography-root MuiTypography-body-md mui-1dnuing' and text()='Bahasa Indonesia Kelas 10']");
    By assessment = By.xpath("(//*[@class='MuiStack-root mui-cn3cpw'])[1]");
    By assessmentTitle = By.xpath("(//*[@class='MuiTypography-root MuiTypography-title-md mui-1i6iqij'])[1]");

    public AssessmentListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickSubject() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subject));
        driver.findElement(subject).click();
    }

    public void clickAssessment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(assessment));
        driver.findElement(assessment).click();
    }

    public String getTextAssessmentTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(assessment));
        return driver.findElement(assessmentTitle).getText();
    }
}
