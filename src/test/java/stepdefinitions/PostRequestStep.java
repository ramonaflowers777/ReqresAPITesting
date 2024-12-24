package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;

import  static  io.restassured.RestAssured.*;

public class PostRequestStep {
    public Response response;
    public  JSONObject body;

    @Given("The valid endpoint with payload to create user")
    public void setUpEndpoint() {
        baseURI = "https://reqres.in/";
        basePath = "api/users";

        body = new JSONObject();
        body.put("name", "effy");
        body.put("job", "QA Automation Engineer");

    }

    @When("The request is send to the server")
    public void sendingRequest() {
        response = given()
                .header("Content-Type", "application/json")
                .body(body.toJSONString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract().response();
    }

    @Then("The new user must be created with name as {string}")
    public void validateCreatedUser(String name) {
        JsonPath jsonPath = response.jsonPath();

        String userName = jsonPath.getString("name");
        System.out.println(userName);
        Assert.assertEquals(userName, name);
    }
}
