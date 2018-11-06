package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    
	public List<User> findAll();
	
	public User findById(long id);
	
	
}
