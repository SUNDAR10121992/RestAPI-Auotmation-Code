package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	@Test
	void testDataGenerator() {

		Faker fakerdata = new Faker();

		String fullNameString = fakerdata.name().fullName();

		String firstnameString = fakerdata.name().firstName();

		String lastNameString = fakerdata.name().lastName();

		String usernameString = fakerdata.name().username();

		String pass = fakerdata.internet().password();

		String phonString = fakerdata.phoneNumber().cellPhone();

		String mailString = fakerdata.internet().emailAddress();

		String emailString = fakerdata.internet().safeEmailAddress();

		System.out.println("Fullname " + fullNameString);
		System.out.println("Firstname " + firstnameString);
		System.out.println("LastName " + lastNameString);
		System.out.println("username " + usernameString);
		System.out.println("password " + pass);
		System.out.println("phone " + phonString);
		System.out.println("mail " + mailString);
		System.out.println("email " + emailString);

	}
}
