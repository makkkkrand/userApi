package com.medSoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medSoft.app.models.User;

@Service
public interface UserService {
	String saveUser(User user);

	List<User> findAllUser();

	User findUser(int id);

	String modifyUser(User user, int id);
}