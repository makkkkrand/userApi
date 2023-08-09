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

import com.medSoft.app.models.Role;
import com.medSoft.app.services.RoleService;


@RestController
//@SecurityRequirement(name = "medSoftApi")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping(value = "/role/save")
	public String storeRole(@RequestBody Role role,
			@RequestHeader Map<String, String> header) {
		String saveRole = roleService.saveRole(role);
		return saveRole;
	}

	@GetMapping(value = "/role/fetchAll")
	public List<Role> fetchAllRole() {
		List<Role> findAllRole = roleService.findAllRole();
		return findAllRole;
	}
	@PutMapping(value = "/role/modify/{id}")
	public String modifyRole(@RequestBody Role role, @PathVariable int id) {
		String modifyRole = roleService.modifyRole(role, id);
		return modifyRole;
	}
	
	@GetMapping(value = "/role/fetch/{id}")
	public Role fetchRole(@PathVariable int id) {
		Role findRole = roleService.findRole(id);
		return findRole;
	}
	
}
