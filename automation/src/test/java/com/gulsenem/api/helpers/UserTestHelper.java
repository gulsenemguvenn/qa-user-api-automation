package com.gulsenem.api.helpers;

import io.restassured.http.ContentType;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class UserTestHelper {

    public static String randomEmail() {
        return "user_" + UUID.randomUUID() + "@mail.com";
    }

    public static int createUser(String name, String role) {
        String body = """
                {
                  "name": "%s",
                  "email": "%s",
                  "role": "%s"
                }
                """.formatted(name, randomEmail(), role);

        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(anyOf(is(201), is(200)))
                .extract()
                .path("id");
    }

    public static void deleteUser(int id) {
        given()
                .when()
                .delete("/users/" + id)
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }
}
