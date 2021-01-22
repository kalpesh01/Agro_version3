package com.agro.com.controller;

import java.io.Console;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agro.com.model.Farmer;


import com.agro.com.service.FarmerService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class FarmerController {

	
	
	@Autowired
	private FarmerService frmService;
	
	
	
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/GetFarmerDetails")
	public List<Farmer> getUsers()
	{
		return frmService.getAllUsers();
	}
	
	//add product
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Farmer frmPrdct)
	{		
		return	frmService.addFarmerProduct(frmPrdct);
	}
	
	
	//returns all products
	@PostMapping("/getAllProduct")
	public List<Farmer> allProduct()
	{
			
		return frmService.getAllUsers();

	}
	
	//will search a product using Product Id
	@GetMapping("/getProductsUsingProductId")
	public List<Farmer> getProductByProductId(@RequestParam int pid )
	{	
		System.out.println(pid);
		return frmService.getProductByPId(pid);
	}
	
	//returns farmer product using userid
	@GetMapping("/getProductsUsingFarmerId")
	public List<Farmer> getFarmerProducts(@RequestParam String usrid )
	{	
		return frmService.getProductById(usrid);
	}
	
	
//	updateBid
	@PostMapping("/updateBidHighestPrice")
	public boolean updateBidHighestPrice(@RequestBody Farmer frmPrdct)
	{
		System.out.println(frmPrdct.toString());
		 frmService.updateBid(frmPrdct.getPid(),frmPrdct.getHighestBid(),frmPrdct.getWinnerId());
		 return true;
	}
	
	@GetMapping("/changeStatusInactiveBids")
	public int checkBidDates()
	{
		return frmService.checkBidDates();
	}
	
	@GetMapping("/getDetailsChangedStatus")
	public List<Farmer>	getPdetailsStatusChanged()
	{
		
//	List<Farmer>fl=frmService.getStatusChange();
//	
//		
//	for (Farmer farmer : fl) {
//		System.out.println(farmer.getHighestBid()+" "+farmer.getWinnerId()+" "+farmer.getPid());
//	}
		return frmService.getStatusChange();	
	}
	
	
	@GetMapping("/deleteExpiredBidProduct")
	public void deleteexpiredProduct(@RequestParam long pid)
	{
		 frmService.deleteExpiredProduct(pid);
	}
	
}
