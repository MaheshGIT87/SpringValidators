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
public interface LoginService {
	
	public User checkLogin(String userName, String userPassword);
	
}
