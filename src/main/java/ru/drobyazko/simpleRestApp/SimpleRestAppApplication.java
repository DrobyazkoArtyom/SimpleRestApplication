package ru.drobyazko.simpleRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.drobyazko.simpleRestApp.dataSource.UserDataSource;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;
import ru.drobyazko.simpleRestApp.service.UserDataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class SimpleRestAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SimpleRestAppApplication.class, args);
		UserDataService userDataService = new UserDataService();
		userDataService.createUser("Artyom");
		userDataService.createUser("Mikhail");
		userDataService.createUser("Alexey");
		System.out.println(userDataService.getUser(0));
		System.out.println(userDataService.getUser(1));
		System.out.println(userDataService.getUser(2));
		userDataService.removeUser(0);
		System.out.println(userDataService.getUser(0));
		System.out.println(userDataService.getUser(1));
		System.out.println(userDataService.getUser(2));
		System.out.println(userDataService.findUserByName("ikha"));
		userDataService.createPhoneNumber(1, "Senya", "394288483");
		userDataService.createPhoneNumber(1, "Danya", "394232221");
		System.out.println(userDataService.getUserPhoneBook(1));
		System.out.println(userDataService.findPhoneEntryByNumber("394288483"));
	}

}
