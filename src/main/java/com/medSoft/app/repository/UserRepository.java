package com.medSoft.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medSoft.app.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {  } 