package project_User_Management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project_User_Management.dto.UsersRequestDto;
import project_User_Management.dto.UsersResponseDto;
import project_User_Management.entity.Users;
import project_User_Management.repository.UsersRepository;

@Service
public class UsersServicesImplementations implements UsersServices {
   
	 UsersRepository repo ;
	 PasswordEncoder passwordEncoder;
	 
	 
	public UsersServicesImplementations(UsersRepository repo) {
		super();
		this.repo = repo;
	}
	
	public UsersServicesImplementations(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public String register(UsersRequestDto userDto) {
		Users usr = new Users();
        usr.setUsername(userDto.getUsername());
        usr.setEmail(userDto.getEmail());
        usr.setPassword(passwordEncoder.encode(userDto.getPassword()));
        usr.setMobile(userDto.getMobile());
        usr.setDob(userDto.getDob());
        usr.setGender(userDto.getGender());
        usr.setAddress(userDto.getAddress());
        usr.setDpUrl(userDto.getDpUrl());
        
        repo.save(usr);
		return "User Registerd successfully!";
	}

	@Override
	public UsersResponseDto searchUser(Long id) {
		Users user = repo.findById(id).get();
		return null;
	}

	@Override
	public List<UsersResponseDto> viewAllUsers() {
		return repo.findAll();
	
	}

	@Override
	public String updateUser(Users user) {
	
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		
		return null;
	}
	
	
}
