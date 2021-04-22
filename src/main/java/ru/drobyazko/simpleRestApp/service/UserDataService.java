package ru.drobyazko.simpleRestApp.service;

import ru.drobyazko.simpleRestApp.dataSource.UserDataSource;

public class UserDataService {

    private final UserDataSource userDataSource;

    public UserDataService(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }



}
