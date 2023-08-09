package com.medSoft.configuration;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretConfig {

	@Value("${secret.key}")
	private String secretKey;

	@Value("${secret.salt}")
	private String salt;
	
	private static final String PBKDF2_WITH_HMAC_SHA256 = "PBKDF2WithHmacSHA256";
	
	private final byte[] iv = { 'M', 'E', 'D', 'A', 'P', 'I', 'S', 'E', 'C', 'R', 'E', 'T', 'S', 'P', 'E', 'C' };
	
	private static final String AES = "AES";
	
	@Bean
	SecretKeySpec extractSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2_WITH_HMAC_SHA256);
		KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), AES);
		return secretKey;
	}
	
	@Bean
	IvParameterSpec extractIvParameterSpec() {
		return new IvParameterSpec(iv);
	}
}
//
//Anshu jha: 10yr
//anshu jha k papa: Arun Jha: 48yr
//
