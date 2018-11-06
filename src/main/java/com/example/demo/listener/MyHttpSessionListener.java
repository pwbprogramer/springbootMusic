package com.example.demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    
	private int num = 0;
	@Override
	public void sessionCreated(HttpSessionEvent httpSession) {
		num++;
		System.out.println(httpSession.getSession().getId()+" :sessionCreated"+"当前人数："+num);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSession) {
		num--;
		System.out.println(httpSession.getSession().getId()+" :sessionDestroyed"+"当前人数："+num);
	}

}
