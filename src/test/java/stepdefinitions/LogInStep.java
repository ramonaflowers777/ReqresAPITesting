package stepdefinitions;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class LogInStep {
    private JSONObject requestBody;
    private Response response;
    private RequestSpecification httpRequest;

    @Given("I have valid login credentials with {string} and {string}")
    public void setUp(String email, String password) {
        requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);

        baseURI = "https://reqres.in/";
        basePath = "api/login";

        httpRequest = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString());
    }

    @When("I send a POST request to the login endpoint")
    public void iSendAPOSTRequestToTheLoginEndpoint() {
        response = httpRequest.post();
    }

    @Then("I should receive a {int} status code")
    public void iShouldReceiveAStatusCode(int code) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, code, "Returned status code is incorrect");
    }

    @And("Server must return correct {string}")
    public void serverMustReturnCorrect(String token) {
        JsonPath jsonPath = response.jsonPath();

        String returnedToken = jsonPath.getString("token");
        System.out.println(returnedToken);

        Assert.assertEquals(returnedToken, token, "Returned token is incorrect");
    }
}
