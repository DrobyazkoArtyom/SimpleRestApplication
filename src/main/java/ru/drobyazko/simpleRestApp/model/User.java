package ru.drobyazko.simpleRestApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String name;

    private User() { }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}
