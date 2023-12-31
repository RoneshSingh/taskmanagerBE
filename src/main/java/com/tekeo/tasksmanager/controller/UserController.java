package com.tekeo.tasksmanager.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tekeo.tasksmanager.model.User;
import com.tekeo.tasksmanager.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
	
	// REGISTER NEW USER
	@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = { "Content-Type" })
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User userCreate) {
		
		try {
			String userName = userCreate.getUserName();
			boolean userExists = userService.userExists(userName);
	        if (userExists) {
	            return ResponseEntity.badRequest().body("User already exists, please select a new username.");
	        }
			
			userCreate.setUserID(UUID.randomUUID().toString().split("-")[0]);
			this.userService.createUser(userCreate);
			return ResponseEntity.ok("User created successfully.");
		} catch (Exception e) {
		      e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		    }
		
	}

	
	// SHOW ALL USER
	@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = { "Content-Type" })
	@GetMapping("/showusers")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
//	// VALIDATE REGISTER USER
//	@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = { "Content-Type" })
//	@GetMapping("/validateuser/{userName}")
//	public ResponseEntity<UserValidation> validateUser(@PathVariable String userName) {
//		boolean userExists = userService.userExists(userName);
//
//		UserValidation response = new UserValidation(userExists);
//		return ResponseEntity.ok(response);
//	}
//	
	// VALIDATE LOGIN USER
		@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = { "Content-Type" })
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody User user) {
			 String userName = user.getUserName();
			    String password = user.getPassword();

			    User loggedInUser = userService.validateLoginAndGetUser(userName, password);
			    
			    if (loggedInUser != null) {
			        return ResponseEntity.ok(loggedInUser);
			    } else {
			    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
			    }
		}
		
		
	
		///GETTING USER BY ID
		@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = { "Content-Type" })
		@GetMapping("/{userID}")
		public User getUser(@PathVariable String userID) {
			return userService.getUserById(userID);
		}
		
		///GETTING USER BY USERNAME
		
		@GetMapping("/username/{userName}")
		public User getUserByUsername(@PathVariable String userName) {
		    return userService.getUserByUserName(userName);
		}

}