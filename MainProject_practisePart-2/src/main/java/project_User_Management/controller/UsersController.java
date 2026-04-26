package project_User_Management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project_User_Management.dto.UsersRequestDto;
import project_User_Management.dto.UsersResponseDto;
import project_User_Management.dto.UsersUpdateRequestDto;
import project_User_Management.services.UsersServices;

@RestController
public class UsersController {
	
	UsersServices services;

	   public UsersController(UsersServices services) {
		super();
		this.services = services;
	   }
	    @PostMapping("/register")
	    public String register(@RequestBody UsersRequestDto user) {
	    	return services.register(user);
       }
	    @GetMapping("/searchUser/{id}")
	    public UsersResponseDto searchUser(@PathVariable Long id) {
	    	return services.searchUser(id);
	   }    
	    @GetMapping("/viewAllUsers")
	   public List<UsersResponseDto> viewAllUsers(){
		   return services.viewAllUsers();
	   }    
	    @PutMapping("/updateUser")
	   public  UsersResponseDto updateUser(@RequestBody UsersUpdateRequestDto userDto) {
		   return services.updateUser(userDto);
	   }   
	    @DeleteMapping("/deleteUser/{id}")
	    String deleteUser(@PathVariable Long id) {
			return services.deleteUser(id);	
	   }
	    
}

