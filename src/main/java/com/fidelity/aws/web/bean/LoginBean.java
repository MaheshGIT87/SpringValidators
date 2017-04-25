/**
 * 
 */
package com.fidelity.aws.web.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author kiran
 *
 */
public class LoginBean {
	
	@NotNull
	@NotEmpty(message = "Please enter your user name.")
    private String userName;
	
	@NotNull
    @Size(min = 5, max = 5)
    private String password;
	
	@NotNull
	@Pattern(regexp = "[0-9]{10}", message="enter valid arn number")
	private String arn;
    
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getArn() {
		return arn;
	}
	public void setArn(String arn) {
		this.arn = arn;
	}
	
	
}
