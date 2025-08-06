package api.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.json.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
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
    public void responseStatusShouldBe200() {
        RestAssured.given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Given("I set base URI to reqres")
    public void iSetBaseURIToReqres() {
        RestAssured.baseURI = "https://reqres.in/api/users";
    }

    // UPDATE USER

    @When("I send PUT request to update user with userID {int} with name {string}")
    public void iSendPUTRequestToUpdateUserWithUserIDWithName(int userID, String newusername) {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        int userId = 2;
        String username = "Elsa";
        String fname = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/" + userId).getBody().jsonPath().get("data.email");
        System.out.println("name before = " + fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newusername);
        bodyMap.put("last_name", lname);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .body(jsonObject.toString())
                .put("api/users/" + userId)
                .then().log().all();
    }

    // PARTIALLY UPDATE USER

    @When("I send PATCH request to partially update user with userID {int} with new name {string}")
    public void iSendPATCHRequestToPartiallyUpdateUserWithUserIDWithNewName(int arg0, String arg1) {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        int userId = 2;
        String newName = "Princess";
        String fname = given().when().get("api/users/" + userId)
                .getBody().jsonPath().get("data.first_name");
        System.out.println("name before = " + fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .body(jsonObject.toString())
                .put("api/users/" + userId)
                .then().log().all();
    }

    // DELETE USER

    @When("I send DELETE request for user with userID {int}")
    public void iSendDELETERequestForUserWithUserID(int userID) {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        int userToDelete = 2;
        given().log().all()
                .header("x-api-key", "reqres-free-v1")
                .when().delete("https://reqres.in/api/users/2" + userToDelete)
                .then()
                .log().all();
    }

    @And("response status should be 204")
    public void responseStatusShouldBe204() {
        RestAssured.given().when()
                .header("x-api-key", "reqres-free-v1")
                .when().delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }
}
