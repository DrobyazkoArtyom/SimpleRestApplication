package ru.drobyazko.simpleRestApp.model;

public class User {

    private final long id;
    private String name;
    private final PhoneBook phoneBook;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
        phoneBook = new PhoneBook();
    }

    public User(long id, String name, PhoneBook phoneBook) {
        this.id = id;
        this.name = name;
        this.phoneBook = phoneBook;
    }

    public long getId() {
        return id;
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
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
                "id=" + id +
                ", name='" + name +
                ", phoneBook=" + phoneBook + '\'' +
                '}';
    }

}
