package com.medSoft.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medSoft.app.models.Role;

@Service
public interface RoleService {

	String saveRole(Role role);
	List<Role> findAllRole();
	Role findRole(int id);
	String modifyRole(Role role, int id);
}
