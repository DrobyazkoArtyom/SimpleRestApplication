package ru.drobyazko.simpleRestApp.dataSource;

import ru.drobyazko.simpleRestApp.model.User;

import java.util.Map;

public class UserDataSource {

    private final Map<Long, User> userMap;
    private long userId;

    public UserDataSource(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Long, User> getAll() {
        return userMap;
    }

    public User getUser(long id) {
        return userMap.get(id);
    }

    public User addUser(User user) {
        userMap.put(userId, user);
        userId++;
        return user;
    }

    public User editUser(long id, User user) {
        userMap.replace(id, user);
        return user;
    }

    public void removeUser(long id) {
        userMap.remove(id);
    }

}
