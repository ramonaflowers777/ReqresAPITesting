package stepdefinitions;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetRequestStep {
    public Response response;

    @Given("The valid endpoint to fetch users")
    public void setUpEndpoint() {
       baseURI = "https://reqres.in";
       basePath = "/api/users";
    }

    @When("The request is send to server with page numbers as {string}")
    public void sendRequest(String pageNum) {
        response = given()
                .queryParam("page", pageNum)
                .when()
                .get()
                .then()
                .extract().response();
    }

    @Then("The first user record has email as {string}")
    public void validateUserData(String email) {
        JsonPath jsonPath = response.jsonPath();

        String userEmail = jsonPath.getString("data[0].email");

        Assert.assertEquals(userEmail , email, "First user record's email isn't correct");
    }
}
