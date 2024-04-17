package com.example.mongo_db.repository;

import com.example.mongo_db.documents.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository <Usuario, String>{
}
