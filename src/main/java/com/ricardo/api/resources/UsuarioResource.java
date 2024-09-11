package com.ricardo.api.resources;

import com.ricardo.api.domain.dto.UsuarioDTO;
import com.ricardo.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioResource {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO obj){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
