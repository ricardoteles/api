package com.ricardo.helpdesk.services;

import com.ricardo.helpdesk.domain.dto.UsuarioDTO;

import java.util.List;

public interface UserService {
    UsuarioDTO findById(Integer id);

    List<UsuarioDTO> findAll();
}
