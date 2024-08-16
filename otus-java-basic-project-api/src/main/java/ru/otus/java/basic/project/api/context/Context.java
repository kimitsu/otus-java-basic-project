package ru.otus.java.basic.project.api.context;

import ru.otus.java.basic.project.api.messages.ClientServerMessage;
import ru.otus.java.basic.project.api.MessageProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public sealed class Context permits ChallengeContext, GameContext, LoginContext {
    private final Map<Class<? extends ClientServerMessage>, MessageProcessor<ClientServerMessage>> listeners = new HashMap<>();

    public static Long getNewId() {
        Random rng = new Random();
        return rng.nextLong();
    }

    private Long id;

    public Context(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public <T extends ClientServerMessage> void setListener(Class<T> messageClass, MessageProcessor<T> listener) {
        listeners.put(messageClass, (MessageProcessor<ClientServerMessage>) listener);
    }

    public <T extends ClientServerMessage> void removeListener(Class<T> messageClass) {
        listeners.remove(messageClass);
    }

    public MessageProcessor<ClientServerMessage> getListener(Class<?> messageClass) {
        return listeners.get(messageClass);
    }
}



