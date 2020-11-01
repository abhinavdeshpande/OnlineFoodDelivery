package com.cg.ofd.login.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.ofd.login.model.Login;
import com.cg.ofd.login.service.JwtLoginDetailsService;
import com.cg.ofd.login.service.LoginService;

public class LoginTests {

	/*@Test
	public void testRetrieve() {
		List<Login> login = new ArrayList<Login>();
		login.add(new Login(1,"abcd","passw"));
		login.add(new Login(2,"abcde","passwo"));
		login.add(new Login(3,"abcdef","password"));
		LoginService loginService = mock(JwtLoginDetailsService.class);
		when(loginService.retrieve()).thenReturn(login);
		System.out.println(login.toString());
		List<Login> log1 = loginService.retrieve();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	@Test
	public void testFindUserbyId() {
		Login login = new Login(2,"sulekha","sarkar456");
		LoginService loginService = mock(JwtLoginDetailsService.class);
		when(loginService.findUserbyId(2)).thenReturn(login);
		System.out.println(login.toString());
		Login log2 = loginService.findUserbyId(2);
		assertNotNull(log2);	
	}*/
}
