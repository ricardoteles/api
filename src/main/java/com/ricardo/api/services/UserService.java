package com.ricardo.api.services;

import com.ricardo.api.domain.dto.UsuarioDTO;

import java.util.List;

public interface UserService {
    UsuarioDTO findById(Integer id);
    List<UsuarioDTO> findAll();
    UsuarioDTO create(UsuarioDTO obj);
    UsuarioDTO update(UsuarioDTO obj);
    void delete(Integer id);
}
