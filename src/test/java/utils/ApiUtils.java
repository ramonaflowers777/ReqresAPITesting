package utils;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class ApiUtils {
    public static final String BASE_URI = "https://reqres.in/";

    public static RequestSpecification createRequest(String basePath, JSONObject requestBody) {
        return given()
                .baseUri(BASE_URI)
                .basePath(basePath)
                .header("Content-Type", "application/json")
                .body(requestBody.toString());
    }
}
