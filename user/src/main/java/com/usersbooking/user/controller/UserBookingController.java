package com.usersbooking.user.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usersbooking.user.model.Offerings;
import com.usersbooking.user.model.User;
import com.usersbooking.user.model.UserOfferings;
import com.usersbooking.user.service.UserBookingService;

@RestController
public class UserBookingController {
	
	@Autowired
	UserBookingService userBookingService;
	
	
	@GetMapping(path = "/user/test")
	public String test() {		

		return "hello";
	}
	
	
	@PostMapping(path = "/user/createuser")
	public User  userProfile(@RequestBody User user) {		
		User userprofile=userBookingService.saveUser(user);
		return userprofile;
	}
	
	@PostMapping(path = "/user/bookofferings")
	public UserOfferings  userProfile(@RequestBody UserOfferings userOfferings) {		
		UserOfferings userBookings=userBookingService.userBookings(userOfferings);
		return userBookings;
	}
	
	@GetMapping(path = "/user/getofferings", produces = "application/json")
	public List<Offerings>  getOfferings() {		
		 List<Offerings> offeringsList=	userBookingService.offeringsList();
		return offeringsList;
	}
	
	@GetMapping(path = "/user/getpastbookings", produces = "application/json")
	public List<Offerings>  getPastOfferings(@RequestParam("userid") String userId) {		
		 List<Offerings> offeringsList=	userBookingService.getPastOfferings(Long.parseLong(userId));
		return offeringsList;
	}
	
	
}
