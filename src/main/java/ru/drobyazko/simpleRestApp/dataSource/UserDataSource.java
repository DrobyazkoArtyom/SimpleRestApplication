package ru.drobyazko.simpleRestApp.dataSource;

import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class UserDataSource {

    private final List<User> userList;

    public UserDataSource(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return unmodifiableList(userList);
    }

    public User getUser(long userId) {
        for (User user:userList) {
            if(user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        if(user == null) {
            return null;
        }
        userList.add(user);
        return user;
    }

    public void deleteUser(long userId) {
        for (User user:userList) {
            if(user.getId() == userId) {
                userList.remove(user);
                return;
            }
        }
    }

    public void updateUser(User user) {
        if(user == null) {
            return;
        }
        for (User oldUser:userList) {
            if(oldUser.getId() == user.getId()) {
                oldUser.setName(Objects.requireNonNull(user.getName(), "Name cannot be null"));
                oldUser.getPhoneBook().getPhoneList().clear();
                oldUser.getPhoneBook().getPhoneList().addAll(user.getPhoneBook().getPhoneList());
                return;
            }
        }
    }

    public List<PhoneNumber> getEntryList(long userId) {
        for (User user:userList) {
            if(user.getId() == userId) {
                return user.getPhoneBook().getPhoneList();
            }
        }
        return null;
    }

    public PhoneNumber getEntry(long userId, long entryId) {
        for (User user:userList) {
            if(user.getId() == userId) {
                List<PhoneNumber> userPhoneList = user.getPhoneBook().getPhoneList();
                for (PhoneNumber phoneNumber:userPhoneList) {
                    if(phoneNumber.getId() == entryId) {
                        return phoneNumber;
                    }
                }
            }
        }
        return null;
    }

    public void addEntry(long userId, PhoneNumber phoneNumber) {
        for (User user:userList) {
            if(user.getId() == userId) {
                user.getPhoneBook().getPhoneList().add(phoneNumber);
                return;
            }
        }
    }

    public void deleteEntry(long userId, long entryId) {
        for (User user:userList) {
            if(user.getId() == userId) {
                List<PhoneNumber> userPhoneList = user.getPhoneBook().getPhoneList();
                for (PhoneNumber phoneNumber:userPhoneList) {
                    if(phoneNumber.getId() == entryId) {
                        userPhoneList.remove(phoneNumber);
                    }
                }
            }
        }
    }

    public void updateEntry(long userId, long entryId, PhoneNumber replacementEntry) {
        if(replacementEntry == null) {
            return;
        }
        for (User user:userList) {
            if(user.getId() == userId) {
                List<PhoneNumber> userPhoneList = user.getPhoneBook().getPhoneList();
                for (PhoneNumber oldEntry:userPhoneList) {
                    if (oldEntry.getId() == entryId) {
                        userPhoneList.remove(oldEntry);
                        userPhoneList.add(replacementEntry);
                        return;
                    }
                }
            }
        }
    }

    public User findByName(String name) {
        if(name != null) {
            for (User user:userList) {
                if(user.getName().contains(name)) {
                    return user;
                }
            }
        }
        return null;
    }

    public PhoneNumber findByNumber(String number) {
        for (User user:userList) {
            List<PhoneNumber> userPhoneList = user.getPhoneBook().getPhoneList();
            for(PhoneNumber phoneNumber:userPhoneList) {
                if(phoneNumber.getNumber().equals(number)) {
                    return phoneNumber;
                }
            }
        }
        return null;
    }

}
