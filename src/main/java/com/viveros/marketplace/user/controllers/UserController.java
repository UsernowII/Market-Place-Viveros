package com.viveros.marketplace.user.controllers;

import com.viveros.marketplace.base.controllers.BaseController;
import com.viveros.marketplace.user.dto.UserDTO;
import com.viveros.marketplace.user.entities.User;
import com.viveros.marketplace.user.mappers.UserMapperMS;
import com.viveros.marketplace.user.services.interfaces.UserDAO;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserDAO> {

    protected UserMapperMS userMapperMS;

    public UserController(UserDAO service, UserMapperMS userMapperMS) {
        super(service);
        this.userMapperMS = userMapperMS;
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

    @GetMapping("/2")
    public ResponseEntity<?> getAllII() {
        List<User> users = (List<User>) this.service.findAll();
        List<UserDTO> usersDTOS = users.stream()
                .map()
                .collect(Collectors.toList());
        return  ResponseEntity.ok().body(usersDTOS);
    }
}
