package com.example.mongo_db.service;

import com.example.mongo_db.documents.Usuario;
import com.example.mongo_db.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usr_repository;

    public Usuario InUpdUsuario(Usuario usuario){
        return usr_repository.save(usuario);

    }

    public Optional<Usuario> getUsuario(String id){
        return usr_repository.findById(id);
    }

    public List<Usuario> getUsuarios(){
        return usr_repository.findAll();

    }

    public void deleteUsuario(String id){
        usr_repository.deleteById(id);
    }



}
