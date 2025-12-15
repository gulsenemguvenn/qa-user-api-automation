package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class GetUserNotFoundTest extends BaseTest {

    @Test
    void shouldReturn404WhenUserNotFound() {
        Exception ex = assertThrows(Exception.class, () ->
                given()
                        .when()
                        .get("/users/9999")
        );

        assertTrue(ex.getMessage().contains("status code: 404"));
    }
}
