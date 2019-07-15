package com.eCRM.client.utils;

import java.util.Random;

public class RandomGeneratorUtils 
{
	private static Random random = new Random();
	private static StringBuilder randomValueHolder = new StringBuilder();
	private static String userName = "123QWERTYUIOPASDFGABCDEFGHIJKLMNO456hjklzxcvbnmabcdefghijklmno789";
	private static String password = "123QWERTYUIOPASDFG456hjklzxcvbnm789~!@#$%^&*_+-=|(){}<>?/,.";

	public static int getRandomNumber(int upperRange)
	{
		return random.nextInt(upperRange);
	}

	public static String getRandomString(String sourceString, int length)
	{
		for(int i = 0; i < length; i++)
		{
			randomValueHolder.append(sourceString.charAt(random.nextInt(sourceString.length())));
		}
		return randomValueHolder.toString();
	}

	public static String generateRandomEmail()
	{
		return "Newuser"+ getRandomString(userName, 15) + "@yopmail.com";
	}
	
	public static String generateRandomPassword()
	{
		return getRandomString(password, 15);
	}
	
}
