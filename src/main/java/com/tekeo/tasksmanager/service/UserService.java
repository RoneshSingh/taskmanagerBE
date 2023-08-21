package com.tekeo.tasksmanager.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekeo.tasksmanager.model.User;
import com.tekeo.tasksmanager.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo= userRepo;
    }
	
	
	//Get All Users
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	//Create User
		public User createUser(User user) {
			
			return userRepo.save(user);
		}
		
	//Get Single User by ID
	public User getUserById(String userID) {
		return userRepo.findById(userID).get();
	}
	
	// CHECK IF USER ALREADY EXISTS FOR REGISTRATION
		public boolean userExists(String userName) {
			return userRepo.existsByUserName(userName);
		}
	
	//Get Single User by userName
	public User getUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	

	// CHECK USER FOR LOGIN
		public User validateLoginAndGetUser(String username, String password) {
		    User user = userRepo.findByUserName(username);
		    
		    if (user != null && user.getPassword().equals(password)) {
		        return user;
		    }
		    
		    return null;
		}
	
}