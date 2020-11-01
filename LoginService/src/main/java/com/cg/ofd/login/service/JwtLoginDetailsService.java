package com.cg.ofd.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.ofd.login.dao.LoginDao;
import com.cg.ofd.login.exception.UserNotFoundException;
import com.cg.ofd.login.model.Login;
import com.cg.ofd.login.model.LoginDTO;

@Service
public class JwtLoginDetailsService implements UserDetailsService,LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login user = loginDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public Login save(LoginDTO user) {
		Login newUser = new Login();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		
		
			return loginDao.save(newUser);
		
		
	}

	@Override
	public List<Login> retrieve() {
		System.out.println("Inside retrieve() method");
		return loginDao.findAll();
	}

	

	@Override
	public Login findUserbyId(int userId) {
		System.out.println("Inside findUserbyId(int userId) method");
		Login login = loginDao.findById(userId).get();
		return login;
	}

	@Override
	public Login updateDetails(Login login) {
		System.out.println("Inside updateDetails(Login login) method");
		return loginDao.save(login);
	}


}