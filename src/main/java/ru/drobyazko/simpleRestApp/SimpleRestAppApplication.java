package ru.drobyazko.simpleRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.drobyazko.simpleRestApp.dataSource.UserDataSource;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SimpleRestAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SimpleRestAppApplication.class, args);
		UserDataSource userData = new UserDataSource(new ArrayList<User>());
		userData.addUser(new User(1, "Mikhail"));
		System.out.println(userData.getUserList());
		userData.updateUser(new User(1, "Bruh"));
		userData.addEntry(1, new PhoneNumber(1, "Petr", "1729378837"));
		System.out.println(userData.getUserList());
		userData.updateEntry(1,1,new PhoneNumber(1, "NePetr", "174378837"));
		System.out.println(userData.getUserList());
		userData.addEntry(1, new PhoneNumber(2, "MegaChel", "765456466"));
		System.out.println(userData.getEntryList(1));
		System.out.println(userData.findByName("ruh"));
		userData.deleteUser(1);
		System.out.println(userData.getUserList());
	}

}
