package com.agro.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.agro.com.model.User;
import com.agro.com.repository.UserRepo;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo usrRepo;
	
	public List<User> getAllUsers()
	{
	
		return usrRepo.findAll();
	}
	
	
	public List<User> getUserById(long id)
	{
		return usrRepo.getUser(id);
	}
	
	public String addUserData(User usr)
	{
		usrRepo.save(usr);
		return "success.....";
	}
	
	
	public List<User> validateUser( String email,String pass)
	{	
		return usrRepo.verifyUserDetails(email,pass);	
	}
	
	
	public boolean verifyUserEmail(String email)
	{
		String str=	usrRepo.verifyUserEmail(email)	;
		
		if(str != null)
		{
			String[] arr = str.split(","); 
			  
		    if(arr[3] != "")
		    {
		    	return true;
		    }
		}
			
			return false;
	}
	
	
	
	public String resetPass(String email,String pass)
	{
		usrRepo.updatePass( email,pass);
		return "success";
	}
}
