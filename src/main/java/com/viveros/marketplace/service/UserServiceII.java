package com.viveros.marketplace.service;

import com.viveros.marketplace.models.Auth;
import com.viveros.marketplace.user.entities.User;
import com.viveros.marketplace.repository.IUserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class UserServiceII implements IUserRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserByCredentials(Auth auth) {

        // verify email
       String query = "FROM User WHERE email = :email";
       List usersFind = entityManager
               .createQuery(query)
               .setParameter("email", auth.getEmail())
               .getResultList();

        if ( usersFind.isEmpty()){
            return null;
        }

        User userFind = (User) usersFind.get(0);

        // verify password
        String passwordHashed = userFind.getPassword();
        System.out.printf(passwordHashed+ "PASSWORD");

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        boolean isVerified = argon2.verify(passwordHashed, auth.getPassword());

       return isVerified ? userFind : null;
    }
}


