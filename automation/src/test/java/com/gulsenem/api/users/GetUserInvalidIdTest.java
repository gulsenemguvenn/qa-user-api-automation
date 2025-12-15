package com.gulsenem.api.users;

import com.gulsenem.api.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserInvalidIdTest extends BaseTest {

    @Test
    void shouldReturn4xxWhenIdIsInvalid() {
        Exception ex = org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () ->
                given().when().get("/users/abc")
        );

        String msg = ex.getMessage();
        assertTrue(msg.contains("status code: 400") || msg.contains("status code: 404"));
    }
}
