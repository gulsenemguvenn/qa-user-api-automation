package com.gulsenem.api.helpers;

import io.restassured.response.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ApiTestAssertions {

    private static final Pattern STATUS_CODE_PATTERN =
            Pattern.compile("status code:\\s*(\\d{3})", Pattern.CASE_INSENSITIVE);

    private ApiTestAssertions() {}

    @FunctionalInterface
    public interface ResponseSupplier {
        Response get();
    }

    public static int statusCodeOf(ResponseSupplier supplier) {
        try {
            Response r = supplier.get();
            return r.getStatusCode();
        } catch (Throwable t) {
            String msg = String.valueOf(t.getMessage());
            Matcher m = STATUS_CODE_PATTERN.matcher(msg);
            if (m.find()) return Integer.parseInt(m.group(1));
            throw new RuntimeException("Could not extract status code from exception: " + msg, t);
        }
    }
}
