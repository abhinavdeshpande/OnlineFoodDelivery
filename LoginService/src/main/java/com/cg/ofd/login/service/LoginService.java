package com.cg.ofd.login.service;
import java.util.List;

import com.cg.ofd.login.model.*;
public interface LoginService {
	public List<Login> retrieve();
	public Login findByUsername(String userName);
	public Login signUp(Login login);
	public Login findUserbyId(int userId);
	public Login updateDetails(Login login);
}
