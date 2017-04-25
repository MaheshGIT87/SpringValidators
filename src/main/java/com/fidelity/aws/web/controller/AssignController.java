/**
 * 
 */
package com.fidelity.aws.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fidelity.aws.service.AssignGroupService;

/**
 * @author kiran
 *
 */
@Controller
public class AssignController {

	@Autowired
	AssignGroupService assignGroupService;
	
	@RequestMapping(value = "/assign", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody String submit(@RequestBody Map<String, Object> requestBody, HttpSession session) {
        try {
			System.out.println(requestBody);
			assignGroupService.assignGroup(requestBody);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
    }
}
