package com.puja.DayPlanner.service;

import com.puja.DayPlanner.model.User;

public interface UserService {

	User create(User user);
	//User findByUsername(String username);
	//String validateLogin(String username);
	User findById(Long id);
	User getByUsername(String username);

}
