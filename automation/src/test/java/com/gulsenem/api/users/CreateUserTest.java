package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

    @Test
    void shouldCreateUser() {
        String body = """
                {
                  "name": "Test User",
                  "email": "test.user@mail.com",
                  "role": "qa"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(anyOf(is(201), is(200)))
                .body("id", notNullValue())
                .body("name", equalTo("Test User"))
                .body("email", equalTo("test.user@mail.com"))
                .body("role", equalTo("qa"));
    }
}
