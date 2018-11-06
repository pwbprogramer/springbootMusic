package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
@Order(1)
@WebFilter(urlPatterns="/css/bootstrap/bootstrap.min.css")
public class myFilter implements Filter{
    
	@Override
	public void destroy() {
		System.out.println("myFiler销毁");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest http=(HttpServletRequest)servletRequest;
		System.out.println(http.getRequestURI().toString());
		filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("===========================================");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("myFiler初始化");
	}

}
