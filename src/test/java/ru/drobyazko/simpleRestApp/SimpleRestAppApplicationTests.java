package ru.drobyazko.simpleRestApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import ru.drobyazko.simpleRestApp.model.PhoneNumber;
import ru.drobyazko.simpleRestApp.model.User;
import ru.drobyazko.simpleRestApp.service.UserDataService;

import java.util.Map;

@SpringBootTest
class SimpleRestAppApplicationTests {

	private UserDataService userDataService;

	@BeforeEach
	void initDataSources() {
		userDataService = new UserDataService();
		userDataService.createUser(new User("SmallBoi"));
		userDataService.createUser(new User("MediumBoi"));
		userDataService.createPhoneNumber(new PhoneNumber(0L, "SmallPhoneBoi", "5553535"));
		userDataService.createPhoneNumber(new PhoneNumber(0L, "MediumPhoneBoi", "9998181"));
	}

	@Test
	void contextLoads() {
		assertNotNull(userDataService);
	}

	@Test
	void getOneUser() {
		assertEquals("SmallBoi", userDataService.getUser(0L).getName());
	}

	@Test
	void getAllUsers() {
		Map<Long, User> userMap = userDataService.getAllUsers();
		assertEquals("SmallBoi", userMap.get(0L).getName());
		assertEquals("MediumBoi", userMap.get(1L).getName());
	}

	@Test
	void createUser() {
		User newUser = new User("ChonkyBoi");
		assertEquals("ChonkyBoi", userDataService.createUser(newUser).getName());
	}

	@Test
	void updateUser() {
		User newUser = new User("ThinBoi");
		assertEquals("ThinBoi", userDataService.editUser(0L, newUser).getName());
	}

	@Test
	void deleteUser() {
		userDataService.removeUser(0L);
		assertNull(userDataService.getUser(0L));
	}

	@Test
	void findUserByName() {
		assertEquals("SmallBoi", userDataService.findUserByName("mall").getName());
	}

	@Test
	void getOnePhoneNumber() {
		assertEquals("5553535", userDataService.getPhoneNumber(0L).getNumber());
	}

	@Test
	void getAllPhoneNumbers() {
		Map<Long, PhoneNumber> phoneNumberMap = userDataService.getAllPhoneNumbers();
		assertEquals("5553535", phoneNumberMap.get(0L).getNumber());
		assertEquals("9998181", phoneNumberMap.get(1L).getNumber());
	}

	@Test
	void createPhoneNumber() {
		PhoneNumber newPhoneNumber = new PhoneNumber(0L, "ChonkyPhoneBoi", "7776666");
		assertEquals("7776666", userDataService.createPhoneNumber(newPhoneNumber).getNumber());
	}

	@Test
	void updatePhoneNumber() {
		PhoneNumber newPhoneNumber = new PhoneNumber(0L, "ChonkyPhoneBoi", "7776666");
		assertEquals("7776666", userDataService.editPhoneNumber(0L, newPhoneNumber).getNumber());
	}

	@Test
	void deletePhoneNumber() {
		userDataService.removePhoneNumber(0L);
		assertNull(userDataService.getPhoneNumber(0L));
	}

	@Test
	void findPhoneEntryByNumber() {
		assertEquals(0L, userDataService.findPhoneEntryByNumber("5553535").getUserId());
	}

	@Test
	void getUserPhoneBook() {
		assertEquals("5553535", userDataService.getUserPhoneBook(0L).get(0).getNumber());
		assertEquals("9998181", userDataService.getUserPhoneBook(0L).get(1).getNumber());
	}

}
