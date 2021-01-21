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
import com.agro.com.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService usrService;
	
	
	@Autowired
	private UserRepo usrRepo;
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/GetUsers")
	public List<User> getUsers()
	{
		return usrService.getAllUsers();
	}
	
	//getuserbyid
	@GetMapping("/GetUser")
	public List<User> getUser(@RequestBody User usr)
	{
		return usrService.getUserById(usr.getId());
	}
	
	
	
	@PostMapping("/addusr")
	public String addUser(@RequestBody User usr)
	{
		return usrService.addUserData(usr);
		
	}
	
	@PostMapping("/validateUser")
	public List<User> verifyUser(@RequestBody User usr)
	{	
		return usrService.validateUser(usr.getEmail(),usr.getPassword());	
	}
	
	@PostMapping("/validateUserEmail")
	public boolean verifyEmail(@RequestBody User usr)
	{
		
		return	usrService.verifyUserEmail(usr.getEmail())	;

	}
	
	@PostMapping("/forgetpassword")
	public String forgetPass(@RequestBody User usr)
	{
		
		return usrService.resetPass(usr.getEmail(),usr.getPassword());
	}
	
}
