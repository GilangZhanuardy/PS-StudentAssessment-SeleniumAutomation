package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private static final String BASE_URL = "https://backend-v2.portalsekolah.com";

    private static RequestSpecification given() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .log().all();
    }

    public static Response get(String endpoint) {
        return given().get(endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return given().body(body).post(endpoint);
    }

    public static Response authPost (String token, String endpoint, Object body){
        return given().header("Authorization", "Bearer " + token).body(body).post(endpoint);
    }

    public static Response authPatch (String token, String endpoint, Object body){
        return given().header("Authorization", "Bearer " + token).body(body).patch(endpoint);
    }



}
