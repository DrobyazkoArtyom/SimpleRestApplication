package ru.drobyazko.simpleRestApp.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private final List<PhoneNumber> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }

    public PhoneBook(List<PhoneNumber> phoneBook) {
        this.phoneList = phoneBook;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneList=" + phoneList +
                '}';
    }

}
