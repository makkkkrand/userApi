package com.medSoft.app.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.medSoft.util.EncryptionUtil;


@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	@Autowired
	EncryptionUtil encryptionUtil;
	
	@Override
	public String encode(CharSequence rawPassword) {
		return encryptionUtil.encrypt(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return (rawPassword.toString().trim()).equals(encryptionUtil.decrypt(encodedPassword));
	}

}
