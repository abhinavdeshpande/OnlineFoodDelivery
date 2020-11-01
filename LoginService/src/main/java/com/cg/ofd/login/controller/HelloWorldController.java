package com.cg.ofd.login.controller;

import java.util.List;


//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.login.exception.UserNotFoundException;
import com.cg.ofd.login.model.Login;
import com.cg.ofd.login.service.JwtLoginDetailsService;

@RestController
public class HelloWorldController {

	@Autowired
	private JwtLoginDetailsService jwtLoginDetailsService;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	//This method is to view all the details of login
		@GetMapping("/login")
		public List<Login> retrieve() {
			List<Login> login = jwtLoginDetailsService.retrieve();
			/*if(login.isEmpty())
				throw new UserNotFoundException("User does not exist");
			else*/
				return login;
		}

		//This method is to find details by userID
		@GetMapping("/login/{userId}")
		public Login findUserbyId(@PathVariable int userId){
			Login login = jwtLoginDetailsService.findUserbyId(userId); //.findById(userId).get();
			if(login == null) 
				throw new UserNotFoundException("Details Not Found");
			else 
				return login;	
			//return login;
		}
		
		//This method is to update the details of user
		@PutMapping("/login/update")
		public void updateDetails(@RequestBody Login login) {
			jwtLoginDetailsService.updateDetails(login);
		}
		
		@GetMapping("/login/getrole/{userId}")
	    public String currentRole(@PathVariable int userId) {
			System.out.println("I am in getRole");
			Login login = jwtLoginDetailsService.findUserbyId(userId);
			String tmprole = login.getRole();
			//System.out.println(tmprole);
	        return login.getRole();
	        
	    }
		
		

}