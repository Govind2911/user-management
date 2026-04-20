package project_User_Management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import project_User_Management.dto.UsersRequestDto;
import project_User_Management.dto.UsersResponseDto;
import project_User_Management.entity.Users;
import project_User_Management.repository.UsersRepository;

@Service
public class UsersServicesImplementations implements UsersServices {
   
	UsersRepository repo ;

	public UsersServicesImplementations(UsersRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String register(UsersRequestDto user) {
		
		return null;
	}

	@Override
	public UsersResponseDto searchUser(Long id) {
		
		return null;
	}

	@Override
	public List<UsersResponseDto> viewAllUsers() {
		
		return null;
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
