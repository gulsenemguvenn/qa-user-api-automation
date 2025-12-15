package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import com.gulsenem.api.helpers.ApiTestAssertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserInvalidIdTest extends BaseTest {

    @Test
    void shouldReturn400Or404WhenIdIsInvalid() {
        int status = ApiTestAssertions.statusCodeOf(() ->
                given().when().get("/users/abc")
        );

        assertTrue(status == 400 || status == 404, "Expected 400 or 404 but got: " + status);
    }
}
