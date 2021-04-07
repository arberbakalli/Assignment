package steps;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import restAPI.MobiquityClient;
import model.Comments;
import model.User;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.*;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;

public class MobSteps {

    private List<User> userList;
    private List<Comments> commentsList;

    @Steps
    MobiquityClient mobiquityClient;

    public void getUserTable() {
        mobiquityClient.getUserTable();
        deserializeUserTable();
    }

    private void deserializeUserTable() {
        User[] userzList = new GsonBuilder().create().fromJson(SerenityRest.lastResponse().body().prettyPrint(), User[].class);
        userList = Arrays.asList(userzList);
    }

    public void verifyUserExist(String userName) {
        Optional<User> userTemp = getUserByName(userName);
        assertThat(userTemp).isNotNull().isNotEmpty();
        setSessionVariable("userId").to(userTemp.get().getId());
        mobiquityClient.getUserById(userTemp.get().getId());
    }

    private Optional<User> getUserByName(String userName) {
        return userList.stream().filter(user -> user.getUsername().equals(userName)).findFirst();
    }

    public void verifyUserData() {
        assertThat(userList.get(sessionVariableCalled("userId"))).isNotNull();
        //assertions could be anything really loop through the object and verify every single attribute with any combination
    }

    public void createtUserData(JsonObject userPayload) {
        mobiquityClient.createUser(userPayload);
    }

    public void verifyUserCreated() {
        then().assertThat().statusCode(SC_CREATED);
        assertThat(SerenityRest.lastResponse()).isNotNull();
    }

    public void verifyUserError() {
        then().assertThat().statusCode(SC_BAD_REQUEST);
        assertThat(SerenityRest.lastResponse()).isNull();
    }

    public void updatedUserData(int id, JsonObject userPayload) {
        mobiquityClient.updateUser(id, userPayload);
    }

    public void deleteUserData(int id) {
        mobiquityClient.deleteUser(id);
    }

    public void verifyUserDeleted() {
        then().assertThat().statusCode(SC_OK);
        // mobiquityClient.getUserById(sessionVariableCalled("newUserID")); Suppose that the new user created generated an ID of 9999
        mobiquityClient.getUserById(99999); //  verify that user doesn't exist after being deleted
        then().assertThat().statusCode(SC_NOT_FOUND);
    }

    public void filterUserData(int id, String data) {
        mobiquityClient.getFilteredUsersData(id, data);
    }

    public void verifyUserFilteredData(String data) {
        then().assertThat().statusCode(SC_OK);
        assertThat(data).isNotNull().isNotEmpty();
    }

    public void verifyUserUpdated() {
        then().assertThat().statusCode(SC_OK);
    }

    public void verifyUserCommentEmailSectionFormat() {
        deserializeCommentsTable();
        assertThat(commentsList.stream().filter(data -> data.getEmail().contains("@")).collect(Collectors.toList())).hasSize(commentsList.size());
    }

    private void deserializeCommentsTable() {
        Comments[] commentsTable = new GsonBuilder().create().fromJson(SerenityRest.lastResponse().body().prettyPrint(), Comments[].class);
        commentsList = Arrays.asList(commentsTable);
    }
}
