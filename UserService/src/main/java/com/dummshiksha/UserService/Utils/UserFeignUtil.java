package com.dummshiksha.UserService.Utils;

import com.dummshiksha.UserService.models.User;
import loginDTO.loginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(value = "UserService", url = "${user.service.url}")
public interface UserFeignUtil {

    @RequestMapping(value = "id", method = RequestMethod.GET)
    Optional<User> UserById(@PathVariable("id") int id);

    @RequestMapping(value = "/remove-user/{id}", method = RequestMethod.DELETE)
    String DeleteUserById(@PathVariable("id") int id);

    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    String NewUser(@RequestBody User user);

    @RequestMapping(value = "/login-auth", method = RequestMethod.POST)
    int loginAuth(@RequestBody loginRequest credentials);
}
