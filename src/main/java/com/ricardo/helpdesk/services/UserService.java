package com.ricardo.helpdesk.services;

import com.ricardo.helpdesk.domain.User;

public interface UserService {
    User findById(Integer id);
}
