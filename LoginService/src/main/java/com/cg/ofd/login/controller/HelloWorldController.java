package com.cg.ofd.login.controller;

import java.util.List;

import javax.validation.Valid;

//import org.hibernate.validator.internal.util.logging.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			/*if(login == null) 
				throw new UserNotFoundException("Details Not Found");
			else 
				return login;	*/
			return login;
		}
		
		//This method is to find details by userName and Password i.e. for Login
		@GetMapping(path = "/login/{userName}")
		public Login findByuserName(@PathVariable String userName){
			Login tmpList = jwtLoginDetailsService.findByUsername(userName);
			/*if(tmpList == null) 
				throw new UserNotFoundException("UserName and Password not found");
			else 
				return tmpList;*/
			return tmpList;
		}
		
		//This method is to register OR SignUp the user
		@PostMapping(path = "/login/signup")
		public Login signUp(@Valid @RequestBody Login login) {
			/*if( login.getUsername() == null || login.getPassword() == null || login.getUsername().isEmpty() || login.getPassword().isEmpty()) { 
				throw new UserNotFoundException("UserName and password should have at least 2 characters");}
			else {
				Login signup = jwtLoginDetailsService.signUp(login);
				return signup;
			}*/
			return jwtLoginDetailsService.signUp(login);
		}
		
		//This method is to update the details of user
		@PutMapping("/login/update")
		public void updateDetails(@RequestBody Login login) {
			//logger.info("Inside updateDetails method of LoginController");
			jwtLoginDetailsService.updateDetails(login);
		}

}