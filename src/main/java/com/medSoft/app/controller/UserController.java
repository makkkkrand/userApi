package com.medSoft.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.medSoft.app.models.User;
import com.medSoft.app.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/user/save")
	public String storeUser(@RequestBody User User, @RequestHeader Map<String, String> header) {
		String saveUser = userService.saveUser(User);
		return saveUser;
	}

	@GetMapping(value = "/user/fetchAll")
	public List<User> fetchAllUser() {
		List<User> findAllUser = userService.findAllUser();
		return findAllUser;
	}

	@PutMapping(value = "/user/modify/{id}")
	public String modifyUser(@RequestBody User User, @PathVariable int id) {
		String modifyUser = userService.modifyUser(User, id);
		return modifyUser;
	}

	@GetMapping(value = "/user/fetch/{id}")
	public User fetchUser(@PathVariable int id) {
		User findUser = userService.findUser(id);
		return findUser;
	}
}