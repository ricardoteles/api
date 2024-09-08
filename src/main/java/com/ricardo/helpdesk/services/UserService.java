package com.ricardo.helpdesk.services;

import com.ricardo.helpdesk.domain.Usuario;

public interface UserService {
    Usuario findById(Integer id);
}
