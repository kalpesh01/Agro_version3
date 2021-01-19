package com.agro.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.com.model.User;
import com.agro.com.repository.UserRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepo usrRepo;
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/GetUsers")
	public List<User> getUsers()
	{
		return usrRepo.findAll();
	}
	
	
	//getuserbyid
	@GetMapping("/GetUser")
	public List<User> getUser(@RequestBody User usr)
	{
		return usrRepo.getUser(usr.getId());
	}
	
	@PostMapping("/addusr")
	public String addUser(@RequestBody User usr)
	{
		usrRepo.save(usr);
		return "success.....";
	}
	
	
	@PostMapping("/validateUser")
	public List<User> verifyUser(@RequestBody User usr)
	{
		
		return usrRepo.verifyUserDetails(usr.getEmail(),usr.getPassword());
		
	}
	
	@PostMapping("/validateUserEmail")
	public boolean verifyEmail(@RequestBody User usr)
	{
		
	String str=	usrRepo.verifyUserEmail(usr.getEmail())	;
	
	if(str != null)
	{
		String[] arr = str.split(","); 
		  
	    if(arr[3] != "")
	    {
	    	return true;
	    }
	}
	
//	return usrRepo.verifyUserEmail(usr.getEmail());
		
		return false;
	
	}
	
	@PostMapping("/forgetpassword")
	public String forgetPass(@RequestBody User usr)
	{
		
		 usrRepo.updatePass(usr.getEmail(),usr.getPassword());
		 
		return "successfully updated";
		
//	String str=	usrRepo.updatePass(usr.getEmail(),usr.getPassword());
	
//	if(str != null)
//	{
//		String[] arr = str.split(","); 
//		  
//	    if(arr[3] != "")
//	    {
//	    	return true;
//	    }
//	}
//	
////	return usrRepo.verifyUserEmail(usr.getEmail());
//		
//		return false;
	
	}
	
}
