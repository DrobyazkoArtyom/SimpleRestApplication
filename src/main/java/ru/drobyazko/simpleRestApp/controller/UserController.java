package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Map<Long, User>> all() {
        return ResponseEntity.ok(userDataService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> one(@PathVariable long id) {
        return ResponseEntity.ok(userDataService.getUser(id));
    }

    @GetMapping("/users/findBy{name}")
    ResponseEntity<User> findByName(@PathVariable String name) {
        return ResponseEntity.ok(userDataService.findUserByName(name));
    }

    @GetMapping("/users/{id}/phonebook")
    ResponseEntity<List<PhoneNumber>> phoneBook(@PathVariable long id) {
        return ResponseEntity.ok(userDataService.getUserPhoneBook(id));
    }

    @PostMapping("/users")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return ResponseEntity.ok(userDataService.createUser(newUser));
    }

    @PutMapping("/users/{id}")
    ResponseEntity<User> replaceUser(@PathVariable long id, @RequestBody User newUser) {
        return ResponseEntity.ok(userDataService.editUser(id, newUser));
    }

    @DeleteMapping("/users/{id}")
    void removeUser(@PathVariable long id) {
        userDataService.removeUser(id);
    }

}
