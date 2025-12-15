package com.gulsenem.api.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = requestSpec;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
