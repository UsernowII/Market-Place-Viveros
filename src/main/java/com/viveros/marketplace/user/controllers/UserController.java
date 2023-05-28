package com.viveros.marketplace.user.controllers;

import com.viveros.marketplace.base.controllers.BaseController;
import com.viveros.marketplace.user.entities.User;
import com.viveros.marketplace.user.services.interfaces.UserDAO;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserDAO> {

    public UserController(UserDAO service) {
        super(service);
        entityName = "User";
    }

    @PostMapping("/registerII")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user){
        System.out.println(user);
        if(!Objects.equals(user.getPassword(), user.getRepeatPassword())) {
            new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(2, 1024, 2, user.getPassword());
        user.setPassword(hash);
        service.save(user);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
