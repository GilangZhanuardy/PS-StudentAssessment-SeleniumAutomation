package pages;

import io.restassured.response.Response;
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

    public String createAssessmentName(){
        Random random = new Random();
        String assessmentName;

        int randomNumber = 1000 + random.nextInt(9000); // 1000-9999

        return assessmentName = "Automation Assessment " + randomNumber;
    }

    public Response loginViaAPI(String username, String password, String schoolID) {
        String requestBody = """
                {
                    "login": "%s",
                    "password": "%s",
                    "school_id": "%s"
                }
                """.formatted(username, password, schoolID);

        return ApiClient.post("/api/v2/auth/login/", requestBody);

    }

    public Response teacherCreateAssessment (String title, String openingTimestamp, String closingTimestamp, String token){

        String requestBodyCreateAssessment = """
            {
                "title": "%s",
                "instructions": "Test Assessment Automation",
                "shuffling": false,
                "subject": 112,
                "grade": 162,
                "is_question_type_shuffle": false,
                "opening_timestamp": "%s",
                "submission_type": "Online",
                "is_published": false,
                "anticheat_enabled": false,
                "has_camera_access": false,
                "result_post_type": "automatic_on_deadline",
                "result_post_parts": "grade_with_submission_detail",
                "auto_submission_on_cheat_attempt_max_reached": false,
                "closing_timestamp": "%s",
                "distribution_schedule": "publish_immediately",
                "exam_type": "Try Out",
                "grade_type": "Cognitive",
                "is_auto_submission": false,
                "is_multiple_session": false,
                "sections": [53237],
                "is_replacement": false
            }
            """.formatted(
                title, // String
                openingTimestamp, // String
                closingTimestamp // String
        );

        return ApiClient.authPost(token, "/api/v2/quiz/create/", requestBodyCreateAssessment);
    }

    public void createMCQ(String quiz, String token){

        String requestBodyMCQ = """
            {
                "text": "PG 1",
                "question_type": "MCQ",
                "mcqoption_set": [
                    {
                        "value": "<p>A</p>",
                        "is_correct": true
                    },
                    {
                        "value": "<p>B</p>",
                        "is_correct": false
                    },
                    {
                        "value": "<p>C</p>",
                        "is_correct": false
                    },
                    {
                        "value": "<p>D</p>",
                        "is_correct": false
                    }
                ],
                "marks": 1,
                "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );

        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyMCQ);
    }

    public void createEssay(String quiz, String token){

        String requestBodyEssay = """
            {
                "text": "<p>Essay 1</p>",
                "question_type": "Essay",
                "marks": 1,
                "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyEssay);
    }

    public void createFileUpload(String quiz, String token){

        String requestBodyFileUpload = """
            {
                "text": "<p>File Upload 1 1</p>",
                "question_type": "FileUpload",
                "marks": 1,
                "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyFileUpload);
    }

    public void createMatching(String quiz, String token){

        String requestBodyMatching = """
            {
                  "text": "<p>Matching 1</p>",
                  "question_type": "Matching",
                  "marks": 1,
                  "matchingpair_set": [
                    {
                       "key": "<p>A</p>",
                       "value": "<p>A</p>"
                     },
                     {
                       "key": "<p>B</p>",
                       "value": "<p>B</p>"
                     },
                     {
                       "key": "<p>C</p>",
                       "value": "<p>C</p>"
                     },
                     {
                       "key": "<p>D</p>",
                       "value": "<p>D</p>"
                     }
                  ],
                  "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyMatching);
    }

    public void createTrueFalse(String quiz, String token){

        String requestBodyTrueFalse = """
            {
                  "text": "<p>T/F 1</p>",
                  "question_type": "TrueFalse",
                  "tf_iscorrect": true,
                  "marks": 1,
                  "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyTrueFalse);
    }

    public void createMCC(String quiz, String token){

        String requestBodyMCC = """
            {
                "text": "MCC 1",
                "question_type": "MCQComplex",
                "mcqoption_set": [
                    {
                        "value": "<p>A</p>",
                        "is_correct": true
                    },
                    {
                        "value": "<p>B</p>",
                        "is_correct": false
                    },
                    {
                        "value": "<p>C</p>",
                        "is_correct": true
                    },
                    {
                        "value": "<p>D</p>",
                        "is_correct": false
                    }
                ],
                "marks": 1,
                "quiz": "%s"
            }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyMCC);
    }

    public void createShortAnswer(String quiz, String token){

        String requestBodyShortAnswer = """
                {
                  "text": "<p>Short Asnwer 1 {{}}</p>",
                  "question_type": "FillInBlanks",
                  "marks": 1,
                  "ignore_case": true,
                  "blankvalue_set": [
                    {
                      "blank_label": "question_0",
                      "blank_text": [
                        "Answer"
                      ]
                    }
                  ],
                  "quiz": "%s"
                }
            """.formatted(
                quiz // String
        );
        ApiClient.authPost(token, "/api/v2/quiz/questions/", requestBodyShortAnswer);
    }

    public Response publishAssessment(String token, String assessmentID){
        String requestBodyPublishAssessment = """
                {
                  "is_published": true
                }
            """;

        return ApiClient.authPatch(token, "/api/v2/quiz/" + assessmentID + "/", requestBodyPublishAssessment);

    }
}
