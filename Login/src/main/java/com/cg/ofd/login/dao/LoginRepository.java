package com.cg.ofd.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ofd.login.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	//public List<Login> retrieve();
	public Login findByuserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
	//public Login signUp(@RequestBody Login customer);
}
