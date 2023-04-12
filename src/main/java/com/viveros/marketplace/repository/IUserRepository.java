package com.viveros.marketplace.repository;

import com.viveros.marketplace.models.Auth;
import com.viveros.marketplace.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {

    void create(User user);

    User getUserByCredentials(Auth auth);
}
