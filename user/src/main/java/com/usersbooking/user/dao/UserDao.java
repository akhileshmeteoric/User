package com.usersbooking.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usersbooking.user.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
	

}
