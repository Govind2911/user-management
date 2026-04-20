package project_User_Management.services;

import org.springframework.stereotype.Service;

import project_User_Management.repository.UsersRepository;

@Service
public class UsersServicesImplementations implements UsersServices {
   
	UsersRepository repo ;

	public UsersServicesImplementations(UsersRepository repo) {
		super();
		this.repo = repo;
	}
	
	
}
