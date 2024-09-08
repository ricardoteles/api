package com.ricardo.helpdesk.services.impl;

import com.ricardo.helpdesk.domain.User;
import com.ricardo.helpdesk.repositories.UserRepository;
import com.ricardo.helpdesk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public User findById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
