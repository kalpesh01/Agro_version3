package com.agro.com.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.com.model.User;

import com.agro.com.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService usrService;
	
	

	
	
	
	
	
//	@PostMapping("/sendMail")
//	public void sendMailToWinner(@RequestBody SmtpMailSender ms)
//	{
//		try {
//			String to=	ms.getWinnerId();
//			mailSenderServ.send(to,"You Win Bid : ",ms);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//		
//	}
//	
	
	@PostMapping("/sendMail")
	public boolean sendMail(@RequestBody User usr) throws MessagingException
	{
		return usrService.sendMailToWinn(usr);
		
	}
	
	
	
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
	public boolean forgetPass(@RequestBody User usr)
	{
	int res=usrService.resetPass(usr.getEmail(),usr.getPassword());
		if(res==0) 
		{
			return false;
		}else
		{
			return true;
		}
	}
	
//	/api/v1/GetUserByEmailId
	@PostMapping("/GetUserByEmailId")
	public List<User> getUserByEmail(@RequestBody User usr)
	{
		return usrService.getUserByEmail(usr.getEmail());
	}
}
