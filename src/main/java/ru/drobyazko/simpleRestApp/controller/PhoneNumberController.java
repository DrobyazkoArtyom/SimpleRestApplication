package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    Map<Long, PhoneNumber> all() {
        return userDataService.getAllPhoneNumbers();
    }

    @GetMapping("/phones/{id}")
    PhoneNumber one(@PathVariable long id) {
        return userDataService.getPhoneNumber(id);
    }

    @GetMapping("/phones/{number}")
    PhoneNumber findByNumber(@PathVariable String number) {
        return userDataService.findPhoneEntryByNumber(number);
    }

    @PostMapping("/phones")
    PhoneNumber newPhoneNumber(@RequestBody PhoneNumber newPhoneNumber) {
        return userDataService.createPhoneNumber(newPhoneNumber);
    }

    @PutMapping("/phones/{id}")
    PhoneNumber replacePhoneNumber(@PathVariable long id, @RequestBody PhoneNumber newPhoneNumber) {
        return userDataService.editPhoneNumber(id, newPhoneNumber);
    }

    @DeleteMapping("/phones/{id}")
    void removePhoneNumber(@PathVariable long id) {
        userDataService.removePhoneNumber(id);
    }


}
