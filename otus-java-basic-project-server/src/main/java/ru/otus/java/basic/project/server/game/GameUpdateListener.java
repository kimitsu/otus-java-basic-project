package ru.otus.java.basic.project.server.game;

import ru.otus.java.basic.project.api.exceptions.MessageProcessingException;
import ru.otus.java.basic.project.server.exceptions.ClientNotFoundException;
import ru.otus.java.basic.project.server.game.Game;

@FunctionalInterface
public interface GameUpdateListener {
    void update(Game game) throws ClientNotFoundException, MessageProcessingException;
}
