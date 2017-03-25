/**
 * 
 */
package com.primasolv.devicedata.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.primasolv.devicedata.model.User;
import com.primasolv.devicedata.service.LoginService;
import com.primasolv.devicedata.web.bean.LoginBean;

/**
 * @author kiran
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		System.out.println("###:"+loginBean.getUserName()+"--"+loginBean.getPassword());
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
        	User userData = loginService.checkLogin(loginBean.getUserName(), loginBean.getPassword());
        	if(userData != null) {
//        		session.setAttribute("loggedInUser", userData);
//        		session.setAttribute("username", "KiranNunna");
        		return "selectDeviceManager";
        	} else {
        		model.addAttribute("error", "Invalid Details");
                return "login";
        	}
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
	
}
