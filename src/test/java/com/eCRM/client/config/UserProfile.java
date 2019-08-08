package com.eCRM.client.config;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.eCRM.client.core.CommonUtils;
import com.eCRM.client.core.Config.UserDetails;
import com.eCRM.client.core.DriverManager;
import com.eCRM.client.core.RandomGeneratorUtils;
import com.github.javafaker.Faker;

public class UserProfile extends CommonUtils {
	static Faker random;
	private static String fullName;
	private static String firstName = null;
	private static String lastName = null;
	private static String address;
	private static String city;
	private static String postalCode;
	private static String[] nameHolder;
	private static String value = null;

	public UserProfile() {
		random = new Faker();
		fullName = null;
	}

	
	
	@DataProvider(name = "RegressionCredentials")
	public Object[][] getUserCredentials(Method m) {
		if (m.getName().equalsIgnoreCase("loginwithInvalidCredentialsTest")) {
			
			return new Object[][] { 
				{ RandomGeneratorUtils.generateRandomUserId(), RandomGeneratorUtils.generateRandomPassword()}, 
				{ DriverManager.getUserName(), RandomGeneratorUtils.generateRandomPassword() }, 
				{ RandomGeneratorUtils.generateRandomUserId(), DriverManager.getUserName() } };
			
		} else {
			
			return new Object[][] { { DriverManager.getUserName(), DriverManager.getPassword() } };
		}
	}
	
	
	public String getDetails(UserDetails aProfile) {
		switch (aProfile) {
		case FULLNAME:
			setFullName(random.name().fullName());
			value = getFullName();
			break;
		case FIRST_NAME:
			if (fullName != null) {
				nameHolder = split(fullName, " ");
				value = nameHolder[0];
				setFirstName(value);
			} else {
				setFirstName(random.name().firstName());
				value = getFirstName();
			}

			break;
		case LAST_NAME:
			if (fullName != null) {
				nameHolder = split(fullName, " ");
				value = nameHolder[1];
				setFirstName(value);
			} else {
				setLastName(random.name().lastName());
				value = getLastName();
			}

			break;
		case ADDRESS:
			setAddress(random.address().streetAddress());
			value = getAddress();
			break;
		case CITY:
			setCity(random.address().cityName());
			value = getCity();
			break;
		case POSTCODE:
			setPostalCode(random.address().zipCode());
			value = getPostalCode();
			break;

		default:
			break;
		}
		return value;

	}

	public String getFullName() {
		return fullName;
	}

	public static void setFullName(String fullName) {
		UserProfile.fullName = fullName;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String userFirstName) {
		UserProfile.firstName = userFirstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String userLastName) {
		UserProfile.lastName = userLastName;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		UserProfile.address = address;
	}

	public static String getPostalCode() {
		return postalCode;
	}

	public static void setPostalCode(String postalCode) {
		UserProfile.postalCode = postalCode;
	}

	public static String getCity() {
		return city;
	}

	public static void setCity(String city) {
		UserProfile.city = city;
	}

}
