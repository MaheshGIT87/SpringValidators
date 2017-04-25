package com.fidelity.aws.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fidelity.aws.web.bean.RetrieveBean;

@Controller
public class RetrieveController {

	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public String navigate(Map<String, Object> model) {
		RetrieveBean retrieveBean = new RetrieveBean();
		model.put("retrieveForm", retrieveBean);
		return "retrieve";
	}

	@RequestMapping(value = "/retrieve", method = RequestMethod.POST)
	public Object submit(@Valid @ModelAttribute("retrieveForm") RetrieveBean retrieveBean, BindingResult result,
			Map<String, Object> model, HttpSession session) {
		try {
			if (result.hasErrors()) {
				System.out.println("Has errors");
				return "retrieve";
			}
			if (retrieveBean != null && retrieveBean.getCmkArn() != null) {
				return "home";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "retrieve";
		}
		return session;
	}
}
