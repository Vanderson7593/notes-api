package com.telema.notes.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    private static Object buildResponseBody(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        return map;
    }

    public static ResponseEntity<Object> generateResponse(Object responseObj) {
        return new ResponseEntity<Object>(buildResponseBody(null, HttpStatus.OK, responseObj), HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateResponse(Object responseObj, String message) {
        return new ResponseEntity<Object>(buildResponseBody(message, HttpStatus.OK, responseObj), HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateResponse(Object responseObj, HttpStatus status) {
        return new ResponseEntity<Object>(buildResponseBody(null, status, responseObj), HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateResponse(Object responseObj, String message, HttpStatus status) {
        return new ResponseEntity<Object>(buildResponseBody(message, status, responseObj), status);
    }


}
