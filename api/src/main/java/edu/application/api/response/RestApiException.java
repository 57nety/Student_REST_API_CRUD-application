package edu.application.api.response;

public class RestApiException extends RuntimeException {
    public RestApiException(String message) {
        super(message);
    }
}
