package com.gulsenem.api.helpers;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class UserTestHelper {

    public static int createUser(String name, String email, String role) {
        String body = String.format("""
                {
                  "name": "%s",
                  "email": "%s",
                  "role": "%s"
                }
                """, name, email, role);

        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .extract()
                .path("id");
    }
}
