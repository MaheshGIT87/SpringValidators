/**
 * 
 */
package com.fidelity.aws.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fidelity.aws.model.User;
import com.fidelity.aws.service.LoginService;
import com.fidelity.aws.web.bean.LoginBean;

/**
 * @author kiran
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model) {
		LoginBean loginBean = new LoginBean();
		model.put("userForm", loginBean);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("userForm") LoginBean loginBean,
			BindingResult result, Map<String, Object> model,  HttpSession session) {
        try {
        	if (result.hasErrors()) {
        		System.out.println("Has errors");
                return "login";
            }
			if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
				User userData = loginService.checkLogin(loginBean.getUserName(), loginBean.getPassword());
				if(userData != null) {
					session.setAttribute("loggedInUser", userData);
					return "home";
				} else {
					//model.addAttribute("error", "Invalid Details");
			        return "login";
				}
			} else {
			    //model.addAttribute("error", "Please enter Details");
			    return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
    }
	
}
