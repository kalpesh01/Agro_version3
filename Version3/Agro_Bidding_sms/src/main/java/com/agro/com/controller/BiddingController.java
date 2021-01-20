package com.agro.com.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agro.com.model.Biddings;

import com.agro.com.repository.BindingsRepo;
import com.agro.com.service.BiddingService;
import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Bidding")
public class BiddingController {
	
	@Autowired
	BiddingService bdngservice;
	
	//add bid
	@PostMapping("/addBid")
	public String addBidd(@RequestBody Biddings bdng)
	{
		return bdngservice.addBid(bdng);
		
		
	}
	
	
	@PostMapping("/updateBid")
	public boolean updateBiddDetails(@RequestBody Biddings bdng)
	{
		return bdngservice.updateBid(bdng);
	}
	
	@GetMapping("/getBiddingsOnId")
	public List<Biddings> getBidds(@RequestParam String usrid )
	{	
		return bdngservice.getBidds(usrid);
	}
	
	//it will return highest bid
	@GetMapping("/getHighestBid")
	public List<Object> getHighestBid(@RequestParam long pid)
	{	
		return bdngservice.getHighestBid(pid);
	}
	
}
