package com.puja.DayPlanner.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puja.DayPlanner.model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	//User create(User user);
	
	public User findByUsername(String username);

	

}
