package com.latipTest.test_plnicon.library;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;

public class Constants {
    private static final Map<String,String> mapMessage = new HashMap<>();

    public static Map<String,String> validateErrorMessage(Errors errors) {
        mapMessage.clear();
        errors.getAllErrors().forEach((error) -> {
            String errorMessage ;
            if (Objects.equals(error.getCode(), "typeMismatch")) {
                errorMessage = "Type data salah";
            } else {
                errorMessage = error.getDefaultMessage();
            }
            mapMessage.put(((FieldError) error).getField(), errorMessage);
        });
        return mapMessage;
    }
}
