package ru.otus.java.basic.project.api.messages.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.otus.java.basic.project.api.messages.ClientServerMessage;

import java.util.Objects;

public class LoginClientMessage extends ClientServerMessage {
    @JsonProperty("c")
    private String name;

    public LoginClientMessage() {
        super();
    }

    public LoginClientMessage(Long context, String name) {
        super(context);
        if (name == null) throw new IllegalArgumentException("name is null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name is null");
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        LoginClientMessage message = (LoginClientMessage) obj;
        if (!Objects.equals(this.name, message.name)) return false;
        return true;
    }
}
