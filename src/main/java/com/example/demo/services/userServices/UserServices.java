package com.example.demo.services.userServices;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserServices {
	
	@Resource
	UserRepository UserRepository;
	
	public void getAll() {
		List<User> userAble=UserRepository.findAll();
		Iterator<User> user = userAble.iterator();
		while(user.hasNext()) {
			User user1 = user.next();
			System.out.println(user1.getUsername());
		}
	}

}
