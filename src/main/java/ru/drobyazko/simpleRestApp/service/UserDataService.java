package ru.drobyazko.simpleRestApp.service;

import org.springframework.stereotype.Component;
import ru.drobyazko.simpleRestApp.dataSource.PhoneNumberDataSource;
import ru.drobyazko.simpleRestApp.dataSource.UserDataSource;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDataService {

    private final UserDataSource userDataSource = new UserDataSource(new HashMap<>());
    private final PhoneNumberDataSource phoneNumberDataSource = new PhoneNumberDataSource(new HashMap<>());

    public Map<Long, User> getAllUsers() {
        return userDataSource.getAll();
    }

    public User getUser(long id) {
        return userDataSource.getUser(id);
    }

    public User createUser(User newUser) {
        return userDataSource.addUser(newUser);
    }

    public User editUser(long id, User user) {
        return userDataSource.editUser(id, user);
    }

    public void removeUser(long id) {
        userDataSource.removeUser(id);
    }

    public PhoneNumber getPhoneNumber(long id) {
        return phoneNumberDataSource.getPhoneNumber(id);
    }

    public Map<Long, PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberDataSource.getAll();
    }

    public PhoneNumber createPhoneNumber(PhoneNumber newPhoneNumber) {
        return phoneNumberDataSource.addPhoneNumber(newPhoneNumber);
    }

    public PhoneNumber editPhoneNumber(long id, PhoneNumber phoneNumber) {
        return phoneNumberDataSource.editPhoneNumber(id, phoneNumber);
    }

    public void removePhoneNumber(long id) {
        phoneNumberDataSource.removePhoneNumber(id);
    }

    public User findUserByName(String name) {
        for (Map.Entry<Long, User> entry : userDataSource.getAll().entrySet()) {
            User user = entry.getValue();
            if(user.getName().contains(name)) {
                return user;
            }
        }
        return null;
    }

    public PhoneNumber findPhoneEntryByNumber(String number) {
        for (Map.Entry<Long, PhoneNumber> entry : phoneNumberDataSource.getAll().entrySet()) {
            PhoneNumber phoneNumber = entry.getValue();
            if(phoneNumber.getNumber().equals(number)) {
                return phoneNumber;
            }
        }
        return null;
    }

    public List<PhoneNumber> getUserPhoneBook(long id) {
        if(!userDataSource.getAll().containsKey(id)) {
            return null;
        }
        List<PhoneNumber> userPhoneBook = new ArrayList<>();
        for (Map.Entry<Long, PhoneNumber> entry : phoneNumberDataSource.getAll().entrySet()) {
            PhoneNumber phoneNumber = entry.getValue();
            if(phoneNumber.getUserId() == id) {
                userPhoneBook.add(phoneNumber);
            }
        }
        return userPhoneBook;
    }

}
