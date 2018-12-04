package com.edgar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.xml.ws.http.HTTPException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateRangeException extends HTTPException {

    public DateRangeException() {
        super(400);
    }

    @Override
    public String getMessage() {
        return "Start date cannot be bigger then end date!";
    }
}
