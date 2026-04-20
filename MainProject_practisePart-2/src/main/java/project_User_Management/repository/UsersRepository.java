package project_User_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project_User_Management.entity.Users;

public interface UsersRepository extends JpaRepository<Users , Long> {

}
