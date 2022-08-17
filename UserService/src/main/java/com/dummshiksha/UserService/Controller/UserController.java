package com.dummshiksha.UserService.Controller;


import com.dummshiksha.UserService.Service.UserService;
import com.dummshiksha.UserService.models.User;
import loginDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/userInfo")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> UserById(@PathVariable("id") int id){
        return userService.UserById(id);
    }

    @RequestMapping(value = "/remove-user/{id}", method = RequestMethod.DELETE)
    public String DeleteUserById(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "User Deleted Successfully";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String NewUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/login-auth", method = RequestMethod.POST)
    public int loginAuth(@RequestBody loginRequest credentials){
        Optional<User> user = userService.userLogin(credentials);
        if (user.isEmpty()){
            return 404;
        } else {
            User userDetails = null;
            userDetails = user.get();
            if (Objects.equals(userDetails.getPassword(), credentials.getPassword())){
                return 200;
            } else {
                return 403;
            }
        }
    }

}
