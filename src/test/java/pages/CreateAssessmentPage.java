package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CreateAssessmentPage {
    WebDriver driver;
    WebDriverWait wait;

    public CreateAssessmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void createAssessmentName(){
        Random random = new Random();
        String assessmentName;

        int randomNumber = 1000 + random.nextInt(9000); // 1000-9999
    }
}
