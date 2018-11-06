package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
@Component
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
      
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("=======================登陸成功=======================");
		//重定向到登录页
		response.sendRedirect("/html/home/home.html");
//		Object o = authentication.getPrincipal();
//		User user = (User)o; 
//		System.out.println(user.getId());
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
