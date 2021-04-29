package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.drobyazko.simpleRestApp.exceptions.NotFoundException;
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
    ResponseEntity<Map<Long, User>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userDataService.getUser(id);
        if(user == null) {
            throw new NotFoundException("No user with such id.");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/findBy{name}")
    ResponseEntity<User> findByName(@PathVariable String name) {
        User user = userDataService.findUserByName(name);
        if(user == null) {
            throw new NotFoundException("No user with such name.");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{id}/phonebook")
    ResponseEntity<List<PhoneNumber>> phoneBook(@PathVariable long id) {
        List<PhoneNumber> userPhoneBook = userDataService.getUserPhoneBook(id);
        if(userPhoneBook == null) {
            throw new NotFoundException("No user with such id.");
        }
        return ResponseEntity.ok(userPhoneBook);
    }

    @PostMapping("/users")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return ResponseEntity.ok(userDataService.createUser(newUser));
    }

    @PutMapping("/users/{id}")
    ResponseEntity<User> replaceUser(@PathVariable long id, @RequestBody User newUser) {
        User user = userDataService.editUser(id, newUser);
        if(user == null) {
            throw new NotFoundException("No user with such id.");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    void removeUser(@PathVariable long id) {
        userDataService.removeUser(id);
    }

}
