package restAPI;

import com.google.gson.JsonObject;
import net.serenitybdd.rest.SerenityRest;

public class MobiquityClient {

    private final String baseURL = "http://jsonplaceholder.typicode.com";


    public void getUserTable() {
        SerenityRest.given().get(baseURL + Endpoints.USERS.getPath());
    }

    public void getUserById(int id) {
        SerenityRest.given().get(baseURL + Endpoints.USERS.getPath() + "/" + id);
    }

    public void createUser(JsonObject userPayload) {
        SerenityRest.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(userPayload)
                .post(baseURL + Endpoints.POSTS.getPath());
    }

    public void updateUser(int id, JsonObject userPayload) {
        SerenityRest.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(userPayload)
                .put(baseURL + Endpoints.POSTS.getPath() + "/" + id);
    }

    public void deleteUser(int id) {
        SerenityRest.given().delete(baseURL + Endpoints.POSTS.getPath() + "/" + id);
    }

    public void getFilteredUsersData(int id, String data) {
        SerenityRest.given()
                .queryParam("userId", id)
                .get(baseURL + Endpoints.POSTS.getPath() + "/" + id + "/" + data);
    }
}
