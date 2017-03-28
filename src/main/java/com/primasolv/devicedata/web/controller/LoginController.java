/**
 * 
 */
package com.primasolv.devicedata.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.primasolv.devicedata.model.DeviceManager;
import com.primasolv.devicedata.model.User;
import com.primasolv.devicedata.service.DeviceManagerService;
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
	
	@Autowired
	DeviceManagerService deviceManagerService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean, HttpSession session) {
        try {
			if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
				User userData = loginService.checkLogin(loginBean.getUserName(), loginBean.getPassword());
				if(userData != null) {
					session.setAttribute("loggedInUser", userData);
					List<DeviceManager> deviceManagerList = deviceManagerService.getDeviceManagerList();
					session.setAttribute("deviceManagerList", deviceManagerList);
					return "selectDeviceManager";
				} else {
					model.addAttribute("error", "Invalid Details");
			        return "login";
				}
			} else {
			    model.addAttribute("error", "Please enter Details");
			    return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
    }
	
}
