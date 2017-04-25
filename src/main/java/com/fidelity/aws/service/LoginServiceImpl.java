/**
 * 
 */
package com.fidelity.aws.service;

import org.springframework.stereotype.Service;

import com.fidelity.aws.model.User;

/**
 * @author kiran
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/* (non-Javadoc)
	 * @see com.primasolv.devicedealer.service.LoginService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkLogin(String userName, String userPassword) {
		User user = dummyAuthentication(userName, userPassword);
		return user;
	}
	
	
	
	/**
	 * This is Dummy method till back end DB is ready for user information
	 * @param userName
	 * @param password
	 * @return
	 */
	private User dummyAuthentication(String userName, String password) {
		User user = null;
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			user =  new User();
			user.setUsername("admin");
			user.setFirstName("Admin");
			user.setLastName("Admin");
		}
		return user;
	}

}
