package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import com.gulsenem.api.helpers.UserTestHelper;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteUserTest extends BaseTest {

    @Test
    void shouldDeleteCreatedUser() {


        int createdId = UserTestHelper.createUser(
                "Delete Me",
                "delete.me@mail.com",
                "qa"
        );


        given()
                .when()
                .delete("/users/" + createdId)
                .then()
                .statusCode(anyOf(is(200), is(204)));


        Exception ex = assertThrows(Exception.class, () ->
                given().when().get("/users/" + createdId)
        );

        assertTrue(ex.getMessage().contains("status code: 404"));
    }
}
