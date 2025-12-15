package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import com.gulsenem.api.helpers.ApiTestAssertions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteUserTest extends BaseTest {

    @Test
    void shouldDeleteCreatedUser() {

        String body = """
                {
                  "name": "Delete Me",
                  "email": "delete.me@mail.com",
                  "role": "qa"
                }
                """;

        int createdId =
                given()
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post("/users")
                        .then()
                        .extract()
                        .path("id");

        Response deleteResponse =
                given()
                        .when()
                        .delete("/users/" + createdId)
                        .andReturn();

        int deleteStatus = deleteResponse.getStatusCode();
        assertTrue(deleteStatus == 200 || deleteStatus == 204, "Expected 200/204 but got: " + deleteStatus);

        int getAfterDeleteStatus = ApiTestAssertions.statusCodeOf(() ->
                given().when().get("/users/" + createdId)
        );

        assertTrue(getAfterDeleteStatus == 404 || getAfterDeleteStatus == 400,
                "Expected 404/400 after delete but got: " + getAfterDeleteStatus);
    }
}
