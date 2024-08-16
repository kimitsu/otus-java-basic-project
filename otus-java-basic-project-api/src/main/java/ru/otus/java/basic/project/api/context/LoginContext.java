package ru.otus.java.basic.project.api.context;

public final class LoginContext extends Context {
    private String name;

    public LoginContext(Long id) {
        super(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
