package com.usersbooking.user.service;

import java.util.List;

import com.usersbooking.user.model.Offerings;
import com.usersbooking.user.model.User;
import com.usersbooking.user.model.UserOfferings;

public interface UserBookingService {

	
	public User saveUser(User user);
	
	public UserOfferings userBookings(UserOfferings bookings);
	
	public List<Offerings> offeringsList();
	
	public List<Offerings> getPastOfferings(long userId);
	
}
