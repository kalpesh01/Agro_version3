package com.agro.com.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agro.com.model.Farmer;
import com.agro.com.repository.FarmerRepo;

@Service
@Transactional
public class FarmerService {
	@Autowired
	private FarmerRepo frmRepo;
	
	
	
	
	
	public List<Farmer> getAllUsers()
	{
		return frmRepo.findAll();
	}
	
	public String addFarmerProduct(Farmer frmPrdct)
	{
				
		frmRepo.save(frmPrdct);
		
		return "success.....";
	}
	
	public List<Farmer> getProductById(String usrid)
	{
		return frmRepo.getProducts(usrid);
	}
	
	
	public List<Farmer> getProductByPId(long pid)
	{
		return frmRepo.getProductByProductId(pid);
	}
	
	
	public	void updateBid(long pid,double highest_bid,String winnerid)
	{
		frmRepo.updateHighestBidPrice(pid,highest_bid,winnerid);
	}
	
	//To check the BidEndDates is less than current date
	public int checkBidDates()
	{
		LocalDate dt=java.time.LocalDate.now(); 
		return frmRepo.updateBidEndDates(true,dt);
	}
	
	//get all records from farmer table where status are changed to true
	public List<Farmer> getStatusChange()
	{
		return frmRepo.getStatusChange(true);
	}
	
	
public void deleteExpiredProduct(long pid) {
		
//		return frmRepo.deleteExpiredRecord(pid);
	frmRepo.deleteById(pid);
}

	
}
