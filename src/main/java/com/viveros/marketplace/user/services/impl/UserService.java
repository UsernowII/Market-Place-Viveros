package com.viveros.marketplace.user.services.impl;

import com.viveros.marketplace.base.services.impl.BaseDAO;
import com.viveros.marketplace.user.entities.User;
import com.viveros.marketplace.user.repositories.UserRepository;
import com.viveros.marketplace.user.services.interfaces.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseDAO<User, UserRepository> implements UserDAO{

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }
}
