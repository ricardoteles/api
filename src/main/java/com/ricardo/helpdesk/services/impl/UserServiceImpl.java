package com.ricardo.helpdesk.services.impl;

import com.ricardo.helpdesk.domain.Usuario;
import com.ricardo.helpdesk.domain.dto.UsuarioDTO;
import com.ricardo.helpdesk.repositories.UsuarioRepository;
import com.ricardo.helpdesk.services.UserService;
import com.ricardo.helpdesk.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsuarioRepository repo;

    public UsuarioDTO findById(Integer id) {
        Optional<Usuario> usuarioOpt = repo.findById(id);

        if(usuarioOpt.isPresent()) {
            return mapper.map(usuarioOpt.get(), UsuarioDTO.class);
        }

        throw new ObjectNotFoundException("Objeto não encontrado!");
    }
}
