package ru.otus.java.basic.project.api;

import ru.otus.java.basic.project.api.exceptions.MessageProcessingException;

import java.io.IOException;

public interface MessageProcessor<T> {
    void process(T message) throws MessageProcessingException, IOException;
}
