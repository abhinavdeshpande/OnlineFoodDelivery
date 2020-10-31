package com.cg.ofd.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.login.model.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer> {
	
	Login findByUsername(String username);
	
}