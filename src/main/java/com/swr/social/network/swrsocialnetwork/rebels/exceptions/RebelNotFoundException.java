package com.swr.social.network.swrsocialnetwork.rebels.exceptions;

import com.swr.social.network.swrsocialnetwork.rebels.models.Rebel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RebelNotFoundException extends RuntimeException {

    public RebelNotFoundException() {
        super("Rebel not found!");
    }

    public RebelNotFoundException(Long id) {
        super("The rebel with ID " + id + " not found!");
    }
}