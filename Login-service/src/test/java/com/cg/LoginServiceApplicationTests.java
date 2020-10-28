package com.cg;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ofd.UserRepository;

/**
 * 
 * @author Mugdha Chindhe
 *
 * 
 * Unit Testing for LoginService
 *
 */


@RunWith(SpringRunner.class)
@WebMvcTest
class LoginServiceApplicationTests {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserRepository repo;
	
	@Test
	void contextLoads() throws Exception {
		
		Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/login/").accept(MediaType.APPLICATION_JSON)
        ).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		Mockito.verify(repo).findAll();
	}

}
