package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUsersTest extends BaseTest {

    @Test
    void shouldReturnUsersList() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", is(not(empty())))
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].email", containsString("@"));
    }
}
