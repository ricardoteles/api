package com.ricardo.helpdesk.services;

import com.ricardo.helpdesk.domain.dto.UsuarioDTO;

public interface UserService {
    UsuarioDTO findById(Integer id);
}
