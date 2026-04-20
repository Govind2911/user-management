package project_User_Management.services;

import java.util.List;

import project_User_Management.dto.UsersRequestDto;
import project_User_Management.dto.UsersResponseDto;
import project_User_Management.entity.Users;

public interface UsersServices {
	
    String register(UsersRequestDto user);
    UsersResponseDto searchUser(Long id);
    List<UsersResponseDto> viewAllUsers();
    String updateUser(Users user);
    String deleteUser(Long id);
    
}
