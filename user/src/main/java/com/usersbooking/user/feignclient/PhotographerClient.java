package com.usersbooking.user.feignclient;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usersbooking.user.model.Offerings;

@FeignClient(name="PHOTOGRAPHERS")
public interface PhotographerClient {

	@RequestMapping("/photograpgher/getofferings")
	public List<Offerings> listOfferings();
	
	@RequestMapping("/photograpgher/getofferingsbyid")
	public List<Offerings> getPastOfferings(@RequestParam("offeringids") String offeringids);
}
