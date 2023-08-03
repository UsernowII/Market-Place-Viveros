package com.viveros.marketplace.controller;

import com.viveros.marketplace.models.Auth;
import com.viveros.marketplace.models.User;
import com.viveros.marketplace.service.UserService;
import com.viveros.marketplace.util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(!Objects.equals(user.getPassword(), user.getRepeatPassword())) {
            return new ResponseEntity<>("Las contraseñas no son iguales", HttpStatus.BAD_REQUEST);
        }
        System.out.println(user.toString()  );
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(2, 1024, 2, user.getPassword());
        user.setPassword(hash);
        userService.create(user);
        return new ResponseEntity<>("Registrado Exitosamente", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Auth auth){
        User userLogged = userService.getUserByCredentials(auth);

        if (userLogged == null) {
            return new ResponseEntity<>("No se encuentra registrado", HttpStatus.BAD_REQUEST);
        }
        String tokenJWT = jwtUtil.create(auth.getEmail());
        return new ResponseEntity<>(tokenJWT, HttpStatus.OK);
    }

}
