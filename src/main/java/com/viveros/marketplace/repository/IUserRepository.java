package com.viveros.marketplace.repository;

import com.viveros.marketplace.models.Auth;
import com.viveros.marketplace.user.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {

    void create(User user);

    User getUserByCredentials(Auth auth);
}
