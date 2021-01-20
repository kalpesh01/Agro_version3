package com.agro.com.service;

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
}
