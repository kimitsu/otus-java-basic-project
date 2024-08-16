package ru.otus.java.basic.project.client;

import ru.otus.java.basic.project.client.exceptions.InvalidServerMessageException;

public class ServerMessage {
    private ServerMessageType messageType;

    public ServerMessage(String message) throws InvalidServerMessageException {
        int delimiter = message.indexOf(' ');
        if (delimiter <= 0) {
            throw new InvalidServerMessageException("Incorrect server message");
        }
        try {
            this.messageType = ServerMessageType.valueOf(message.substring(0, delimiter));
        } catch (IllegalArgumentException e) {
            throw new InvalidServerMessageException("Incorrect server message");
        }
    }
}

enum ServerMessageType {
    OK, ERROR, LIST, BOARD;
}