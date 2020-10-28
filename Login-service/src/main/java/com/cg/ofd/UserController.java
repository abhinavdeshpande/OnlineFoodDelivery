package com.cg.ofd;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	//This method is to retrieve login details
	@GetMapping("/login")
	public List<Login> retrieve() {
		return repo.findAll();
	}
	
	//This method is to retrieve login details by userId
	@GetMapping("/login/{userId}")
	public Login findUserbyId(@PathVariable int userId){
		Login login = repo.findById(userId).get();
		return login;
	}
	
	//This method is to signIn the customer and restaurant owner
	@GetMapping(path = "/login/{userName}/{password}")
	public Login findByuserName(@PathVariable String userName,@PathVariable String password){
		Login tmpList = repo.findByuserNameAndPassword(userName,password);
		return tmpList;
	}	
	
	//This method is to signup the customer
	@PostMapping(path = "/signup")
	public Login signUp(@RequestBody Login customer) {
		return repo.save(customer);
	}
	
	//This method is to delete login details by userId
	@DeleteMapping("/login/remove/{userId}")
	public void removeDetails(int userId) {
		repo.deleteById(userId);
	}
	
	/*@PutMapping("/update/{userId}")
	public Login updateRegistrationDetails(@RequestBody Login user, @PathVariable int userId) {
		logger.info("Inside updateRegistrationDetails() method of UserController");
		repo.delete(repo.findById(userId).get());
		return repo.save(user);
	}*/

	//This method is to update signUp details
	@PutMapping("/update")
	public Login updateRegistrationDetails(@RequestBody Login user) {
		logger.info("Inside updateRegistrationDetails() method of UserController");
		return repo.save(user);
	}
	
}

 
