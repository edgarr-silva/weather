package com.edgar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.http.HTTPException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClimateNotFoundException extends HTTPException {

    public ClimateNotFoundException() {
        super(404);
    }

    @Override
    public String getMessage() {
        return "Climate Not Found";
    }
}
