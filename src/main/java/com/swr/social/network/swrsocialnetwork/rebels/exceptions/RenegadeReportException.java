package com.swr.social.network.swrsocialnetwork.rebels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class RenegadeReportException extends RuntimeException {

    public RenegadeReportException() {
        super("This rebel is a renegade and cannot report another rebel");
    }

    public RenegadeReportException(Long id) {
        super("The rebel with ID " + id + " is a renegade and cannot report another rebel");
    }
}