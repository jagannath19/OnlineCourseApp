package com.course.util;

import java.util.Random;

public class PasswordGenerator {
	public static String autoPassword() {
	String lowerCase="qwertyuiopasdfghjklmnbvcxz";
	String uperCase="QWERTYUIOPASDFGHJKLMNBVCXZ";
	String specialChar="!@#$%^&*";
	String numbers="0123456789";
	String allChar=lowerCase+uperCase+specialChar+numbers;
	char[] password=new char[8];
	Random random=new Random();
	String convertedPassword="";
	for(int i=0;i<password.length;i++) {
		password[i]=allChar.charAt(random.nextInt(allChar.length()));
		convertedPassword+=password[i];
	}
	return convertedPassword;
}
}
