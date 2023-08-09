package com.medSoft.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medSoft.app.models.User;
import com.medSoft.app.repository.UserRepository;
import com.medSoft.app.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;

	@Override
	public String saveUser(User user) {
		User output = repo.save(user);
		log.info("Saved User:{}", output);
		return null != output ? "Pass" : "Fail";
	}

	@Override
	public List<User> findAllUser() {
		return repo.findAll();
	}

	@Override
	public String modifyUser(User user, int id) {
		user.setId(id);
		User output = repo.save(user);
		log.info("Modified User", output.getId());
		return null != output ? "Pass" : "Fail";
	}

	@Override
	public User findUser(int id) {
		Optional<User> output = repo.findById(id);
		log.info("Fetched User", output.isPresent() ? output.get() : null);
		return output.isPresent() ? output.get() : null;
	}
}