package com.cg.ofd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRepository extends JpaRepository<Login, Integer> {
	
	public Login findByuserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
	
	//public Login updateRegistrationDetails(@RequestBody Login user, @PathVariable int userId);
}
