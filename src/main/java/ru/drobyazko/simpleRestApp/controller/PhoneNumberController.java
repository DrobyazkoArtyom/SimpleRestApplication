package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.service.UserDataService;

import java.util.Map;

@RestController
public class PhoneNumberController {

    private final UserDataService userDataService;

    @Autowired
    public PhoneNumberController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/phones")
    ResponseEntity<Map<Long, PhoneNumber>> all() {
        return ResponseEntity.ok(userDataService.getAllPhoneNumbers());
    }

    @GetMapping("/phones/{id}")
    ResponseEntity<PhoneNumber> one(@PathVariable long id) {
        return ResponseEntity.ok(userDataService.getPhoneNumber(id));
    }

    @GetMapping("/phones/findBy{number}")
    ResponseEntity<PhoneNumber> findByNumber(@PathVariable String number) {
        return ResponseEntity.ok(userDataService.findPhoneEntryByNumber(number));
    }

    @PostMapping("/phones")
    ResponseEntity<PhoneNumber> newPhoneNumber(@RequestBody PhoneNumber newPhoneNumber) {
        return ResponseEntity.ok(userDataService.createPhoneNumber(newPhoneNumber));
    }

    @PutMapping("/phones/{id}")
    ResponseEntity<PhoneNumber> replacePhoneNumber(@PathVariable long id, @RequestBody PhoneNumber newPhoneNumber) {
        return ResponseEntity.ok(userDataService.editPhoneNumber(id, newPhoneNumber));
    }

    @DeleteMapping("/phones/{id}")
    void removePhoneNumber(@PathVariable long id) {
        userDataService.removePhoneNumber(id);
    }


}
