package com.usersbooking.user.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usersbooking.user.dao.UserDao;
import com.usersbooking.user.dao.UserOfferingsDao;
import com.usersbooking.user.feignclient.PhotographerClient;
import com.usersbooking.user.model.Offering;
import com.usersbooking.user.model.Offerings;
import com.usersbooking.user.model.User;
import com.usersbooking.user.model.UserOfferings;
import com.usersbooking.user.service.UserBookingService;

import feign.Param;

@Service
public class UserBookingServiceImpl implements UserBookingService {

	@Autowired
	UserDao userDao;

	@Autowired
	UserOfferingsDao userOfferingsDao;

	@Autowired
	PhotographerClient photographerClient;

	@Override
	public User saveUser(User user) {
		User user2 = userDao.save(user);
		return user2;
	}

	@Override
	public List<Offerings> offeringsList() {
		return photographerClient.listOfferings();
	}

	@Override
	public UserOfferings userBookings(UserOfferings bookings) {

		UserOfferings booking = userOfferingsDao.save(bookings);

		return booking;
	}

	@Override
	public List<Offerings> getPastOfferings(long userId) {
		List<Offerings> list = new ArrayList<>();
		
		List<UserOfferings> bookingsList= userOfferingsDao.getUserOfferings(userId);
		bookingsList.stream().map(UserOfferings::getOfferingid).
		forEach(offeringId->{
			List<Offerings> offerings= photographerClient.getPastOfferings( String.valueOf(offeringId));
			list.addAll(offerings);
		});
				
		return list;
	}

}
