package com.ricardo.api.services.impl;

import com.ricardo.api.domain.Usuario;
import com.ricardo.api.domain.dto.UsuarioDTO;
import com.ricardo.api.repositories.UsuarioRepository;
import com.ricardo.api.services.UserService;
import com.ricardo.api.services.exceptions.DataIntegratyViolationException;
import com.ricardo.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UsuarioDTO> findAll() {
        return repo.findAll().stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList());
    }

    public UsuarioDTO create(UsuarioDTO obj) {
        findByEmail(obj);
        Usuario novoUsuario = mapper.map(obj, Usuario.class);

        return mapper.map(repo.save(novoUsuario), UsuarioDTO.class);
    }

    public UsuarioDTO update(UsuarioDTO obj) {
        findByEmail(obj);
        Usuario novoUsuario = mapper.map(obj, Usuario.class);

        return mapper.map(repo.save(novoUsuario), UsuarioDTO.class);
    }

    public void delete(Integer id) {
        findById(id);
        repo.deleteById(id);
    }

    private void findByEmail(UsuarioDTO obj) {
        Optional<Usuario> usuario = repo.findByEmail(obj.getEmail());

        if(usuario.isPresent() && !usuario.get().getId().equals(obj.getId()))
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
    }
}
