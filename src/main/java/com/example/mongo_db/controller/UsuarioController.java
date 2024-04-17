package com.example.mongo_db.controller;

import com.example.mongo_db.documents.Usuario;
import com.example.mongo_db.repository.UsuarioRepository;
import com.example.mongo_db.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins="http://127.0.0.1:3456")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usr_rep;

    @Autowired
    private UsuarioService usr_service;


    @GetMapping("/test")
    public ResponseEntity<String> endpointTest(){


        /*Creacion de un usuario*/
        //var usuario = new Usuario("Brenda Cruz", "cr_bren@gmail.com", new Date());
        //System.out.println(usr_rep.save(usuario));

        //List<Materia> materias = new ArrayList<>();
        List<Usuario> usuarios = usr_service.getUsuarios();

        for(Usuario i : usuarios){
            System.out.println(i);
        }



        //var storage_user = usr_rep.findAllById("660e415dc9fea13d4d7ff7b3");


        /*
         *
         *
         * obtiene un usuario por id
        var storage_user = usr_rep.findById("660e415dc9fea13d4d7ff7b3");
        System.out.println(storage_user);
        *
        */




        //System.out.println(usr_rep.findAll());

        //System.out.println(usuario.toString());

        return new ResponseEntity<>("endpoint test", HttpStatus.OK);
    }


    /*Creacion de un usuario*/

    @GetMapping("/create")
    public ResponseEntity<Usuario> createUser(){

        var usuario = new Usuario("Brenda Cruz", "cr_bren@gmail.com", new Date());
        var storage_user = usr_service.InUpdUsuario(usuario);

        return new ResponseEntity<>(storage_user, HttpStatus.OK);

    }

    @PostMapping("/created_post")
    //public ResponseEntity<Editorial> save (@RequestBody Editorial editorial){
    public ResponseEntity<Usuario> createUserPost(@RequestBody Usuario user){

        if(user.getCreated_date() == null)
            user.setCreated_date(new Date());

        //System.out.println(user);

        //var usuario = new Usuario("Brenda Cruz", "cr_bren@gmail.com", new Date());
        //var storage_user = usr_rep.save(user);

        return new ResponseEntity<>(usr_service.InUpdUsuario(user), HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getUsers(){

        return new ResponseEntity<>(usr_service.getUsuarios(), HttpStatus.OK);



    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getUser(@PathVariable String id ){

        Optional<Usuario>  usuario = usr_service.getUsuario(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        usr_service.deleteUsuario(id);

        return new ResponseEntity("Usuario eliminado!", HttpStatus.OK);

    }


}
