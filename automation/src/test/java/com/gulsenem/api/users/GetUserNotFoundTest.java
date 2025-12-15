package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import com.gulsenem.api.helpers.ApiTestAssertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserNotFoundTest extends BaseTest {

    @Test
    void shouldReturn404WhenUserNotFound() {
        int status = ApiTestAssertions.statusCodeOf(() ->
                given().when().get("/users/999999")
        );

        assertTrue(status == 404 || status == 400, "Expected 404 (or 400) but got: " + status);
    }
}
