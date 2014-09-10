package com.lalit.javaExamples.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


public class EncryptionMain {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
//Any implementation of Java need to provide following algorithms
// MD5
// SHA-1
// SHA-256
String encryptionAlgorithm = "SHA-1";

try {			
	MessageDigest md = MessageDigest.getInstance(encryptionAlgorithm);
	
	String clearPassword = "password123";
	String salt = "TATASalt";
	
	md.reset();
	md.update((clearPassword+salt).getBytes("UTF-8"));

	byte[] digestedPassword = md.digest();
	String hexStr = "";
	for (int i = 0; i < digestedPassword.length; i++) {
		hexStr += Integer.toString

		((digestedPassword[i] & 0xff) + 0x100, 16).substring(1);
	}
	
	//Print the encrypted password
	System.out.println(hexStr);
	
	// Many code snippets in web show the following way of generating
	// the hex
	// code. The right way is the above way and not the way below which
	// is
	// commented out. The following code generates hex code with
	// negative sign
	// for certain combination for example for "password123" . Still do
	// not know the mathematics behind it.
	// Will probe sometime in future, right now
	// has to fix the issue. :(
	//String encryptedPAssword = String.format("%x", new BigInteger(
	//		digestedPassword));
	//System.out.println(encryptedPAssword);

} catch (java.security.NoSuchAlgorithmException e) {
	System.out.println("Rats, " + encryptionAlgorithm + " doesn't exist");
}
	}

}
