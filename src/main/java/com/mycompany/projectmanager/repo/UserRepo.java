package com.mycompany.projectmanager.repo;

import com.mycompany.projectmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    @Query("SELECT u from User u WHERE u.username =?1 AND u.password=?2" )
    Optional<Object> findByUsernameAndPassword(String username, String password);


    @Query("SELECT u from User u WHERE u.adminRole =?1 " )
    Optional<Object> findByAllAdmins(char adminRole);

    User findUserByUsername(String username);
}