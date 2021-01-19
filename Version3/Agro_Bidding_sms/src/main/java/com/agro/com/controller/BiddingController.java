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
import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Bidding")
public class BiddingController {
	
	@Autowired
	BindingsRepo bdngRepo;
	
	//add bid
	@PostMapping("/addBid")
	public String addBid(@RequestBody Biddings bdng)
	{
		bdngRepo.save(bdng);
		
		return "success.....";
	}
	
	
	@PostMapping("/updateBid")
	public boolean updateBid(@RequestBody Biddings bdng)
	{
	List<Biddings> bd=	bdngRepo.checkBidder(bdng.getPid(),bdng.getBuyerId());
		if(bd.isEmpty())
		{
			bdngRepo.save(bdng);
			return true;
		}else {
			bdngRepo.updateBid(bdng.getBuyerId(),bdng.getBid_price(),bdng.getPid());
			return false;
		}
		
		
		
	}
	
	@GetMapping("/getBiddingsOnId")
	public List<Biddings> getBidds(@RequestParam String usrid )
	{	
		return bdngRepo.getBidds(usrid);
	}
	
	//it will return highest bid
	@GetMapping("/getHighestBid")
	public List<Object> getHighestBid(@RequestParam long pid)
	{	
		return bdngRepo.getHighestBid(pid);
		
		

	}
	
}
