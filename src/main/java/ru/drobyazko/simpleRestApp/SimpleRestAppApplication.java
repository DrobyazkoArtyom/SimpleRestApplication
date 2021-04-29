package ru.drobyazko.simpleRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
		SpringApplication.run(SimpleRestAppApplication.class, args);
	}

}
