package com.example.demo.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="测试")
@Controller
@RequestMapping("/login")
public class LoginController {
     
	@ApiOperation(value="测试")
	public void doLogin(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("login.html");
	}
}
