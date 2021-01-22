package com.agro.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agro.com.model.Farmer;

import com.agro.com.repository.FarmerRepo;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class FarmerController {

	@Autowired
	private FarmerRepo frmRepo;
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/GetFarmerDetails")
	public List<Farmer> getUsers()
	{
		return frmRepo.findAll();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Farmer frmPrdct)
	{
			
		System.out.println(frmPrdct.getImg());
		
		frmRepo.save(frmPrdct);
		
		return "success.....";
	}
	
	
	@PostMapping("/getAllProduct")
	public List<Farmer> allProduct()
	{
			
		return frmRepo.findAll();

	}
	
	
	
	//returns farmer product using userid
	@GetMapping("/getProductsUsingId")
	public List<Farmer> getFarmerProducts(@RequestParam String usrid )
	{	
		return frmRepo.getProducts(usrid);
	}
	
}
