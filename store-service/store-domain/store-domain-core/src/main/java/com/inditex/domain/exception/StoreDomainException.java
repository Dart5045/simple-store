package com.inditex.domain.exception;

public class StoreDomainException extends DomainException {

    public StoreDomainException(String message) {
        super(message);
    }

    public StoreDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}