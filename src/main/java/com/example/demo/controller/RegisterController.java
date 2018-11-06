package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.services.userServices.UserServices;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserServices userServices;
	
	@RequestMapping("/registerHtml")
	public String register() {
		return "/register/register";
	}
	
	@ResponseBody
	@RequestMapping("/registerNewUser")
	public void registerNewUser(HttpServletRequest req) {
		userServices.getAll();
	}

}
