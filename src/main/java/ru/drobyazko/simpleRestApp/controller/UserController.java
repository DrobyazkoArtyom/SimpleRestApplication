package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;
import ru.drobyazko.simpleRestApp.service.UserDataService;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserDataService userDataService;

    @Autowired
    public UserController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/users")
    Map<Long, User> all() {
        return userDataService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable long id) {
        return userDataService.getUser(id);
    }

    @GetMapping("/users/{name}")
    User findByName(@PathVariable String name) {
        return userDataService.findUserByName(name);
    }

    @GetMapping("/users/{id}/phonebook")
    List<PhoneNumber> phoneBook(@PathVariable long id) {
        return userDataService.getUserPhoneBook(id);
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return userDataService.createUser(newUser);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@PathVariable long id, @RequestBody User newUser) {
        return userDataService.editUser(id, newUser);
    }

    @DeleteMapping("/users/{id}")
    void removeUser(@PathVariable long id) {
        userDataService.removeUser(id);
    }

}
