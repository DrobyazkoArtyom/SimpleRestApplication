package ru.drobyazko.simpleRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.drobyazko.simpleRestApp.exceptions.NotFoundException;
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
    ResponseEntity<Map<Long, PhoneNumber>> getAllPhoneNumbers() {
        return ResponseEntity.ok(userDataService.getAllPhoneNumbers());
    }

    @GetMapping("/phones/{id}")
    ResponseEntity<PhoneNumber> getPhoneNumberById(@PathVariable long id) {
        PhoneNumber phoneNumber = userDataService.getPhoneNumber(id);
        if(phoneNumber == null) {
            throw new NotFoundException("No phone number with such id.");
        }
        return ResponseEntity.ok(phoneNumber);
    }

    @GetMapping("/phones/findBy{number}")
    ResponseEntity<PhoneNumber> findByNumber(@PathVariable String number) {
        PhoneNumber phoneNumber = userDataService.findPhoneEntryByNumber(number);
        if(phoneNumber == null) {
            throw new NotFoundException("No phone number found.");
        }
        return ResponseEntity.ok(phoneNumber);
    }

    @PostMapping("/phones")
    ResponseEntity<PhoneNumber> newPhoneNumber(@RequestBody PhoneNumber newPhoneNumber) {
        return ResponseEntity.ok(userDataService.createPhoneNumber(newPhoneNumber));
    }

    @PutMapping("/phones/{id}")
    ResponseEntity<PhoneNumber> replacePhoneNumber(@PathVariable long id, @RequestBody PhoneNumber newPhoneNumber) {
        PhoneNumber phoneNumber = userDataService.editPhoneNumber(id, newPhoneNumber);
        if(phoneNumber == null) {
            throw new NotFoundException("No phone number found.");
        }
        return ResponseEntity.ok(phoneNumber);
    }

    @DeleteMapping("/phones/{id}")
    void removePhoneNumber(@PathVariable long id) {
        userDataService.removePhoneNumber(id);
    }


}
