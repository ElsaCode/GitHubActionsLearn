package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.home.LoginPage;
import utilities.ErrorHandler;
import utilities.DriverManager;

public class LoginStepDef {

    @Given("user on the login page")
    public void userontheloginpage() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginLink();

    }

    @When("user fill in the username field with {string}")
    public void fillusernamefield(String username) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterusername(username);

    }

    @When("user fill in the password field with {string}")
    public void fillpasswordfield(String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterpassword(password);

    }

    @And("user click on the Login button")
    public void clickLoginLink() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginLink();
    }

    @Then("browser closes")
    public void tearDown(){
        DriverManager.quitDriver();
    }

    @When("user enter wrong password with {string}")
    public void userEnterWrongPasswordWith(String arg0) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterpassword(arg0);
    }

    @And("user view error message with {string}")
    public void userViewErrorMessageWith(String arg0) {
        ErrorHandler allertHandler = new ErrorHandler();
        String actualAllertMessage = allertHandler.waitErrorMessage(arg0);
        System.out.println("actualAlertMessage: " + actualAllertMessage);
    }
}

