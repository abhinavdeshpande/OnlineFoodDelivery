package com.cg;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ofd.LoginServiceApplication;

/**
 * 
 * @author Mugdha Chindhe
 *
 * 
 * Integration Testing for LoginService
 *
 */


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes=LoginServiceApplication.class	
)

@AutoConfigureMockMvc
public class LoginServiceApplicationITests {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/login/").accept(MediaType.APPLICATION_JSON)
        ).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		
	}
}
