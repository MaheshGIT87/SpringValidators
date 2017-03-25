/**
 * 
 */
package com.primasolv.devicedata.service;

import org.springframework.stereotype.Service;

import com.primasolv.devicedata.model.User;

/**
 * @author kiran
 *
 */
@Service
public interface LoginService {
	
	public User checkLogin(String userName, String userPassword);
	
}
