package it.cgmconsulting.myblog.exception;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException{

    private final String messageError;

    public ConflictException(String messageError) {
        super(String.format(messageError));
        this.messageError = messageError;
    }
}
