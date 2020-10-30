package com.cg.ofd.login.test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.ofd.login.entities.Login;
import com.cg.ofd.login.service.LoginService;
import com.cg.ofd.login.service.LoginServiceImpl;

class LoginTests {
	@Test
	void testSignUp() {
		Login login = new Login(2,"sulekha","sarkar456","customer");
		LoginService loginService = mock(LoginServiceImpl.class);
		when(loginService.signUp(login)).thenReturn(login);
		System.out.println(login.toString());
		Login log = loginService.signUp(login);
		assertEquals(login, log);
	}
	
	@Test
	void testRetrieve() {
		List<Login> login = new ArrayList<Login>();
		login.add(new Login(1,"abcd","passw","owner"));
		login.add(new Login(2,"abcde","passwo","customer"));
		login.add(new Login(3,"abcdef","password","owner"));
		LoginService loginService = mock(LoginServiceImpl.class);
		when(loginService.retrieve()).thenReturn(login);
		System.out.println(login.toString());
		List<Login> log1 = loginService.retrieve();
		assertNotNull(log1);
		assertFalse(log1.isEmpty());
	}
	
	@Test
	void testFindUserbyId() {
		Login login = new Login(2,"sulekha","sarkar456","customer");
		LoginService loginService = mock(LoginServiceImpl.class);
		when(loginService.findUserbyId(2)).thenReturn(login);
		System.out.println(login.toString());
		Login log2 = loginService.findUserbyId(2);
		assertNotNull(log2);	
	}
	
	@Test
	void testFindByuserName() {
		Login login = new Login(2,"sulekha","sarkar456","customer");
		LoginService loginService = mock(LoginServiceImpl.class);
		when(loginService.findByuserNameAndPassword("sulekha", "sarkar456")).thenReturn(login);
		System.out.println(login.toString());
		Login log3 = loginService.findByuserNameAndPassword("sulekha", "sarkar456");
		assertNotNull(log3);
	}
}

