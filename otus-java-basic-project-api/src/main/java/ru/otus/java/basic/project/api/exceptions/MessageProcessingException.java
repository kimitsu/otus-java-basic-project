package ru.otus.java.basic.project.api.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class MessageProcessingException extends Exception {
    public MessageProcessingException(String message) {
        super(message);
    }
    public MessageProcessingException(Throwable cause) {
        super(cause);
    }
    public MessageProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
