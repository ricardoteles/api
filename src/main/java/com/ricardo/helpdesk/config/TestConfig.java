package com.ricardo.api.config;

import com.ricardo.api.domain.Usuario;
import com.ricardo.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private UsuarioRepository repo;

    @Bean
    public boolean iniciaDB(){
        Usuario u1 = new Usuario(null,"Ricardo", "ricardo@email.com", "123");
        Usuario u2 = new Usuario(null,"Maria", "maria@email.com", "123");

        repo.saveAll(List.of(u1, u2));

        return true;
    }
}
