package com.lalit.javaExamples.security;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * To generate public private key see the blogpost at
 * <a href="http://tech.lalitbhatt.net/2014/09/generating-private-and-public-key-using.html">Blog</a>
 * @author Lalit
 *
 */
public class PrivatePublicKey {

	public static void main(String[] args) throws Exception {
		try {
// Private Keystore
FileInputStream privateKeyFile = new FileInputStream(
		"E:/temp/lalit_private_keystore");

// Public Keystore
FileInputStream publicKeyFile = new FileInputStream(
		"E:/temp/lalit_public_keystore");

// Read the private keystore and get Private Key
KeyStore privateKeyStore = KeyStore.getInstance(KeyStore
		.getDefaultType());
System.out.println("Type of private key: "
		+ privateKeyStore.getDefaultType());
privateKeyStore.load(privateKeyFile, "lalit123".toCharArray());
PrivateKey privateKey = (PrivateKey)privateKeyStore.getKey("lalit_private", "lalit123".toCharArray());

// Read the public keystore and get public key
KeyStore publicKeyStore = KeyStore.getInstance(KeyStore
		.getDefaultType());
System.out.println("Type of public key: "
		+ publicKeyStore.getDefaultType());
publicKeyStore.load(publicKeyFile, "lalit456".toCharArray());
Certificate publicCertificate = publicKeyStore
		.getCertificate("lalit_public");
PublicKey publicKey = publicCertificate.getPublicKey();


//Let's encrypt with private and decrypt with public
// Encrypt with private key
String firstString = "Ishana";

Cipher privateEncryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
privateEncryptCipher.init(Cipher.ENCRYPT_MODE, privateKey);

byte[] encryptedFirstString = privateEncryptCipher
		.doFinal(firstString.getBytes());
String encodedEncryptedFirstString = Base64.getEncoder()
		.encodeToString(encryptedFirstString);
System.out.println("Encoded encrypted String for Ishana: "
		+ encodedEncryptedFirstString);

// Decrypt with public key
// First decode the string
byte[] decodedEncryptedFirstString = Base64.getDecoder().decode(
		encodedEncryptedFirstString);

Cipher publicDecryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
publicDecryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
byte[] decryptedFirstStringByte = publicDecryptCipher
		.doFinal(decodedEncryptedFirstString);
System.out.println("Decrypted String for Ishana: "
		+ new String(decryptedFirstStringByte));

//Let's encrypt with public and decrypt with private
// Encrypt with public key
String secondString = "Ekagra";

Cipher publicEncryptCipher = Cipher.getInstance("RSA");
publicEncryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
byte[] encryptedSecondString = publicEncryptCipher
		.doFinal(secondString.getBytes());
String encodedEncryptedSecondString = Base64.getEncoder()
		.encodeToString(encryptedSecondString);
System.out.println("Encoded encrypted String for Ekagra: "
		+ encodedEncryptedSecondString);

// Decrypt with private key
byte[] decodedEncryptedSecondString = Base64.getDecoder().decode(
		encodedEncryptedSecondString.getBytes());
Cipher privateDecryptCipher = Cipher.getInstance("RSA");
privateDecryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
byte[] decryptedSecondStringByte = privateDecryptCipher
		.doFinal(decodedEncryptedSecondString);
System.out.println("Decrypted String for Ekagra: "
		+ new String(decryptedSecondStringByte));

privateKeyFile.close();
publicKeyFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
