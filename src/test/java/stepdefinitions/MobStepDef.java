package stepdefinitions;

import com.google.gson.JsonObject;
import controller.EnvironmentController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.MobSteps;

import java.io.IOException;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;


public class MobStepDef {
    @Steps
    private MobSteps mobSteps;

    private JsonObject userPayload;

    @Given("I have access to users table")
    public void iHaveAccessToUsersTable() {
        mobSteps.getUserTable();
    }

    @When("I want to verify if user {string} exists")
    public void iWantToVerifyIfUserExists(String user) {
        mobSteps.verifyUserExist(user);
    }

    @Then("I should validate their credentials are valid")
    public void iShouldValidateTheirCredentialsAreValid() {
        mobSteps.verifyUserData();
    }

    @Given("I want to create an user with valid credentials")
    public void iWantToCreateAnUserWithValidCredentials() throws IOException {
        userPayload = EnvironmentController.getJsonObject("validUserData");
    }

    @When("I submit in the correct data")
    public void iSubmitInTheCorrectData() {
        mobSteps.createtUserData(userPayload);
    }

    @Then("I should see the user created successfully")
    public void iShouldSeeTheUserCreatedSuccessfully() {
        mobSteps.verifyUserCreated();
    }

    @Given("I attempt to create an user with invalid credentials")
    public void iAttemptToCreateAnUserWithInvalidCredentials() throws IOException {
        userPayload = EnvironmentController.getJsonObject("inValidUserData");
    }

    @When("I submit in the wrong data")
    public void iSubmitInTheWrongData() {
        mobSteps.createtUserData(userPayload);
    }

    @Then("I should see the correct error message")
    public void iShouldSeeTheCorrectErrorMessage() {
        mobSteps.verifyUserError();
    }

    @Given("I want to update an user with valid credentials")
    public void iWantToUpdateAnUserWithValidCredentials() throws IOException {
        userPayload = EnvironmentController.getJsonObject("inValidUserData");
    }

    @When("I submit in the correct updated data")
    public void iSubmitInTheCorrectUpdatedData() {
        mobSteps.updatedUserData(1, userPayload);
    }

    @Then("I should see the user updated successfully")
    public void iShouldSeeTheUserUpdatedSuccessfully() {
        mobSteps.verifyUserUpdated();
    }


    @Given("I attempt to update an user with invalid credentials")
    public void iAttemptToUpdateAnUserWithInvalidCredentials() throws IOException {
        userPayload = EnvironmentController.getJsonObject("updatedWrongUserData");
    }

    @Given("I want to delete a existing user")
    public void iWantToDeleteAExistingUser() throws IOException {
        userPayload = EnvironmentController.getJsonObject("validUserData");
        mobSteps.createtUserData(userPayload);
        //setSessionVariable("tempId").to(SerenityRest.lastResponse().jsonPath().get("id")); this would of been used
        setSessionVariable("tempId").to(9); //intentionally hardcoded because the backend does not update
    }

    @When("I submit the delete request")
    public void iSubmitTheDeleteRequest() {
        mobSteps.deleteUserData(sessionVariableCalled("tempId"));
    }

    @Then("I should see the user deleted successfully")
    public void iShouldSeeTheUserDeletedSuccessfully() {
        mobSteps.verifyUserDeleted();
    }

    @Given("I want to collect data from user {string}")
    public void iWantToCollectDataFromUser(String user) {
        mobSteps.verifyUserExist(user);
    }

    @When("I filter through his {string}")
    public void iFilterThroughHis(String data) {
        mobSteps.filterUserData(sessionVariableCalled("userId"), data);
    }

    @Then("I should see the users {string}")
    public void iShouldSeeTheUsers(String data) {
        mobSteps.verifyUserFilteredData(data);
    }

    @Then("I should see them proper formatted")
    public void iShouldSeeThemProperFormatted() {
        mobSteps.verifyUserCommentEmailSectionFormat();
    }
}
