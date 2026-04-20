package project_User_Management.controller;

import org.springframework.web.bind.annotation.RestController;

import project_User_Management.services.UsersServices;

@RestController
public class UsersController {
	
	UsersServices services;

	public UsersController(UsersServices services) {
		super();
		this.services = services;
	}
	

}
