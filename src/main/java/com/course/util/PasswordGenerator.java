package com.course.util;

import java.util.Random;

/**
 * @author JagannathSutar
 *
 */
public class PasswordGenerator {
	/**
	 * @return String
	 * This method use to auto generate the password and return the password
	 */
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
