package com.agro.com.service;

import java.util.List;

import javax.naming.Binding;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.agro.com.model.Biddings;
import com.agro.com.repository.BindingsRepo;

@Service
@Transactional
public class BiddingService {

	
	
	@Autowired
	BindingsRepo bdngRepo;
	
	//add bid
	
	public String addBid( Biddings bdng)
	{
		bdngRepo.save(bdng);
		
		return "success.....";
	}
	
	
	
	public boolean updateBid( Biddings bdng)
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
	
	
	public List<Biddings> getBidds( String usrid )
	{	
		return bdngRepo.getBidds(usrid);
	}
	
	
	public List<Object> getHighestBid(long pid)
	{	
		return bdngRepo.getHighestBid(pid);
	}
	
	
	public List<Biddings> getBids(Biddings bdng){
		return bdngRepo.getProductBids(bdng.getPid());
	}
	
	public String findWinnerByHighestBid(Biddings bdng)
	{
		
		
		return bdngRepo.findWinner(bdng.getBid_price(),bdng.getPid());
	}
}
