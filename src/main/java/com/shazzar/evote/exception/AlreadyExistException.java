package com.shazzar.evote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistException extends Exception {

    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String resourceField;
    private Object resourceValue;

    public AlreadyExistException(String resourceName, String resourceField, Object resourceValue) {
        super(String.format("%s already created s% with the name: s%", resourceName, resourceField, resourceValue));
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.resourceValue = resourceValue;
    }


    public AlreadyExistException(String message, String resourceName, String resourceField, Object resourceValue) {
        super(message);
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.resourceValue = resourceValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceField() {
        return resourceField;
    }

    public Object getResourceValue() {
        return resourceValue;
    }
}
