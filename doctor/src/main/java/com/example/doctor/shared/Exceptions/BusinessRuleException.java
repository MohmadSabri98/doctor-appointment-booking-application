package com.example.doctor.shared.Exceptions;

public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String description) {
        super(description);
    }
}
