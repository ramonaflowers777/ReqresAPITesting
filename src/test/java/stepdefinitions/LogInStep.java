package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import utils.ApiUtils;

import static io.restassured.RestAssured.*;

public class LogInStep {
    private static final String errMsg = "Missing password";
    private static final String basePath = "api/login";

    private Response response;
    private JSONObject requestBody;

    @Given("I have valid login credentials with {string} and {string}")
    public void setUp(String email, String password) {
        requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);
    }

    @When("I send a POST request to the login endpoint")
    public void iSendAPOSTRequestToTheLoginEndpoint() {
        response = ApiUtils.createRequest(basePath, requestBody).post();
    }

    @Then("I should receive a {int} status code")
    public void iShouldReceiveAStatusCode(int code) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, code, "Returned status code is incorrect");
    }

    @Then("Server must return correct {string}")
    public void serverMustReturnCorrect(String token) {
        JsonPath jsonPath = response.jsonPath();

        String returnedToken = jsonPath.getString("token");
        System.out.println(returnedToken);

        Assert.assertEquals(returnedToken, token, "Returned token is incorrect");
    }

    @Given("I have invalid login credential with {string}")
    public void setUpForInvalidLogin(String email) {
        requestBody = new JSONObject();
        requestBody.put("email", email);
    }

    @Then("Server must return {string}")
    public void validatingErrorMessage(String errMsg) {
        JsonPath returnedObject = response.jsonPath();

        String errorMessage = returnedObject.getString("error");
        System.out.println(errorMessage);

        Assert.assertEquals(errorMessage, errMsg, "Returned error message is incorrect");
    }
}
