package com.ricardo.helpdesk.services.impl;

import com.ricardo.helpdesk.domain.Usuario;
import com.ricardo.helpdesk.repositories.UsuarioRepository;
import com.ricardo.helpdesk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario findById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
