package com.dummshiksha.UserService.Service;

import com.dummshiksha.UserService.models.User;
import com.dummshiksha.UserService.repository.UserRepository;
import loginDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> UserById(int id){
//        Optional<User> userData = userRepository.findById(id);
//        User user = null;
//        if (userData.isPresent()) {
//            user = userData.get();
//        }
//        return user;
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    @Transactional
    public String addUser(User user){
        userRepository.save(user);
        return "New User added successfully.";
    }

    public Optional<User> userLogin(loginRequest login){
        return userRepository.getUserFromEmail(login.getEmail());
    }

}
