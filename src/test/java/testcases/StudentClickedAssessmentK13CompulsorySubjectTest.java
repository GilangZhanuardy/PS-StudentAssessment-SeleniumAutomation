package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//TC-823 user view online assessment for K13 compulsory subject on current tab
public class StudentClickedAssessmentK13CompulsorySubjectTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://portalsekolah.com/login");
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputSchool("SMA Ahmad Yani (Demo)");
        loginPage.inputUsername("k13gilang1");
        loginPage.inputPassword("password123*");
        loginPage.clickLoginButton();
    }

//    @Test
//    public void createAssessment() throws InterruptedException {
//        CreateAssessmentPage createAssessmentPage = new CreateAssessmentPage(driver);
//
//        Response login = createAssessmentPage.loginViaAPI("teachergilang1", "password123*", "1791");
//        String token = login.jsonPath().getString("data.jwt.access");
//        int loginResponseCode = login.getStatusCode();
//        System.out.println("Login response code: " + loginResponseCode);
//
//        OffsetDateTime now = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
//        String openingTimestamp = now.format(formatter);
//        OffsetDateTime next = now.plusDays(1);
//        String closingTimestamp = next.format(formatter);
//
//        String assessmentName = createAssessmentPage.createAssessmentName();
//
//        Response createAssessment = createAssessmentPage.teacherCreateAssessment(assessmentName, openingTimestamp, closingTimestamp, token);
//        String assessmentID = createAssessment.jsonPath().getString("data.id");
//        int createAssessmentResponseCode = createAssessment.getStatusCode();
//        System.out.println("Create Assessment response code: " + createAssessmentResponseCode);
//
//        createAssessmentPage.createMCQ(assessmentID, token);
//        createAssessmentPage.createEssay(assessmentID, token);
//        createAssessmentPage.createFileUpload(assessmentID, token);
//        createAssessmentPage.createMatching(assessmentID, token);
//        createAssessmentPage.createTrueFalse(assessmentID, token);
//        createAssessmentPage.createMCC(assessmentID, token);
//        createAssessmentPage.createShortAnswer(assessmentID, token);
//        Response publishAssessment = createAssessmentPage.publishAssessment(token, assessmentID);
//        int publishAssessmentResponseCode = publishAssessment.getStatusCode();
//        System.out.println("Publish Assessment response code: " + publishAssessmentResponseCode);
//    }

    @Test(priority = 2)
    public void redirectToAssessmentPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.clickAssessmentSidebar();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void mainTest() throws InterruptedException {
        AssessmentListPage assessmentListPage = new AssessmentListPage(driver);
        InstructionPage instructionPage = new InstructionPage(driver);

        assessmentListPage.clickSubject();
        String titleAssessmentListPage = assessmentListPage.getTextAssessmentTitle();
        assessmentListPage.clickAssessment();
        String titleAssessmentInstructionPage = instructionPage.getTextAssessmentTitleInstructionPage();
        Assert.assertEquals(titleAssessmentListPage, titleAssessmentInstructionPage);

        Thread.sleep(10000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
