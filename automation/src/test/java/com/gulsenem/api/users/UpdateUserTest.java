package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {

    @Test
    void shouldUpdateUser() {

        String createBody = """
                {
                  "name": "Update Me",
                  "email": "update.me@mail.com",
                  "role": "qa"
                }
                """;

        int createdId =
                given()
                        .contentType(ContentType.JSON)
                        .body(createBody)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(anyOf(is(201), is(200)))
                        .extract()
                        .path("id");


        String updateBody = """
                {
                  "name": "Updated User",
                  "email": "updated.user@mail.com",
                  "role": "qa"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(updateBody)
                .when()
                .put("/users/" + createdId)
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .body("id", equalTo(createdId))
                .body("name", equalTo("Updated User"))
                .body("email", equalTo("updated.user@mail.com"));
    }
}
