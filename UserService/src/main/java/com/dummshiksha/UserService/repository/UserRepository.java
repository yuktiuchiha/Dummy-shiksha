package com.dummshiksha.UserService.repository;

import com.dummshiksha.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users where email=(?1)", nativeQuery = true)
    public Optional<User> getUserFromEmail(String email);

}
