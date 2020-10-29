package com.cg.ofd.login.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.ofd.login.entities.Login;

public interface LoginService {
	public List<Login> retrieve();
	public Login findByuserNameAndPassword(String userName, String password);
	public Login signUp(Login login);
	public Login findUserbyId(int userId);
}
