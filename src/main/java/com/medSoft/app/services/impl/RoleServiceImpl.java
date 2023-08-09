package com.medSoft.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medSoft.app.models.Role;
import com.medSoft.app.repository.RoleRepository;
import com.medSoft.app.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository repo;

	@Override
	public String saveRole(Role role) {
		Role output = repo.save(role);
		log.info("Saved role:{}", output);
		return null != output ?"Pass":"Fail";
	}

	@Override
	public List<Role> findAllRole() {
		return repo.findAll();
	}

	@Override
	public String modifyRole(Role role, int id) {
		role.setUserRoleId(id);
		Role output = repo.save(role);
		log.info("Modified role", output.getRole());
		return null != output ?"Pass":"Fail";
	}

	@Override
	public Role findRole(int id) {
		Optional<Role> output = repo.findById(id);
		log.info("Fetched role", output.isPresent()?output.get():null);
		return output.isPresent()?output.get():null;
	}

}
