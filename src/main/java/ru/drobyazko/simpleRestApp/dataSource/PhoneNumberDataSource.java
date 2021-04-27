package ru.drobyazko.simpleRestApp.dataSource;

import ru.drobyazko.simpleRestApp.model.PhoneNumber;

import java.util.Map;

public class PhoneNumberDataSource {

    private final Map<Long, PhoneNumber> phoneNumberMap;
    private long phoneNumberId;

    public PhoneNumberDataSource(Map<Long, PhoneNumber> phoneNumberMap) {
        this.phoneNumberMap = phoneNumberMap;
    }

    public PhoneNumber getPhoneNumber(long id) {
        return phoneNumberMap.get(id);
    }

    public Map<Long, PhoneNumber> getAll() {
        return phoneNumberMap;
    }

    public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberMap.put(phoneNumberId, phoneNumber);
        phoneNumberId++;
        return phoneNumber;
    }

    public PhoneNumber editPhoneNumber(long id, PhoneNumber phoneNumber) {
        if(phoneNumberMap.replace(id, phoneNumber) == null) {
            return null;
        }
        return phoneNumber;
    }

    public void removePhoneNumber(long id) {
        phoneNumberMap.remove(id);
    }

}
