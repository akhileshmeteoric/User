package com.usersbooking.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usersbooking.user.model.UserOfferings;

public interface UserOfferingsDao extends JpaRepository<UserOfferings, Long> {

	@Query("from UserOfferings c where c.id=?1")
	public List<UserOfferings> getUserOfferings(long id);
}
