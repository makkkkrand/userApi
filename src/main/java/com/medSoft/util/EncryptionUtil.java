package com.medSoft.util;

//Java program to demonstrate the creation of Encryption and Decryption with Java AES

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EncryptionUtil {

	private static final String AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";

	@Autowired
	SecretKeySpec secretKey;

	@Autowired
	IvParameterSpec ivspec;
	
	public String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			log.error("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			log.error("Error while decrypting: " + e.toString());
		}
		return null;
	}

}