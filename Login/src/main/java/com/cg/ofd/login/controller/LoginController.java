package com.cg.ofd.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.login.dao.LoginRepository;
import com.cg.ofd.login.entities.Login;
import com.cg.ofd.login.exception.UserNotFoundException;
import com.cg.ofd.login.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	@GetMapping("/login")
	public List<Login> retrieve() {
		List<Login> login = loginService.retrieve();
		if(login.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		else {
			return login;
		}
	}
	
	@GetMapping("/login/{userId}")
	public Login findUserbyId(@PathVariable int userId){
		Login login = loginService.findUserbyId(userId); //.findById(userId).get();
		return login;
	}
	
	@GetMapping(path = "/login/{userName}/{password}")
	public Login findByuserName(@PathVariable String userName,@PathVariable String password){
		Login tmpList = loginService.findByuserNameAndPassword(userName, password);
		//if(tmpLis)
		return tmpList;
	}
	
	@PostMapping(path = "/login/signup")
	public Login signUp(@Valid @RequestBody Login login) {
		return loginService.signUp(login);
	}
}
