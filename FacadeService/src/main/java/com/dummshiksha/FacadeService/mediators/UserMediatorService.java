package com.dummshiksha.FacadeService.mediators;

import com.dummshiksha.UserService.Utils.UserFeignUtil;
import com.dummshiksha.UserService.models.User;
import loginDTO.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class UserMediatorService {

    @Autowired
    private UserFeignUtil userFeignUtil;

    public Mono<Optional<User>> userById(int UID){
        return Mono.fromCallable(()->userFeignUtil.UserById(UID));
    }

    public String removeUserById(int UID){
        return userFeignUtil.DeleteUserById(UID);
    }

    public String addUser(User user){
        return userFeignUtil.NewUser(user);
    }

    public int authenticateLoginRequest(loginRequest credentials){
        return userFeignUtil.loginAuth(credentials);
    }
}
