package com.gulsenem.api.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = resolveBaseUrl();
    }

    private static String resolveBaseUrl() {
        String fromMaven = System.getProperty("api.baseUrl");
        if (fromMaven != null && !fromMaven.isBlank()) return fromMaven;

        String fromEnv = System.getenv("API_BASE_URL");
        if (fromEnv != null && !fromEnv.isBlank()) return fromEnv;

        return "http://localhost:3000";
    }
}
