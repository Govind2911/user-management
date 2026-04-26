package project_User_Management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project_User_Management.dto.UsersRequestDto;
import project_User_Management.dto.UsersResponseDto;
import project_User_Management.dto.UsersUpdateRequestDto;
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
		
		if(repo.existByUSername(userDto.getUsername())) {
			return "Username already exists";
		}
		
		if(repo.existByEmail(userDto.getEmail())) {
			return "Email already exist";
		}
		
		if(repo.existByMobile(userDto.getMobile())) {
			return "Mobile number is already exists";
		}
		
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
		Optional<Users>optionalUser = repo.findById(id);
		if(optionalUser.isEmpty()) {
		return null;
		}
		Users user = optionalUser.get();
		return mapToResponseDto(user);
	}

	@Override
	public List<UsersResponseDto> viewAllUsers() {
		List<Users> users = repo.findAll();
		return users.stream()
				.map(this::mapToResponseDto)
				.toList();
	}

	@Override
	public UsersResponseDto updateUser(UsersUpdateRequestDto userDto) {
	 if(userDto.getId()==null) {
		 throw new RuntimeException("User id is required");
	 }
	 
	 Optional<Users> optionalUser = repo.findById(userDto.getId());
	 
	 if(optionalUser.isEmpty()) {
		 throw new RuntimeException("User is not found");
	 }
	 
	 Users existingUser = optionalUser.get();
	 
	 if(!existingUser.getUsername().equals(userDto.getUsername())
			 && repo.existByUSername(userDto.getUsername())) {
		 throw new RuntimeException("Username already exists");
	 }
	 
	 if(!existingUser.getEmail().equals(userDto.getEmail())
			 && repo.existByEmail(userDto.getEmail())) {
		 throw new RuntimeException("Email already exists");
	 }
	  if(!existingUser.getMobile().equals(userDto.getMobile())
			  && repo.existByMobile(userDto.getMobile())) {
		  throw new RuntimeException("Mobile number already exists");
	  }
	    
	  existingUser.setUsername(userDto.getUsername());
	  existingUser.setEmail(userDto.getEmail());
	  existingUser.setMobile(userDto.getMobile());
	  existingUser.setDob(userDto.getDob());
	  existingUser.setGender(userDto.getGender());
	  existingUser.setAddress(userDto.getAddress());
	  existingUser.setDpUrl(userDto.getDpUrl());
	  
	  if(userDto.getPassword()!= null && ! userDto.getPassword().isBlank()) {
		  existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
	  }
	  
	  Users updatedUser = repo.save(existingUser);
	  return mapToResponseDto(updatedUser);
	}
	

	@Override
	public String deleteUser(Long id) {
		if(!repo.existsById(id)) {
			return "User not found";
		}
		
		repo.deleteById(id);
		return "User deleted successfully";
	}
	
	  UsersResponseDto mapToResponseDto(Users user) {
	        UsersResponseDto dto = new UsersResponseDto();
	        dto.setId(user.getId());
	        dto.setUsername(user.getUsername());
	        dto.setEmail(user.getEmail());
	        dto.setMobile(user.getMobile());
	        dto.setDob(user.getDob());
	        dto.setGender(user.getGender());
	        dto.setAddress(user.getAddress());
	        dto.setDpUrl(user.getDpUrl());
	        return dto;
	    }
}
