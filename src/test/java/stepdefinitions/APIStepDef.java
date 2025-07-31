package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

// GET USER LIST

public class APIStepDef {
    @Given("I have user list")
    public void iHaveUserList() {
        RestAssured.given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().body("per_page", equalTo(6))
                .assertThat().body("page", equalTo(2))
                .assertThat().body("total", equalTo(12));
    }

    @When("I send GET request to user API")
    public void iSendGETRequestToUserAPI() {
        RestAssured.given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().body("per_page", equalTo(6))
                .assertThat().body("page", equalTo(2))
                .assertThat().body("total", equalTo(12));
    }
    @And("response status should be 200")
    public void responseStatusShouldBe200 () {
        RestAssured.given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
