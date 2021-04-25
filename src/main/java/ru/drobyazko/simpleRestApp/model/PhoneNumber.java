package ru.drobyazko.simpleRestApp.model;

public class PhoneNumber {

    private long userId;
    private String name;
    private String number;

    public PhoneNumber(long userId, String name, String number) {
        this.userId = userId;
        this.name = name;
        this.number = number;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}
